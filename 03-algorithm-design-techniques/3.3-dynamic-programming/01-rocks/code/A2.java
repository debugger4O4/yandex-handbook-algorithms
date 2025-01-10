import java.util.Arrays;
import java.util.Scanner;

public class A2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[][] rocks = fill();
        int[] coordinates = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        scanner.close();
        System.out.println(rocks[coordinates[0]][coordinates[1]]);
    }

    public static String[][] fill() {
        String[][] R = new String[11][11];
        R[0][0] = "Lose";
        for (int i = 1; i < R.length; i++) {
            if (R[i - 1][0].equals("Win")) {
                R[i][0] = "Lose";
            } else {
                R[i][0] = "Win";
            }
        }
        for (int j = 1; j < R[0].length; j++) {
            if (R[0][j - 1].equals("Win")) {
                R[0][j] = "Lose";
            } else {
                R[0][j] = "Win";
            }
        }
        for (int i = 1; i < R.length; i++) {
            for (int j = 1; j < R[i].length; j++) {
                if (R[i - 1][j - 1].equals("Win") && R[i][j - 1].equals("Win") && R[i - 1][j].equals("Win")) {
                    R[i][j] = "Lose";
                } else {
                    R[i][j] = "Win";
                }
             }
        }
        return R;
    }
}
