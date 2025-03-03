import java.util.Scanner;

public class A14 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.close();
        int result = 0;
        for (int i = (int) Math.max(1, Math.pow(n, 0.5) - 2); i < n; i++) {
            int x = (i * (i + 1)) / 2;
            if (x > n) {
                break;
            }
            result = i;
        }
        System.out.println(result);
    }
}
