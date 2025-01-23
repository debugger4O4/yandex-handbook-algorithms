import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class B5 {
    public static void main(String[] args) {
        int[] arr = fillArray();
        quickSort(arr, 0, arr.length - 1);
        String resultToString = Arrays.stream(arr)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(" "));
        System.out.println(resultToString.trim());
    }

    public static void quickSort(int[] numbers, int left, int right) {
        if (left >= right) {
            return;
        }

        int pivot = partition(numbers, left, right);

        quickSort(numbers, left, pivot - 1);
        quickSort(numbers, pivot, right);
    }

    private static int partition(int[] arr, int left, int right) {
        int pivot = arr[left + (right - left) / 2];

        while (left <= right) {
            while (arr[left] < pivot) {
                left++;
            }

            while (arr[right] > pivot) {
                right--;
            }

            if (left <= right) {
                swap(arr, left, right);
                left++;
                right--;
            }
        }

        return left;
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
