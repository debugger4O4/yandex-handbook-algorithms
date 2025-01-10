import java.util.Arrays;
import java.util.Scanner;

public class B2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] coordinates = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        String[][] rocks = fill(coordinates[0], coordinates[1]);
        scanner.close();
        System.out.println(rocks[coordinates[0]][coordinates[1]]);
    }

    public static String[][] fill(int n, int m) {
        String[][] R = new String[n + 1][m + 1];
        R[0][0] = "Lose";
        for (int i = 1; i < R.length; i++) {
            if (i % 3 == 0) {
                R[i][0] = "Lose";
            } else {
                R[i][0] = "Win";
            }
        }
        for (int j = 1; j < R[0].length; j++) {
            if (j % 3 == 0) {
                R[0][j] = "Lose";
            } else {
                R[0][j] = "Win";
            }
        }
        for (int i = 1; i < R.length; i++) {
            for (int j = 1; j < R[i].length; j++) {
                if (R[i - 1][j - 1].equals("Lose") && R[i][j - 1].equals("Win") && R[i - 1][j].equals("Win")) {
                    R[i][j] = "Lose";
                } else {
                    R[i][j] = "Win";
                }
            }
        }
        return R;
    }
}
