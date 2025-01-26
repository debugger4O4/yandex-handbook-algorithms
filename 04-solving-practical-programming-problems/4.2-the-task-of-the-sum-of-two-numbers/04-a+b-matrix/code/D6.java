import java.util.Arrays;
import java.util.Scanner;

public class D6 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String rowsAndCols = scanner.nextLine();
        int rows = Integer.parseInt(rowsAndCols.split(" ")[0]);
        int cols = Integer.parseInt(rowsAndCols.split(" ")[1]);
        int[][] matrixA = fillMatrix(rows, cols, scanner);
        int[][] matrixB = fillMatrix(rows, cols, scanner);
        scanner.close();
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < matrixA.length; i++) {
            for (int j = 0; j < matrixA[i].length; j++) {
                result.append(matrixA[i][j] + matrixB[i][j]).append(" ");
            }
            result.append("\n");
        }
        System.out.println(result.toString().trim());
    }

    public static int[][] fillMatrix(int rows, int cols, Scanner scanner) {
        int[][] matrix = new int[rows][cols];
        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        return matrix;
    }
}
