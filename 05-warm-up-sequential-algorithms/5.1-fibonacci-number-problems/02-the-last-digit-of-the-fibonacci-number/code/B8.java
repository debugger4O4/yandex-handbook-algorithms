import java.util.Scanner;

public class B8 {

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
            int oldPrevious = previous + current;
            previous = current;
            current = oldPrevious % 10;
        }
        System.out.println(current);
    }
}
