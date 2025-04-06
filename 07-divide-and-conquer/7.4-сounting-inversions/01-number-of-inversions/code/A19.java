import java.util.Scanner;

public class A19 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int n = scanner.nextInt();
        int[] array = new int[n];
        
        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextInt();
        }
        
        long totalInv = countInversions(array);
        System.out.println(totalInv);
    }

    private static long countInversions(int[] arr) {
        return mergeSortAndCount(arr, 0, arr.length - 1).inversions;
    }

    private static Result mergeSortAndCount(int[] arr, int start, int end) {
        if (start == end) {
            return new Result(new int[]{arr[start]}, 0L);
        }

        int mid = (start + end) / 2;
        Result leftResult = mergeSortAndCount(arr, start, mid);
        Result rightResult = mergeSortAndCount(arr, mid + 1, end);

        Result mergedResult = mergeAndCount(leftResult.sortedArray, rightResult.sortedArray);

        long totalInversions = leftResult.inversions + rightResult.inversions + mergedResult.inversions;
        return new Result(mergedResult.sortedArray, totalInversions);
    }

    private static Result mergeAndCount(int[] left, int[] right) {
        int[] result = new int[left.length + right.length];
        int i = 0, j = 0, k = 0;
        long inversions = 0;

        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                result[k++] = left[i++];
            } else {
                result[k++] = right[j++];
                inversions += left.length - i;
            }
        }
        while (i < left.length) {
            result[k++] = left[i++];
        }
        while (j < right.length) {
            result[k++] = right[j++];
        }

        return new Result(result, inversions);
    }

    private static class Result {
        int[] sortedArray;
        long inversions;

        public Result(int[] sortedArray, long inversions) {
            this.sortedArray = sortedArray;
            this.inversions = inversions;
        }
    }
}