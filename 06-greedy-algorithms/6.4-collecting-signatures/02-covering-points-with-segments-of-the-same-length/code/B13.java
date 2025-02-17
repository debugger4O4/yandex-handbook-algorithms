import java.util.Arrays;
import java.util.Scanner;

public class B13 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] data1 = scanner.nextLine().split(" ");
        int n = Integer.parseInt(data1[0]);
        long L = Long.parseLong(data1[1]);
        long[] coordinates = new long[n];
        coordinates = Arrays.stream(scanner.nextLine().split(" ")).mapToLong(Long::parseLong).sorted().toArray();
        scanner.close();
        int count = 0;
        Long r = null;
        for (Long x : coordinates) {
            if (r == null || x > r) {
                count++;
                r = x + L;
            }
        }
        System.out.println(count);
    }
}
