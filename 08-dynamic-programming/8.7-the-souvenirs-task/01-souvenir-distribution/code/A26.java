import java.util.Arrays;
import java.util.Scanner;

public class A26 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int[] v = new int[n];
        v = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        scanner.close();
        System.out.println(Split(v) ? 1 : 0);
    }

    public static boolean Split(int[] v) {
        int sum = Arrays.stream(v).sum();
        int n = v.length;
        if(sum % 3 != 0){
            return false;
        }
        int V = sum / 3;
        boolean[][][] split = new boolean[n + 1][V + 1][V + 1];
        split[0][0][0] = true;
        for(int i = 1; i <= n; ++i) {
            for(int s1 = 0; s1 <= V; ++s1) {
                for(int s2 = 0; s2 <= V; ++s2) {
                    split[i][s1][s2] = split[i - 1][s1][s2];
                    if(s1 >= v[i - 1]) {
                        split[i][s1][s2] |= split[i - 1][s1 - v[i - 1]][s2];
                    }
                    if(s2 >= v[i - 1]) {
                        split[i][s1][s2] |= split[i - 1][s1][s2 - v[i - 1]];
                    }
                }
            }
        }
        return split[n][V][V];
    }
}
