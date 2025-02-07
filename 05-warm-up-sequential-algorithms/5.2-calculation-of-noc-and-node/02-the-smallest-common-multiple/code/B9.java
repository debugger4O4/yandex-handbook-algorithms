import java.util.Scanner;

public class B9 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] data = scanner.nextLine().split(" ");
        scanner.close();
        long a = Long.parseLong(data[0]);
        long b = Long.parseLong(data[1]);
        long gcd = gcd(a, b);
        long result = a * b / gcd;
        System.out.println(result);
    }

    public static long gcd(long a, long b) {
        if (a == 0 || b == 0) {
            return Math.max(a, b);
        }
        return gcd(b, a % b);
    }
}
