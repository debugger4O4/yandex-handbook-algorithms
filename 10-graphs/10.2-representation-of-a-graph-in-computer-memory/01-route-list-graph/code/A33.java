import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class A33 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = reader.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        boolean[][] graph1 = new boolean[n][n];
        boolean[][] graph2 = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            Arrays.fill(graph1[i], false);
            Arrays.fill(graph2[i], false);
        }

        // Читаем маршруты.
        for (int i = 0; i < m; i++) {
            input = reader.readLine().split(" ");
            int k = Integer.parseInt(input[0]);  // Количество остановок в маршруте.
            int[] stops = new int[k];

            // Читаем остановки маршрута.
            for (int j = 0; j < k; j++) {
                stops[j] = Integer.parseInt(input[j + 1]) - 1;  // Приводим к 0-индексации.
            }

            // Заполняем первый граф.
            for (int j = 0; j < k - 1; j++) {
                int u = stops[j];
                int v = stops[j + 1];
                graph1[u][v] = true;
                graph1[v][u] = true;  // Двустороннее движение.
            }

            // Заполняем второй граф.
            for (int j = 0; j < k; j++) {
                for (int l = j + 1; l < k; l++) {
                    int u = stops[j];
                    int v = stops[l];
                    graph2[u][v] = true;
                    graph2[v][u] = true;  // Двустороннее движение.
                }
            }
        }

        printMatrix(graph1);
        printMatrix(graph2);
    }

    private static void printMatrix(boolean[][] matrix) {
        for (boolean[] booleans : matrix) {
            String[] row = new String[matrix.length];
            for (int j = 0; j < matrix.length; j++) {
                row[j] = booleans[j] ? "1" : "0";
            }
            System.out.println(String.join(" ", row));
        }
    }
}
