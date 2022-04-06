import java.util.Scanner;

public class CookingJourney {
    static int currentRow = 0;
    static int currentCol = 0;
    static double price = 0;
    static int length = 1;
    static char currentChar;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = Integer.parseInt(scanner.nextLine());
        char[][] matrix = new char[size][size];

        for (int r = 0; r < size; r++) {
            String line = scanner.nextLine().replaceAll("\\s+", "");
            matrix[r] = line.toCharArray();

            if (line.contains("S")) {
                currentRow = r;
                currentCol = line.indexOf("S");
            }
        }
        String[] commands = scanner.nextLine().split(", ");

        for (String command : commands) {
            switch (command) {
                case "up":
                    movePython(matrix, currentRow - 1, currentCol);
                    currentChar = '-';
                    break;
                case "down":
                    movePython(matrix, currentRow + 1, currentCol);
                    currentChar = '-';
                    break;
                case "left":
                    movePython(matrix, currentRow, currentCol - 1);
                    currentChar = '-';
                    break;
                case "right":
                    movePython(matrix, currentRow, currentCol + 1);
                    currentChar = '-';
                    break;
            }
            if (length == -1) {
                System.out.println("Bad news! You are out of the pastry shop.");
                break;
            }
            if (price >= 50) {
                System.out.println("Good news! You succeeded in collecting enough money!");
                break;
            }
        }

        System.out.println("Money: " + price);
        printMatrix(matrix);

    }

    public static void printMatrix(char[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }

    private static void movePython(char[][] matrix, int newRow, int newCol) {
        if (isOutOfBounds(matrix, newRow, newCol)) {
            int[] newIndexes = flipSide(matrix.length, newRow, newCol);
            newRow = newIndexes[0];
            newCol = newIndexes[1];
        }
        char currentChar = matrix[newRow][newCol];

        if (currentChar >= 48 && currentChar <= 57) {
            price += currentChar;
            currentChar = 'S';
        } else if (currentChar == 'P') {
            currentChar = '-';
            for (int row = newRow; row < matrix.length; row++) {
                for (int col = newCol + 1; col < matrix.length; col++) {
                    if (matrix[row][col] == 'P') {
                        newRow = row;
                        newCol = col;
                    }
                }
            }
            currentChar = 'S';
        }
        currentRow = newRow;
        currentCol = newCol;
    }

    private static int[] flipSide(int length, int r, int c) {
        /// Refactor this method by using Math.max() and Math.min()

        int[] result = new int[2];
        if (r < 0) {
            result[0] = length - 1;
            result[1] = c;
        } else if (r >= length) {
            result[1] = c;
        } else if (c < 0) {
            result[0] = r;
            result[1] = length - 1;
        } else {
            result[0] = r;
        }

        return result;
    }

    private static boolean isOutOfBounds(char[][] matrix, int r, int c) {
        if (r < 0 || r >= matrix.length || c < 0 || c >= matrix[r].length) return true;
        else return false;
    }

}
