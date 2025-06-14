import java.util.ArrayList;
import java.util.Scanner;

public class A31 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int q = Integer.parseInt(scanner.nextLine());
        StackA stack = new StackA();
        ArrayList<String> result = new ArrayList<>();
        for (int i = 0; i < q; i++) {
            String[] strings = scanner.nextLine().trim().split(" ");
            switch (strings[0]) {
                case "1" -> stack.push(Integer.parseInt(strings[1]));
                case "2" -> stack.pop();
            }
            result.add(stack.back() + "");
        }
        System.out.println(String.join("\n", result));
    }
}

class StackA {

    private final ArrayList<Integer> array;

    public StackA() {
        this.array = new ArrayList<>();
    }

    public void push(int item) {
        array.add(item);
    }

    public void pop() {
        if (!array.isEmpty()) {
            array.remove(array.size() - 1);
        }
    }

    public boolean isNotEmpty() {
        return !array.isEmpty();
    }

    public int back() {
        if (isNotEmpty()) {
            return array.get(array.size() - 1);
        } else {
            return -1;
        }
    }
}
