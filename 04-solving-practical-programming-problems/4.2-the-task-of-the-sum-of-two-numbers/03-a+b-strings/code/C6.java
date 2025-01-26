import java.util.Scanner;

public class C6 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        String a = scanner.nextLine();
        String b = scanner.nextLine();
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < n; i++) {
            result.append(a.charAt(i));
            result.append(b.charAt(i));
        }
        System.out.println(result);
    }
}
