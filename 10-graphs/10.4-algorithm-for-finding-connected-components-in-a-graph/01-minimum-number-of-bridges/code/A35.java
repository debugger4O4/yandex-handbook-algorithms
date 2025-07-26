import java.io.*;
import java.util.*;

public class A35 {
    static List<List<Integer>> graph;
    static boolean[] visited;
    static List<Integer> component;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(System.out);

        String[] input = reader.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        graph = new ArrayList<>(n + 1);
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            input = reader.readLine().split(" ");
            int u = Integer.parseInt(input[0]);
            int v = Integer.parseInt(input[1]);
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        visited = new boolean[n + 1];
        List<List<Integer>> components = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                component = new ArrayList<>();
                dfs(i);
                components.add(component);
            }
        }

        if (components.size() > 1) {
            writer.println(components.size() - 1);
            for (int i = 1; i < components.size(); i++) {
                writer.println(components.get(i - 1).get(0) + " " + components.get(i).get(0));
            }
        } else {
            writer.println(0);
        }

        writer.flush();
    }

    private static void dfs(int node) {
        if (visited[node]) return;
        visited[node] = true;
        component.add(node);
        for (int neighbor : graph.get(node)) {
            dfs(neighbor);
        }
    }
}

