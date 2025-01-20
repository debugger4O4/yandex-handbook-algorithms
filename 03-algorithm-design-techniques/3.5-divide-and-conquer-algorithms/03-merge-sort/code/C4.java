import java.util.*;
import java.util.stream.Collectors;

public class C4 {
    public static void main(String[] args) {
        int[] arr = fillArray();
        int[] sortedArr = mergeSort(arr);
        String result = Arrays.stream(sortedArr).boxed().map(String::valueOf).collect(Collectors.joining(" "));
        System.out.println(result);
    }

    public static int[] mergeSort(int[] array) {
        if (array.length <= 1) {
            return array;
        }

        int mid = array.length / 2;
        int[] left = Arrays.copyOfRange(array, 0, mid);
        int[] right = Arrays.copyOfRange(array, mid, array.length);

        return merge(mergeSort(left), mergeSort(right));
    }

    public static int[] merge(int[] left, int[] right) {
        int[] result = new int[left.length + right.length];
        int i = 0, j = 0, k = 0;

        while (i < left.length && j < right.length) {
            result[k++] = left[i] <= right[j] ? left[i++] : right[j++];
        }

        while (i < left.length) {
            result[k++] = left[i++];
        }

        while (j < right.length) {
            result[k++] = right[j++];
        }

        return result;
    }

    public static int[] fillArray() {
        Scanner scanner = new Scanner(System.in);
        int size = Integer.parseInt(scanner.nextLine());
        int[] arr = new int[size];

        for (int i = 0; i < size; i++) {
            arr[i] = scanner.nextInt();
        }

        scanner.close();
        return arr;
    }
}
