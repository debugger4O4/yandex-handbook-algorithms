import java.util.Arrays;
import java.util.Scanner;

public class A25 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] data = scanner.nextLine().split(" ");
        int W = Integer.parseInt(data[0]);
        int n = Integer.parseInt(data[1]);
        int[] w = new int[n];
        w = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        scanner.close();
        System.out.println(Knapsack(w, W));
    }


    private static int Knapsack(int[] w, int W) {
        int n = w.length;
        boolean[][] pack = new boolean[W + 1][n + 1];
        pack[0][0] = true;
        for (int i = 1; i <= w.length; ++i) {
            for (int j = 0; j <= W; ++j) {
                if (w[i - 1] > j) {
                    pack[j][i] = pack[j][i - 1];
                } else {
                    pack[j][i] = pack[j][i - 1] || pack[j - w[i - 1]][i - 1];
                }
            }
        }

        for (int i = W; i >= 0; --i) {
            if (pack[i][w.length]) {
                return i;
            }
        }

        return 0;
    }
}
