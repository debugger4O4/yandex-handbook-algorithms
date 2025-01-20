import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class A4 {

    public static void main(String[] args) {
        int[] arr = fillArray();
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (arr[i] < arr[j]) {
                    int k = arr[j];
                    arr[j] = arr[i];
                    arr[i] = k;
                }
            }
        }
        String result = Arrays.stream(arr).mapToObj(String::valueOf).collect(Collectors.joining(" "));
        System.out.println(result);
    }

    public static int[] fillArray() {
        Scanner scanner = new Scanner(System.in);
        int size = Integer.parseInt(scanner.nextLine());
        int[] arr = new int[size];
        int[] input = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        scanner.close();
        System.arraycopy(input, 0, arr, 0, arr.length);
        return arr;
    }
}
