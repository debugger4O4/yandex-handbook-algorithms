import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class B6 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int powA = Integer.parseInt(scanner.nextLine());
        int[] numsA = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int powB = Integer.parseInt(scanner.nextLine());
        int[] numsB = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        scanner.close();
        System.out.println(Math.max(powA, powB));
        for (int i = numsA.length - 1, j = numsB.length - 1; i >= 0 && j >= 0; i--, j--) {
            int a = numsA[i];
            int b = numsB[j];
            int sum = a + b;
            numsA[i] = sum;
            numsB[j] = sum;
        }
        String result;
        if (numsB.length >= numsA.length) {
            result = Arrays.stream(numsB).mapToObj(String::valueOf).collect(Collectors.joining(" "));
        } else {
            result = Arrays.stream(numsA).mapToObj(String::valueOf).collect(Collectors.joining(" "));
        }
        System.out.println(result);
    }
}
