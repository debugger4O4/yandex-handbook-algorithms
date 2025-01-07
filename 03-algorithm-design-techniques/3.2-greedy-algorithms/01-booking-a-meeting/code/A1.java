import java.util.*;
import static java.util.Comparator.comparingInt;

public class A1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = Integer.parseInt(scanner.nextLine());
        Queue<List<Integer>> intervals = new PriorityQueue<>(size, comparingInt(thisInterval -> thisInterval.get(1)));
        for (int i = 0; i < size; i++) {
            String[] strings = scanner.nextLine().split(" ");
            List<Integer> interval = List.of(Integer.parseInt(strings[0]), Integer.parseInt(strings[1]));
            intervals.offer(interval);
        }

        List<List<Integer>> result = new ArrayList<>();
        List<Integer> champion = intervals.poll();
        result.add(champion);

        while (!intervals.isEmpty()) {
            List<Integer> currentInterval = intervals.poll();
            Integer currentIntervalLeftBoundary = currentInterval.get(0);
            assert champion != null;
            Integer bestIntervalRightBoundary = champion.get(1);

            if (currentIntervalLeftBoundary > bestIntervalRightBoundary) {
                champion = currentInterval;

                result.add(currentInterval);
            }
        }
        System.out.println(result.size());
    }
}