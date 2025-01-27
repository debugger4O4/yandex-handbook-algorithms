import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class B7 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.close();
        int[] nums = new int[n];
        if (n < 7) {
            System.out.println("No");
            return;
        }
        nums[0] = n;
        for (int i = 1; i < args.length; i++) {
            nums[i] = i;
        }
        String result = Arrays.stream(nums).mapToObj(String::valueOf).collect(Collectors.joining(" "));
        System.out.println("Yes");
        System.out.println(result);
    }
}
