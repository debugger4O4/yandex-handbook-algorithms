import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class C31 {

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine().trim());
        int k = Integer.parseInt(reader.readLine().trim());
        String[] data = reader.readLine().trim().split("\\s+");
        int[] a = new int[data.length];
        for (int i = 0; i < data.length; ++i) {
            a[i] = Integer.parseInt(data[i]);
        }

        StackC<Integer> arr = new StackC<>();
        StackC<Integer> tempArr = new StackC<>();
        long inf = 3L * (long)Math.pow(10, 5) + 1;

        long result = 0;
        long tempMin = inf;

        for (int i = 0; i < k; ++i) {
            tempArr.push(a[i]);
            if (tempMin > a[i]) {
                tempMin = a[i];
            }
        }
        result += tempMin;
        tempMin = inf;

        for (int i = k; i < n; ++i) {
            if (arr.isEmpty()) {
                long curMin = inf;
                while (!tempArr.isEmpty()) {
                    if (curMin > tempArr.top()) {
                        curMin = tempArr.top();
                    }
                    arr.push((int) curMin);
                    tempArr.pop();
                }
                tempMin = inf;
            }
            arr.pop();

            tempArr.push(a[i]);
            if (tempMin > a[i]) {
                tempMin = a[i];
            }

            long res = tempMin;
            if (!arr.isEmpty()) {
                res = Math.min(res, arr.top());
            }
            result += res;
        }

        System.out.println(result);
    }
}

class StackC<T> {
    private final ArrayList<T> array;

    public StackC() {
        this.array = new ArrayList<>();
    }

    public void push(T item) {
        array.add(item);
    }

    public T pop() {
        if (this.array.isEmpty()) return null;
        return (T) this.array.remove(this.array.size() - 1);
    }

    public boolean isEmpty() {
        return this.array.isEmpty();
    }

    public T top() {
        if (this.array.isEmpty()) return null;
        return this.array.get(this.array.size() - 1);
    }
}
