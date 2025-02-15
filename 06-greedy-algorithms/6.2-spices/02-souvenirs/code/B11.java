import java.util.*;

public class B11 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] numberOfSouvenirsAndBudget = scanner.nextLine().split(" ");
        int n = Integer.parseInt(numberOfSouvenirsAndBudget[0]);
        long S = Long.parseLong(numberOfSouvenirsAndBudget[1]);
        Queue<Souvenir> souvenirs = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            long price = Long.parseLong(scanner.nextLine());
            souvenirs.add(new Souvenir(price));
        }
        scanner.close();
        long result = 0;
        while (!souvenirs.isEmpty() && S >= souvenirs.peek().getPrice()) {
            long souvenir = souvenirs.poll().getPrice();
            result++;
            S -= souvenir;
        }
        System.out.println(result);
    }

    static class Souvenir implements Comparable<Souvenir> {

        private final long price;

        public Souvenir(long price) {
            this.price = price;
        }

        public long getPrice() {
            return price;
        }

        @Override
        public int compareTo(Souvenir other) {
            return Long.compare(this.price, other.price);
        }
    }
}
