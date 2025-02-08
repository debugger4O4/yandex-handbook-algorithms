import java.util.Scanner;

public class C9 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = Long.parseLong(scanner.nextLine());
        scanner.close();
        if (n == 1) {
            System.out.println("1 1");
            return;
        }
        long a = 1;
        long b = 1;
        while (a + b <= n) {
            if (a > b) {
                b += a;
            } else {
                a += b;
            }
        }
        System.out.println(Math.min(a, b) + " " + Math.max(a, b));
    }
}
