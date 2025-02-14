import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class B10 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int money = Integer.parseInt(scanner.nextLine());
        scanner.close();
        List<Integer> list = new ArrayList<>();
        while (money > 0){
            if (money >= 50) {
                list.add(50);
                money -= 50;
            }
            if (money >= 20 && money < 50) {
                list.add(20);
                money -= 20;
            }
            if (money >= 10 && money < 20) {
                list.add(10);
                money -= 10;
            }
            if (money >= 5 && money < 10) {
                list.add(5);
                money -= 5;
            }
            if (money >= 1 && money < 5) {
                list.add(1);
                money -= 1;
            }
        }
        System.out.println(list.size());
        System.out.println(list.stream().map(String::valueOf).collect(Collectors.joining(" ")));
    }
}
