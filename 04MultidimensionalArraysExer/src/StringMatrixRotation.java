import org.w3c.dom.stylesheets.LinkStyle;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StringMatrixRotation {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] command = (scanner.nextLine().split("[()]+"));
        int rotationNumber = Integer.parseInt(command[1]) % 360;
        String input = scanner.nextLine();
        List<String> lines = new ArrayList<>();
        int maxLength = input.length();

        while (!input.equals("END")) {
            lines.add(input);
            input = scanner.nextLine();
            if (maxLength < input.length()) {
                maxLength = input.length();
            }
        }
        int rows = lines.size();
        int cols = maxLength;

        char[][] matrix = new char[rows][cols];
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (col < lines.get(row).length()) {
                    matrix[row][col] = lines.get(row).charAt(col);
                } else {
                    matrix[row][col] = ' ';
                }
            }
        }
        rotate(rotationNumber, rows, cols, matrix);


    }

    private static void rotate(int rotationNumber, int rows, int cols, char[][] matrix) {
        if (rotationNumber == 90) {
            for (int col = 0; col < cols; col++) {
                for (int row = rows - 1; row >= 0; row--) {
                    System.out.print(matrix[row][col]);
                }
                System.out.println();
            }
        } else if (rotationNumber == 180) {
            for (int row = rows - 1; row >= 0; row--) {
                for (int col = cols - 1; col >= 0; col--) {
                    System.out.print(matrix[row][col]);
                }
                System.out.println();
            }
        } else if (rotationNumber == 270) {
            for (int col = cols - 1; col >= 0; col--) {
                for (int row = 0; row < rows; row++) {
                    System.out.print(matrix[row][col]);
                }
                System.out.println();
            }
        } else {
            for (int row = 0; row < rows; row++) {
                for (int col = 0; col < cols; col++) {
                    System.out.print(matrix[row][col]);
                }
                System.out.println();
            }
        }
    }
}
