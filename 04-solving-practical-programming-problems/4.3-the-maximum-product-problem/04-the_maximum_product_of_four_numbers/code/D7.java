import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;

public class D7 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        BigInteger[] nums = new BigInteger[n];
        nums = Arrays.stream(scanner.nextLine().split(" ")).map(BigInteger::new).toArray(BigInteger[]::new);
        scanner.close();
        if (nums.length == 4) {
            System.out.println(Arrays.stream(nums).reduce(BigInteger::multiply).get());
            return;
        }

        swaps(nums, 0, n - 1, n - 5);
        swaps(nums, 0, n - 1, n - 3);
        swaps(nums, 0, n - 1, 2);
        swaps(nums, 0, n - 1, 4);

        BigInteger top = nums[n - 1].multiply(nums[n - 2])
                .multiply(nums[n - 3])
                .multiply(nums[n - 4]);
        BigInteger bottom = nums[0].multiply(nums[1])
                .multiply(nums[2])
                .multiply(nums[3]);
        BigInteger middle = nums[0].multiply(nums[1])
                .multiply(nums[n - 1])
                .multiply(nums[n - 2]);

        if (top.compareTo(bottom) > 0 && top.compareTo(middle) > 0) {
            System.out.println(top);
            return;
        }

        if (bottom.compareTo(top) > 0 && bottom.compareTo(middle) > 0) {
            System.out.println(bottom);
            return;
        }

        System.out.println(middle);
    }


    private static void swaps(BigInteger[] numbers, int left, int right, int k) {
        if (left >= right) {
            return;
        }

        int pivot = parts(numbers, left, right);

        if (k < pivot) {
            swaps(numbers, left, pivot - 1, k);
        } else {
            swaps(numbers, pivot, right, k);
        }
    }

    private static int parts(BigInteger[] numbers, int left, int right) {
        BigInteger pivot = numbers[left + (right - left) / 2];

        while (left <= right) {
            while (numbers[left].compareTo(pivot) < 0) {
                left++;
            }

            while (numbers[right].compareTo(pivot) > 0) {
                right--;
            }

            if (left <= right) {
                swap(numbers, left, right);
                left++;
                right--;
            }
        }

        return left;
    }

    private static void swap(BigInteger[] nums, int from, int to) {
        BigInteger prev = nums[from];
        nums[from] = nums[to];
        nums[to] = prev;
    }
}
