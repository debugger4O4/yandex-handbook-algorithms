import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class A27 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        scanner.close();

        List<Integer> digits = new ArrayList<>();
        List<Character> operations = new ArrayList<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (i % 2 == 0) {
                digits.add(ch - '0');
            } else {
                operations.add(ch);
            }
        }

        int n = digits.size();
        final long INF = Long.MAX_VALUE / 10;

        long[][] mins = new long[n + 1][n + 1];
        long[][] maxs = new long[n + 1][n + 1];

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                mins[i][j] = INF;
                maxs[i][j] = -INF;
            }
        }

        for (int i = 0; i < n; i++) {
            mins[i][i] = digits.get(i);
            maxs[i][i] = digits.get(i);
        }

        for (int i = 0; i < n; i++) {
            for (int l = 0; l < n - i; l++) {
                int r = l + i;
                for (int m = l; m < r; m++) {
                    for (int m_ = 1; m_ <= Math.min(4, r - m); m_++) {

                        long a = evaluate(mins[l][m], operations.get(m), mins[m + m_][r]);
                        long b = evaluate(mins[l][m], operations.get(m), maxs[m + m_][r]);
                        long c = evaluate(maxs[l][m], operations.get(m), mins[m + m_][r]);
                        long d = evaluate(maxs[l][m], operations.get(m), maxs[m + m_][r]);

                        mins[l][r] = Math.min(mins[l][r], Math.min(a, Math.min(b, Math.min(c, d))));
                        maxs[l][r] = Math.max(maxs[l][r], Math.max(a, Math.max(b, Math.max(c, d))));
                    }
                }
            }
        }

        System.out.println(maxs[0][n - 1]);
    }

    private static long evaluate(long left, char op, long right) {
        return switch (op) {
            case '+' -> left + right;
            case '-' -> left - right;
            case '*' -> left * right;
            default -> throw new IllegalArgumentException("Неподдерживаемый оператор: " + op);
        };
    }
}
