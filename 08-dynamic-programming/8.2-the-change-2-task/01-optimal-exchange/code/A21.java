import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class A21 {

    private static final Map<Integer, Integer> table = new HashMap<>();


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        scanner.close();
        System.out.println(change(m));
    }

    public static int change(int money) {
        if (!table.containsKey(money)) {
            if (money == 0) {
                table.put(money, 0);
            } else {
                int result = Integer.MAX_VALUE;
                for (int c : new int[]{1, 3, 4}) {
                    if (c <= money) {
                        result = Math.min(result, 1 + change(money - c));
                    }
                }
                table.put(money, result);
            }
        }
        return table.get(money);
    }
}
