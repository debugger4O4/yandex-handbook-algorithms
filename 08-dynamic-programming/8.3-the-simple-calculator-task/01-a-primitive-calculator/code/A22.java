import java.util.*;
import java.util.stream.Collectors;

public class A22 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.close();
        int[] table = new int[n + 1];
        for (int num = 2; num <= n; num++) {
            table[num] = 1 + table[num - 1];
            if (num % 2 == 0) {
                table[num] = Math.min(table[num], table[num / 2] + 1);
            }
            if (num % 3 == 0) {
                table[num] = Math.min(table[num], table[num / 3] + 1);
            }
        }
        List<Integer> operations = new ArrayList<>();
        int _n = n;
        while (_n > 1) {
            operations.add(_n);
            if (table[_n] == table[_n - 1] + 1) {
                _n -= 1;
            } else if (_n % 2 == 0 && table[_n] == table[_n / 2] + 1) {
                _n /= 2;
            } else if (_n % 3 == 0 && table[_n] == table[_n / 3] + 1) {
                _n /= 3;
            }
        }
        operations.add(1);
        Collections.reverse(operations);
        System.out.println(table[n]);
        String operationsString = operations.stream().map(String::valueOf).collect(Collectors.joining(" "));
        System.out.println(operationsString);
    }
}
