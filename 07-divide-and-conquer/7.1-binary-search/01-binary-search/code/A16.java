import java.util.Arrays;
import java.util.Scanner;

public class A16 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int[] K = new int[n];
        K = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int q = Integer.parseInt(scanner.nextLine());
        scanner.close();
        System.out.println(binarySearch(n, K, q));
    }

    public static int binarySearch(int n, int[] K, int q) {
        int minIndex = 0;
        int maxIndex = n - 1;
        while (maxIndex >= minIndex) {
            int midIndex = (minIndex + maxIndex) / 2;
            if (K[midIndex] == q) {
                return midIndex;
            } else if (K[midIndex] < q) {
                minIndex = midIndex + 1;
            } else {
                maxIndex = midIndex - 1;
            }
        }
        return -1;
    }
}