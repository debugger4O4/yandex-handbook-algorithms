import java.util.*;

public class A13 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<int[]> segments = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            int l = scanner.nextInt();
            int r = scanner.nextInt();
            segments.add(new int[]{l, r});
        }
        segments.sort(Comparator.comparingInt(interval -> interval[1]));
        int k = 0;
        List<Integer> points = new ArrayList<>();
        for (int[] segment : segments) {
            int left = segment[0];
            int right = segment[1];
            if (points.isEmpty() || left > points.get(points.size() - 1)) {
                points.add(right);
                k++;
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (Integer point : points) {
            stringBuilder.append(point).append(" ");
        }
        System.out.println(k);
        System.out.println(stringBuilder.toString().trim());
    }
}
