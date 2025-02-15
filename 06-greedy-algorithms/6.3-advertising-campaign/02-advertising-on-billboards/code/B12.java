import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class B12 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] data = scanner.nextLine().split(" ");
        int n = Integer.parseInt(data[0]);
        int k = Integer.parseInt(data[1]);
        int w = Integer.parseInt(data[2]);
        Queue<Booking> bookings = new PriorityQueue<>(k);
        for (int i = 0; i < k; i++) {
            String[] cIwI = scanner.nextLine().split(" ");
            int ci = Integer.parseInt(cIwI[0]);
            int wi = Integer.parseInt(cIwI[1]);
            bookings.add(new Booking(ci, wi));
        }
        scanner.close();
        int maxProfit = 0;
        int placesBook = n * w;
        while (!bookings.isEmpty() && placesBook > 0) {
            Booking booking = bookings.poll();
            int bookingWeeks = Math.min(booking.wi, placesBook);
            int amount = booking.ci * bookingWeeks;

            maxProfit += amount;
            placesBook -= bookingWeeks;
        }
        System.out.println(maxProfit);
    }

    public static final class Booking implements Comparable<Booking> {

        private final int ci;

        private final int wi;

        public Booking(int priceByWeek, int wi) {
            this.ci = priceByWeek;
            this.wi = wi;
        }

        @Override
        public int compareTo(Booking o) {
            return Integer.compare(o.ci, this.ci);
        }

    }
}
