import java.util.*;

import static java.util.stream.Collectors.toCollection;

public class A12 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        Queue<Long> clicks = Arrays.stream(scanner.nextLine().split(" "))
                .map(Long::parseLong)
                .collect(toCollection(() -> new PriorityQueue<>(n)));
        Queue<Long> prices = Arrays.stream(scanner.nextLine().split(" "))
                .map(Long::parseLong)
                .collect(toCollection(() -> new PriorityQueue<>(n)));
        scanner.close();
        long revenue = 0;
        while (!clicks.isEmpty() && !prices.isEmpty()) {
            long price = prices.poll();
            long click = clicks.poll();
            revenue += price * click;
        }
        System.out.println(revenue);
    }
}
