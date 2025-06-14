import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.Scanner;

public class A32 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int q = Integer.parseInt(scanner.nextLine());
        Deque<String> deq = new ArrayDeque<>();
        List<String> result = new ArrayList<>();
        for (int i = 0; i < q; ++i) {
            String[] strings = scanner.nextLine().trim().split(" ");

            if ("1".equals(strings[0])) {
                deq.addLast(strings[1]);
            } else if ("2".equals(strings[0])) {
                deq.pollFirst();
            }
            String s = deq.isEmpty() ? "-1" : deq.peekFirst();
            result.add(s);
        }

        System.out.println(String.join("\n", result));
    }
}
