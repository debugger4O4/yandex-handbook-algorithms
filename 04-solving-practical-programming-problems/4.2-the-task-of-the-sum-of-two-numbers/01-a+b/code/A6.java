import java.util.Scanner;

public class A6 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        scanner.close();
        System.out.println(sum(a, b));
    }

    static int sum(int a, int b) {
        return a + b;
    }
}
