import java.util.Arrays;
import java.util.Scanner;

public class A25 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int[] A = new int[n];
        A = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int m = Integer.parseInt(scanner.nextLine());
        int[] B = new int[m];
        B = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int l = Integer.parseInt(scanner.nextLine());
        int[] C = new int[l];
        C = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        scanner.close();
        System.out.println(LCS(A, B, C));
    }

    private static int LCS(int[] A, int[] B, int[] C) {
        int n = A.length;
        int m = B.length;
        int l = C.length;
        int[][][] table = new int[n + 1][m + 1][l + 1];
        fillTable(table);
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                for (int k = 1; k <= l; k++) {
                    table[i][j][k] = Math.max(
                            Math.max(table[i - 1][j][k], table[i][j - 1][k]),
                            table[i][j][k - 1]
                    );

                    if (A[i - 1] == B[j - 1] && B[j - 1] == C[k - 1]) {
                        table[i][j][k] = Math.max(table[i][j][k], table[i - 1][j - 1][k - 1] + 1);
                    }
                }
            }
        }
        return table[n][m][l];
    }

    private static void fillTable(int[][][] table) {
        for (int i = 0; i < table.length; i++) {
            table[i][0][0] = 0;
            for (int j = 0; j < table[i].length; j++) {
                table[0][j][0] = 0;
                for (int k = 0; k < table[i][j].length; k++) {
                    table[0][0][k] = 0;
                }
            }
        }
    }
}
