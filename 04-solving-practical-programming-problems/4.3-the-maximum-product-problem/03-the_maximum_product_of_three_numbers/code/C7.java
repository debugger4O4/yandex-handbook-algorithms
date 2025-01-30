import java.util.Arrays;
import java.util.Scanner;

public class C7 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        long[] nums = new long[n];
        nums = Arrays.stream(scanner.nextLine().split(" ")).mapToLong(Long::parseLong).toArray();
        scanner.close();
        Arrays.sort(nums);
        if (nums.length == 3) {
            System.out.println(Arrays.stream(nums).reduce((a, b) -> a * b).getAsLong());
        } else {
            System.out.println(Math.max(nums[0] * nums[1] * nums[nums.length - 1], nums[nums.length - 1] * nums[nums.length - 2] * nums[nums.length - 3]));
        }
    }
}
