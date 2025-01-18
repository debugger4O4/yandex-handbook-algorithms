import java.util.Scanner;

public class B3 {

    public static int stepsCount = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        stepsCount = hanoiTowersStepsCount(n);
        scanner.close();
        System.out.println(stepsCount);
    }

    public static int hanoiTowersStepsCount(int n) {
        if (n <= 1 && n >= 0) {
            return n;
        }

        int k = (int) (Math.sqrt(1 + 8 * n) - 1) / 2;
        return hanoiTowersStepsCount(n - k) * 2 + (int) Math.pow(2, k) - 1;
    }
}
