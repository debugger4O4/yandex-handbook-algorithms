import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class B17 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int[] A = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        scanner.close();
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int i : A) {
            frequencyMap.put(i, frequencyMap.getOrDefault(i, 0) + 1);
        }
        int count = 0;
        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            if (entry.getValue() > n / 4) {
                count++;
            }
        }
        if (count >= 3) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }
}