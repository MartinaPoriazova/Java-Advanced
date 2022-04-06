import java.util.Scanner;

public class DiagonalDifference {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int[][] matrix = new int[n][n];

        // fill matrix
        fillMatrix(matrix, scanner);

        // sum Primary dig
        int sumPrimary = getSumPrimaryDiagonal(matrix);

        // sum SeconDary dig
        int sumSecondary = getSumSecondaryDiagonal(matrix);

        // abc
        System.out.println(Math.abs(sumPrimary - sumSecondary));
    }

    private static int getSumSecondaryDiagonal(int[][] matrix) {
        int sum = 0;
        // col = n - row - 1
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix.length; col++) {
                if (col == matrix.length - row - 1) {
                    sum += matrix[row][col];
                }

            }
        }
        return sum;
    }

    private static int getSumPrimaryDiagonal(int[][] matrix) {
        int sum = 0;
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix.length; col++) {
                if (row == col) {
                    sum += matrix[row][col];
                }
            }
        }
        return sum;
    }

    private static void fillMatrix(int[][] matrix, Scanner scanner) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix.length; col++) {
                matrix[row][col] = scanner.nextInt();
            }
        }
    }

    private static void printMatrix(int[][] matrix, int rows, int cols) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix.length; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }
}
