import java.util.Arrays;
import java.util.Scanner;

public class A24 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int[] A = new int[n];
        A = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int m = Integer.parseInt(scanner.nextLine());
        int[] B = new int[m];
        B = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        scanner.close();
        System.out.println(LCS(A, B));
    }

    private static int LCS(int[] A, int[] B) {
        int n = A.length;
        int m = B.length;
        int[][] table = new int[n + 1][m + 1];
        fillTable(table);
        for (int i = 1; i < table.length; i++) {
            for (int j = 1; j < table[i].length; j++) {
                table[i][j] = table[i - 1][j];
                table[i][j] = Math.max(table[i][j], table[i][j - 1]);
                if (A[i - 1] == B[j - 1]) {
                    table[i][j] = Math.max(table[i][j], table[i - 1][j - 1] + 1);
                }
            }
        }
        return table[n][m];
    }

    private static void fillTable(int[][] table) {
        for (int i = 0; i < table.length; i++) {
            table[i][0] = 0;
            for (int j = 0; j < table[i].length; j++) {
                table[0][j] = 0;
            }
        }
    }
}
