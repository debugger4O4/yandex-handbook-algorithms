import java.util.Scanner;

public class A8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.close();
        if (n <= 1) {
            System.out.println(n);
            return;
        }

        int previous = 0;
        int current = 1;
        for (int i = 2; i <= n; i++) {
            int oldPrevious = previous;
            previous = current;
            current = oldPrevious + previous;
        }
        System.out.println(current);
    }
}
