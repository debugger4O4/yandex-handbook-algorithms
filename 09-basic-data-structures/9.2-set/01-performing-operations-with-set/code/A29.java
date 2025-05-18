import java.util.*;

public class A29 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        Set<String> numbers = new HashSet<>();
        List<String> answer = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String line = scanner.nextLine();
            String[] parts = line.split(" ");

            if ("1".equals(parts[0])) {
                numbers.add(parts[1]);

            } else if ("2".equals(parts[0])) {
                if (numbers.contains(parts[1])) {
                    answer.add("1");
                } else {
                    answer.add("0");
                }
            }
        }

        System.out.println(String.join("\n", answer));
    }
}
