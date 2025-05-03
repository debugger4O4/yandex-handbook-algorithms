import java.util.Scanner;

public class A23 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String wordOne = scanner.nextLine();
        String wordTwo = scanner.nextLine();
        wordOne = "x" + wordOne;
        wordTwo = "x" + wordTwo;

        int[][] table = new int[wordOne.length()][wordTwo.length()];

        for (int i = 0; i < wordOne.length(); i++) {
            table[i][0] = i;
        }
        for (int j = 0; j < wordTwo.length(); j++) {
            table[0][j] = j;
        }

        for (int i = 1; i < wordOne.length(); i++) {
            for (int j = 1; j < wordTwo.length(); j++) {
                int match = table[i - 1][j - 1];
                int mismatch = table[i - 1][j - 1] + 1;
                int insert = table[i][j - 1] + 1;
                int delete = table[i - 1][j] + 1;

                if (wordOne.charAt(i) == wordTwo.charAt(j)) {
                    table[i][j] = Math.min(Math.min(match, insert), delete);
                } else {
                    table[i][j] = Math.min(Math.min(mismatch, insert), delete);
                }
            }
        }

        System.out.println(table[wordOne.length()-1][wordTwo.length()-1]);
    }
}
