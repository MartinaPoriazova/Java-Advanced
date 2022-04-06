import java.util.Arrays;
import java.util.Scanner;

public class WrongMeasurements {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = Integer.parseInt(scanner.nextLine());
        int[][] matrix = readMatrix(size, scanner, "\\s+");
        int number = Integer.parseInt(scanner.nextLine());

    }

    private static void printMatrix(int[][] maxMatrix) {
        for (int[] arr : maxMatrix) {
            for (int c : arr) {
                System.out.print(c + " ");
            }
            System.out.println();
        }
    }

    private static int[][] readMatrix(int size, Scanner scanner, String splitPattern) {
        int[][] matrix = new int[size][];
        for (int row = 0; row < size; row++) {
            matrix[row] = Arrays.stream(scanner.nextLine()
                    .split(splitPattern))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }
        return matrix;
    }
}
