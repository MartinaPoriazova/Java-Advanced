import java.util.Scanner;

public class Task_02 {

    static int startRow = 0;
    static int startCol = 0;
    static int target = 5;
    static int cheeseEaten = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = Integer.parseInt(scanner.nextLine());
        char[][] matrix = new char[size][size];

        for (int row = 0; row < size; row++) {
            String line = scanner.nextLine();
            for (int col = 0; col < size; col++) {
                matrix[row][col] = line.charAt(col);
                if (matrix[row][col] == 'M') {
                    startRow = row;
                    startCol = col;
                    matrix[row][col] = '-';
                }
            }
        }
        boolean isOut = true;
        String command = scanner.nextLine();

        while (!command.equals("end") && isOut) {
            switch (command) {
                case "up":
                    //row - 1
                    isOut = mouseMove(matrix, -1, 0);
                    break;
                case "down":
                    //row + 1
                    isOut = mouseMove(matrix, +1, 0);
                    break;
                case "left":
                    //col - 1
                    isOut = mouseMove(matrix, 0, -1);
                    break;
                case "right":
                    //col + 1
                    isOut = mouseMove(matrix, 0, +1);
                    break;
            }
            if (!isOut) {
                break;
            }
            command = scanner.nextLine();
        }

        if (!isOut) {
            System.out.println("Where is the mouse?");
        } else {
            matrix[startRow][startCol] = 'M';
        }
        if (cheeseEaten < target) {
            System.out
                    .printf("The mouse couldn't eat the cheeses, she needed %d cheeses more.\n", target - cheeseEaten);
        } else {
            System.out.printf("Great job, the mouse is fed %d cheeses!\n", cheeseEaten);
        }
        printMatrix(matrix);
    }

    private static boolean mouseMove(char[][] matrix, int newRow, int newCol) {
        if (isOutOfBounds(matrix, newRow + startRow, newCol + startCol)) {
            startRow = startRow + newRow;
            startCol = startCol + newCol;
            char current = matrix[startRow][startCol];
            if (current == 'c') {
                cheeseEaten++;
                matrix[startRow][startCol] = '-';
            } else if (current == 'B') {
                matrix[startRow][startCol] = '-';
                mouseMove(matrix, newRow, newCol);
            } else {
                matrix[startRow][startCol] = '-';
            }
            return true;
        }
        return false;
    }
    // провери в граници ли е:

    public static boolean isOutOfBounds(char[][] matrix, int row, int col) {
        return row >= 0 && row < matrix.length && col >= 0 && col < matrix.length;
    }

    public static void printMatrix(char[][] matrix) {
        for (char[] chars : matrix) {
            for (char element : chars) {
                System.out.print(element);
            }
            System.out.println();
        }
    }
}