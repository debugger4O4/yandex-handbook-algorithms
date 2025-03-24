import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class A18 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int[] A = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        scanner.close();
        Arrays.sort(A);
        String result = IntStream.of(A)
                .mapToObj(Integer::toString)
                .collect(Collectors.joining(" "));
        System.out.println(result);
    }
}
