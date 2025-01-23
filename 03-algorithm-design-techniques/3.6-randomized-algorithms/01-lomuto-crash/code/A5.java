import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class A5 {

    public static void main(String[] args) {
        int[] arr = fillArray();
        int m = arr[0];
        int small = 0;

        for (int i : arr) {
            if (i <= m) {
                small++;
            }
        }

        int[] result = new int[arr.length];

        int smallIndex = 0;
        for (int number : arr) {
            if (number <= m) {
                result[smallIndex++] = number;
            }
        }

        int largeIndex = small;
        for (int i : arr) {
            if (i > m) {
                result[largeIndex++] = i;
            }
        }

        int lastSmallerIndex = small - 1;
        swap(result, 0, lastSmallerIndex);
        String resultToString = Arrays.stream(result)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(" "));
        System.out.println(resultToString.trim());
    }


    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
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
