import java.util.Scanner;

public class FillTheMatrix {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        int n = Integer.parseInt(input.split(", ")[0]);
        String pattern = input.split(", ")[1]; // A / B

        int[][] matrix = new int[n][n];

        if (pattern.equals("A")) {
            // попълваме матрицата по А начин -> по колони обхождаме
            fillMatrixPatternA(matrix);

        } else if (pattern.equals("B")) {
            // попълваме матрицата по B начин ->
            fillMatrixPatternB(matrix);

        }
        printMatrix(matrix, n, n);

    }

    private static void printMatrix(int[][] matrix, int rows, int cols) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix.length; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }

    private static void fillMatrixPatternB(int[][] matrix) {
        // 1    8
        // 2    7
        // 3    6
        // 4    5

        // четна колона - от 0 до последния
        // нечетна = последен до 0
        int startNumber = 1;
        for (int col = 0; col < matrix.length; col++) {
            if (col % 2 == 0) {
                for (int row = 0; row < matrix.length; row++) {
                    matrix[row][col] = startNumber++;
                }
            } else {
                for (int row = matrix.length - 1; row >= 0; row--) {
                    matrix[row][col] = startNumber++;
                }
            }
        }
    }

    private static void fillMatrixPatternA(int[][] matrix) {
        // 1    5
        // 2    6
        // 3    7
        // 4    8
        int startNumber = 1;
        for (int col = 0; col < matrix.length; col++) {
            for (int row = 0; row < matrix.length; row++) {
                matrix[row][col] = startNumber++;
//                startNumber++;
            }
        }
    }

    private static int[][] readMatrix(Scanner scanner) {
        String line = scanner.nextLine();
        String[] split = line.split("\\s+");
        int rows = Integer.parseInt(split[0]);
        int cols = Integer.parseInt(split[1]);
        int[][] matrix = new int[rows][cols];

        for (int row = 0; row < rows; row++) {
            line = scanner.nextLine();
            split = line.split("\\s+");
            for (int col = 0; col < cols; col++) {
                matrix[row][col] = Integer.parseInt(split[col]);
            }
        }
        return matrix;
    }
}
