import java.util.Scanner;

public class Snake {
    public static int row, col;
    public static int foodGoal = 10;
    public static int eatenFood;
    static int[] firstPillar = new int[]{-1, -1};
    static int[] secondPillar = new int[]{-1, -1};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = Integer.parseInt(scanner.nextLine());
        char[][] matrix = new char[size][size];
        readMatrix(size, scanner, matrix);
        setInitialRowColAndFinalGoalFood(matrix);

        boolean isGameEnds = false;
        while (eatenFood < 10) {
            String command = scanner.nextLine();
            switch (command) {
                case "up":
                    isGameEnds = moveSnake(row - 1, col, matrix);
                    break;
                case "down":
                    isGameEnds = moveSnake(row + 1, col, matrix);
                    break;
                case "left":
                    isGameEnds = moveSnake(row, col - 1, matrix);
                    break;
                case "right":
                    isGameEnds = moveSnake(row, col + 1, matrix);
                    break;
            }
            if (isGameEnds) {
                System.out.println("Game over!");
                break;
            }
            if (eatenFood >= 10) {
                System.out.println("You won! You fed the snake.");
                break;
            }
        }
        System.out.println("Food eaten: " + eatenFood);
        printMatrix(matrix);
    }

    private static boolean moveSnake(int newRow, int newCol, char[][] matrix) {
        if (isOutOfBounds(newRow, newCol, matrix)) {
            matrix[row][col] = '.';
            return true;
        } else {
            char symbol = matrix[newRow][newCol];
            if (symbol == 'B') {
                matrix[row][col] = '.';
                matrix[newRow][newCol] = '.';
                matrix[secondPillar[0]][secondPillar[1]] = 'S';
                row = secondPillar[0];
                col = secondPillar[1];
            } else {
                if (symbol == '*') {
                    eatenFood++;
                }
                    matrix[row][col] = '.';
                    matrix[newRow][newCol] = 'S';
                    row = newRow;
                    col = newCol;
                }
            }
        return false;
    }

    private static boolean isOutOfBounds(int newRow, int newCol, char[][] matrix) {
        return newRow < 0 || newRow >= matrix.length || newCol < 0 || newCol >= matrix[newRow].length;
    }

    private static void setInitialRowColAndFinalGoalFood(char[][] field) {
        for (int r = 0; r < field.length; r++) {
            for (int c = 0; c < field.length; c++) {
                if (field[r][c] == 'S') {
                    row = r;
                    col = c;
                }
                if (field[r][c] == 'B' && firstPillar[0] == -1) {
                    firstPillar[0] = r;
                    firstPillar[1] = c;
                }
                if (field[r][c] == 'B' && firstPillar[0] != -1) {
                    secondPillar[0] = r;
                    secondPillar[1] = c;
                }
            }
        }
    }

    private static void printMatrix(char[][] matrix) {
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[r].length; c++) {
                System.out.print(matrix[r][c]);
            }
            System.out.println();
        }
    }

    private static void readMatrix(int size, Scanner scanner, char[][] matrix) {
        for (int r = 0; r < size; r++) {
            matrix[r] = scanner.nextLine().toCharArray();
        }
    }
}
