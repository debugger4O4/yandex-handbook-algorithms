import java.util.Arrays;
import java.util.Scanner;

public class D16 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] data = scanner.nextLine().split(" ");
        int n = Integer.parseInt(data[0]);
        int k = Integer.parseInt(data[1]);
        int[] x = new int[n];
        x = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).sorted().distinct().toArray();
        scanner.close();
        System.out.println(result(k, x));
    }

    private static int result(int k, int[] x) {
        if (k >= x.length) {
            return 0;
        }
        int min = 0;
        int max = x[x.length - 1] - x[0];
        while (min != max) {
            int mid = min + (max - min) / 2;
            if (mid == max || mid == min) {
                return max;
            }
            if (rightLength(mid, k, x)) {
                max = mid;
            } else {
                min = mid;
            }
        }
        return max;
    }

    private static boolean rightLength(int mid, int k, int[] x) {
        int end = x[0] + mid;
        k--;
        for (int i : x) {
            if (end < i) {
                k--;
                end = i + mid;
                if (k < 0) {
                    return false;
                }
            }
        }
        return true;
    }
}
