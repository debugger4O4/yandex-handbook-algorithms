import java.util.*;

public class C30 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, String> map = new HashMap<>();
        List<String> result = new ArrayList<>();

        int q = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < q; i++) {
            String[] query = scanner.nextLine().trim().split(" ");

            if ("1".equals(query[0])) {
                map.put(query[1], query[2]);
            } else if ("2".equals(query[0])) {
                String value = map.getOrDefault(query[1], "-1");
                result.add(value);
            }
        }
        System.out.println(String.join("\n", result));
    }
}
