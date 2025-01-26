import java.util.Arrays;
import java.util.Scanner;

public class A7 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        long[] arr = new long[n];
        arr = Arrays.stream(scanner.nextLine().split(" ")).mapToLong(Long::parseLong).toArray();
        scanner.close();
        long max1 = Math.max(arr[0], arr[1]);
        long max2 = Math.min(arr[0], arr[1]);

        if (arr.length == 2) {
            System.out.println(max1 * max2);
            return;
        }

        for (int i = 2; i < n; i++) {
            long current = arr[i];

            if (current > max1) {
                max2 = max1;
                max1 = current;
            } else if (current > max2) {
                max2 = current;
            }
        }

        System.out.println(max1 * max2);
   }
}
