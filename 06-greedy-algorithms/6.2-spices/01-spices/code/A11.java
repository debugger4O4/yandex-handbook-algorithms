import java.util.*;

public class A11 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] spicesCountAndBagVolume = scanner.nextLine().split(" ");
        int n = Integer.parseInt(spicesCountAndBagVolume[0]);
        long W = Long.parseLong(spicesCountAndBagVolume[1]);
        Queue<Spice> spices = new PriorityQueue<>(n);
        for (int i = 0; i < n; i++) {
            long[] arr = Arrays.stream(scanner.nextLine().split(" ")).mapToLong(Long::parseLong).toArray();
            spices.add(new Spice(arr[0], arr[1]));
        }
        scanner.close();
        double result = 0.0;
        while (!spices.isEmpty() && W > 0) {
            Spice spice = spices.poll();
            long amount = Math.min(spice.Weight, W);
            result += spice.costByItem * amount;
            W -= amount;
        }
        System.out.printf(Locale.US, "%.3f%n", result);
    }


    public static class Spice implements Comparable<Spice> {

        private final long Weight;

        private final double costByItem;

        public Spice(long Cost, long Weight) {
            this.Weight = Weight;
            this.costByItem = (double) Cost / Weight;
        }

        @Override
        public int compareTo(Spice o) {
            return Double.compare(o.costByItem, this.costByItem);
        }

    }
}
