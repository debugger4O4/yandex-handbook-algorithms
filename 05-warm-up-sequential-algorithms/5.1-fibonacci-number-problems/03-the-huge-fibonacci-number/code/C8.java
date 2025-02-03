import java.util.Scanner;

public class C8 {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] data = scanner.nextLine().split(" ");
        long n = Long.parseLong(data[0]);
        int m = Integer.parseInt(data[1]);
        int[][] D = new int[][]{
                {0, 1},
                {1, 1}
        };
        int[][] result = fastMatrixExponentiation(D, n, m);
        System.out.println(result[0][1]);
    }


    public static int[][] fastMatrixExponentiation(int[][] D, long n, int m) {
        if (n == 0) {
            return new int[][]{
                    {1, 0},
                    {0, 1},
            };
        }
        if (n % 2 == 0) {
            int[][] result = fastMatrixExponentiation(D, n / 2, m);

            return multiply2x2Matrices(result, result, m);
        }
        int[][] result = fastMatrixExponentiation(D, (n - 1) / 2, m);
        return multiply2x2Matrices(multiply2x2Matrices(result, result, m), D, m);
    }

    public static int[][] multiply2x2Matrices(int[][] A, int[][] B, int m) {
        int[][] C = new int[A.length][B.length];
        C[0][0] = (A[0][0] * B[0][0] + A[0][1] * B[1][0]) % m;
        C[0][1] = (A[0][0] * B[0][1] + A[0][1] * B[1][1]) % m;
        C[1][0] = (A[1][0] * B[0][0] + A[1][1] * B[1][0]) % m;
        C[1][1] = (A[1][0] * B[0][1] + A[1][1] * B[1][1]) % m;
        return C;
    }
}