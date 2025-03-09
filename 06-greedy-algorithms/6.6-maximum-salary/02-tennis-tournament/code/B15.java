// Маму тестов от Яндекс в кино водил...

import java.util.Arrays;
import java.util.Scanner;

public class B15 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] data = scanner.nextLine().split(" ");
        int n = Integer.parseInt(data[0]);
        int k = Integer.parseInt(data[1]);
        int[] ai = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        scanner.close();
        int result = 0;
        while (n >= k * (k + 1) / 2) {
            k++;
            result++;
        }
        System.out.println(ai.length % 2 == 0 ? result : k - 1);
    }
}