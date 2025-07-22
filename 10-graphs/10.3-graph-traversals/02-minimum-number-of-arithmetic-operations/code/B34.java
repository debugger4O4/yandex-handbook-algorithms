import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class B34 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = reader.readLine().split(" ");

        int x = Integer.parseInt(input[0]);
        int y = Integer.parseInt(input[1]);

        int maximum = Math.max(x, y) + 40; // Небольшой запас.

        // Инициализация структур данных.
        Deque<Integer> queue = new ArrayDeque<>();
        int[] used = new int[maximum + 1];
        int[] destination = new int[maximum + 1];

        // Заполнение массивов начальными значениями.
        Arrays.fill(destination, maximum);
        destination[x] = 0;
        used[x] = 1;
        queue.add(x);

        boolean isMinusUsed = false;

        while (!queue.isEmpty()) {
            int vertex = queue.poll();

            for (int i = 1; i < 10; i++) {
                int plus = vertex + i;
                int minus = vertex - i;
                int mul = vertex * i;

                int[] options = {minus, plus, mul};

                if (!isMinusUsed) {
                    isMinusUsed = true;
                    options = Arrays.copyOf(options, options.length + 1);
                    options[options.length - 1] = 0;
                }

                for (int var : options) {
                    if (var >= 0 && var <= maximum && used[var] == 0) {
                        queue.add(var);
                        used[var] = 1;
                        destination[var] = destination[vertex] + 1;
                    }
                }
            }
        }

        System.out.println(destination[y]);
    }
}
