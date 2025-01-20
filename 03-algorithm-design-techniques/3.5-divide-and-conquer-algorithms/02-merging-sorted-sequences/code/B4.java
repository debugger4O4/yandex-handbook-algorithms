import java.util.*;
import java.util.stream.Collectors;

public class B4 {

    public static void main(String[] args) {
        List<List<Integer>> sortedMatrix = fillSortedMatrix();
        List<Integer> mergedNumbers = sortedMatrix.stream()
                .reduce(List.of(), B4::merge);
        String result = mergedNumbers.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(" "));
        System.out.println(result);
    }

    public static List<Integer> merge(List<Integer> list1, List<Integer> list2) {
        List<Integer> mergedList = new ArrayList<>();
        int smallElIdxList1 = 0;
        int smallElIdxList2 = 0;

        while (smallElIdxList1 < list1.size() && smallElIdxList2 < list2.size()) {
            int smallest1 = list1.get(smallElIdxList1);
            int smallest2 = list2.get(smallElIdxList2);

            if (smallest1 <= smallest2) {
                mergedList.add(smallest1);
                smallElIdxList1++;
            } else {
                mergedList.add(smallest2);
                smallElIdxList2++;
            }
        }

        while (smallElIdxList1 < list1.size()) {
            mergedList.add(list1.get(smallElIdxList1));
            smallElIdxList1++;
        }

        while (smallElIdxList2 < list2.size()) {
            mergedList.add(list2.get(smallElIdxList2));
            smallElIdxList2++;
        }

        return mergedList;
    }

    public static List<List<Integer>> fillSortedMatrix() {
        Scanner scanner = new Scanner(System.in);
        int matrixSize = Integer.parseInt(scanner.nextLine());
        List<List<Integer>> matrix = new ArrayList<>(matrixSize);
        for (int i = 0; i < matrixSize; i++) {
            int arraySize = Integer.parseInt(scanner.nextLine());
            List<Integer> arr = new ArrayList<>(arraySize);
            arr.addAll(
                    Arrays.stream(scanner.nextLine().split(" "))
                            .map(Integer::parseInt)
                            .sorted()
                            .collect(Collectors.toList())
            );
            matrix.add(arr);
        }
        scanner.close();
        return matrix;
    }
}
