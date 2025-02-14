import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class A10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int money = Integer.parseInt(scanner.nextLine());
        scanner.close();
        List<String> result = new ArrayList<>();

        for (int ten = 0; ten <= money / 10; ten++) {
            for (int five = 0; five <= (money - (10 * ten)) / 5; five++) {
                int one = money - (10 * ten) - (5 * five);
                int steps = ten + five + one;

                String sb = steps + " " +
                        "10 ".repeat(Math.max(0, ten)) +
                        "5 ".repeat(Math.max(0, five)) +
                        "1 ".repeat(Math.max(0, one));
                result.add(sb.trim());
            }
        }
        System.out.println(result.size());
        for (int i = result.size() - 1; i >= 0; i--) {
            System.out.println(result.get(i));
        }
    }
}
