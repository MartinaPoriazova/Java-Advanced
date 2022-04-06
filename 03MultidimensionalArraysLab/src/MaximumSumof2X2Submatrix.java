import java.util.Arrays;
import java.util.Scanner;

public class MaximumSumof2X2Submatrix {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//        int[] rowsAndCols = Arrays.stream(scanner.nextLine().split(", "))
//                .mapToInt(Integer::parseInt)
//                .toArray();
//        int rows = rowsAndCols[0];
//        int cols = rowsAndCols[1];

        int[][] matrix = readMatrix(scanner);
        int maxSum = 0;
        int[][] maxMatrix = new int[2][2];
        int bestRow = 0;
        int bestCol = 0;

        for (int row = 0; row < matrix.length - 1; row++) {
            for (int col = 0; col < matrix[row].length - 1; col++) {
                int current = matrix[row][col];
                int inRight = matrix[row][col + 1];
                int inBottom = matrix[row + 1][col];
                int leftRigh = matrix[row + 1][col + 1];

                int currentSum = current + inRight + inBottom + leftRigh;
                if (currentSum > maxSum) {
                    maxSum = currentSum;
                    maxMatrix = new int[][]{
                            {current, inRight},
                            {inBottom, leftRigh}
                    };
//                    bestRow = row;
//                    bestCol = col;
                }
            }
        }
        printMatrix(maxMatrix);
        System.out.println(maxSum);

//        System.out.println(matrix[bestRow][bestCol] + " " + matrix[bestRow][bestCol + 1] );
//        System.out.println(matrix[bestRow + 1][bestCol] + " " + matrix[bestRow + 1][bestCol + 1] );
//        System.out.println(maxSum);

    }

    private static void printMatrix(int[][] maxMatrix) {
        for (int[] arr : maxMatrix) {
            for (int c : arr) {
                System.out.print(c + " ");
            }
            System.out.println();
        }
    }

    private static int[][] readMatrix(Scanner scanner) {
        String line = scanner.nextLine();
        String[] split = line.split(", ");
        int rows = Integer.parseInt(split[0]);
        int cols = Integer.parseInt(split[1]);
        int[][] matrix = new int[rows][cols];

        for (int row = 0; row < rows; row++) {
            line = scanner.nextLine();
            split = line.split(", ");
            for (int col = 0; col < cols; col++) {
                matrix[row][col] = Integer.parseInt(split[col]);
            }
        }
        return matrix;
    }
}
