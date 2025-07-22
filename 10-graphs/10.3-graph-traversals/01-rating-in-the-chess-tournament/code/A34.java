import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class A34 {
    private static List<List<Integer>> graph;
    private static boolean[] result;
    private static int[] color;
    private static int[] records;
    private static boolean[] isCicle;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        // Чтение входных данных.
        String[] input = reader.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        // Инициализация структур данных.
        graph = new ArrayList<>(n + 1);
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        result = new boolean[n + 1];
        color = new int[n + 1];
        records = new int[n + 1];
        isCicle = new boolean[1];

        // Чтение партий.
        for (int i = 0; i < m; i++) {
            input = reader.readLine().split(" ");
            int v1 = Integer.parseInt(input[0]);
            int v2 = Integer.parseInt(input[1]);
            int t = Integer.parseInt(input[2]);

            if (t == 2) {
                int temp = v1;
                v1 = v2;
                v2 = temp;
            }
            graph.get(v1).add(v2);
        }

        // Запуск DFS для всех вершин.
        for (int v = 1; v <= n; v++) {
            if (color[v] == 0) {
                DFS(v);
            }
        }

        // Проверка результата.
        boolean isRight = true;
        for (int res = 1; res <= n; res++) {
            if (!result[res]) {
                isRight = false;
                break;
            }
        }

        System.out.println((isRight && !isCicle[0] || n == 1) ? "YES" : "NO");
    }

    private static int DFS(int vertex) {
        color[vertex] = 1;
        records[vertex] = 0;

        List<Integer> games = new ArrayList<>();
        games.add(0);

        for (int to : graph.get(vertex)) {
            if (color[to] == 1 && to != vertex) {
                isCicle[0] = true;
                return 0;
            }
            if (color[to] == 0) {
                games.add(DFS(to));
            } else {
                games.add(records[to]);
            }

            if (isCicle[0]) {
                return 0;
            }
        }

        records[vertex] = Collections.max(games) + 1;
        result[records[vertex]] = true;
        color[vertex] = 2;
        return records[vertex];
    }
}
