import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B33 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] input = reader.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        // Чтение плана комнаты.
        char[][] room = new char[n][m];
        for (int i = 0; i < n; i++) {
            room[i] = reader.readLine().toCharArray();
        }

        // Чтение стартовой позиции.
        input = reader.readLine().split(" ");
        int r = Integer.parseInt(input[0]) - 1; // Переводим в 0-индексацию.
        int c = Integer.parseInt(input[1]) - 1;

        // Чтение команд.
        int q = Integer.parseInt(reader.readLine());
        String commands = reader.readLine();

        // Матрица посещенных клеток.
        boolean[][] visited = new boolean[n][m];
        visited[r][c] = true;

        // Направления движения (0 - вверх, 1 - вправо, 2 - вниз, 3 - влево).
        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, 1, 0, -1};
        int direction = 0; // Начальное направление - вверх.

        // Обработка команд.
        for (char command : commands.toCharArray()) {
            switch (command) {
                case 'L' -> direction = (direction + 3) % 4; // Поворот налево.
                case 'R' -> direction = (direction + 1) % 4; // поворот направо.
                case 'M' -> {
                    // Попытка движения.
                    int newR = r + dr[direction];
                    int newC = c + dc[direction];

                    // Проверка границ и препятствий.
                    if (newR >= 0 && newR < n && newC >= 0 && newC < m && room[newR][newC] == '.') {
                        r = newR;
                        c = newC;
                        visited[r][c] = true;
                    }
                }
            }
        }

        // Подсчет посещенных клеток.
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (visited[i][j]) {
                    count++;
                }
            }
        }
        System.out.println(count);
    }
}
