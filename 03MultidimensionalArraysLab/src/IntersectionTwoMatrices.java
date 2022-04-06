import java.util.Scanner;

public class IntersectionTwoMatrices {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rows = Integer.parseInt(scanner.nextLine());
        int cols = Integer.parseInt(scanner.nextLine());

        char[][] firstMatrix = readMatrix(rows, cols, scanner);
        char[][] secondMatrix = readMatrix(rows, cols, scanner);
        char[][] outputMatrix = new char[rows][cols];

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                char fillChar = firstMatrix[row][col] == secondMatrix[row][col]
                        ? firstMatrix[row][col] : '*';
                outputMatrix[row][col] = fillChar;
            }
        }
        printMatrix(rows, cols, outputMatrix);
    }

    public static char[][] readMatrix(int rows, int cols, Scanner scanner) {
        char[][] matrix = new char[rows][cols];
// rows:
        for (int row = 0; row < rows; row++) {
            // a b c d
            String line = scanner.nextLine();
            // a, b, c, d
            String[] elements = line.split("\\s+");

            // cols:
            for (int col = 0; col < elements.length; col++) {
                char current = elements[col].charAt(0);
                matrix[row][col] = current;
            }
        }
        return matrix;
    }

    public static void printMatrix(int rows, int cols, char[][] outputMatrix) {
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                System.out.print(outputMatrix[row][col] + " ");
            }
            System.out.println();
        }
    }
}
