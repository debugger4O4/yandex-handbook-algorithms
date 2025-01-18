import java.util.Scanner;

public class A3 {

    public static int count = 0;
    public static String steps = "";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        hanoiTowers(n, 1, 3);
        scanner.close();
        System.out.println(count);
        System.out.println(steps.trim());
    }

    public static void hanoiTowers(int n, int fromPeg, int toPeg) {
        if (n == 1) {
            count++;
            steps += fromPeg + " " + toPeg + "\n";
            return;
        }
        int unusedPeg = 6 - fromPeg - toPeg;
        hanoiTowers(n - 1, fromPeg, unusedPeg);
        count++;
        steps += fromPeg + " " + toPeg + "\n";
        hanoiTowers(n - 1, unusedPeg, toPeg);
    }
}
