import java.util.Scanner;

public class CookingJourney2 {
    static int row;
    static int col;
    static int money = 0;
    static int[] firstPillar = new int[]{-1, -1};
    static int[] secondPillar = new int[]{-1, -1};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());
        char[][] field = readMatrix(size, scanner);
        findInitialIndexesForRowColAndBothPillars(field);

        boolean isOutOfBoundsVariable = false;
        while (money < 50) {
            String command = scanner.nextLine();

            switch (command) {
                case "left":
                    isOutOfBoundsVariable = move(row, col - 1, field);
                    break;
                case "right":
                    isOutOfBoundsVariable = move(row, col + 1, field);
                    break;
                case "up":
                    isOutOfBoundsVariable = move(row - 1, col, field);
                    break;
                case "down":
                    isOutOfBoundsVariable = move(row + 1, col, field);
                    break;

            }

            if (isOutOfBoundsVariable) {
                System.out.println("Bad news! You are out of the pastry shop.");
                break;
            }
            if (money >= 50) {
                System.out.println("Good news! You succeeded in collecting enough money!");
                break;
            }

        }
        System.out.println("Money: " + money);
        printMatrix(field);
    }

    private static boolean isOutOfBounds(int newRow, int newCol, char[][] field) {
        return newRow < 0 || newRow >= field.length || newCol < 0 || newCol >= field[newRow].length;
    }

    private static boolean move(int newRow, int newCol, char[][] field) {
        if (isOutOfBounds(newRow, newCol, field)) {
            field[row][col] = '-';
            return true;
        } else {
            char symbol = field[newRow][newCol];
            if (symbol == 'P') {
                field[row][col] = '-';
                field[newRow][newCol] = '-';
                field[secondPillar[0]][secondPillar[1]] = 'S';
                row = secondPillar[0];
                col = secondPillar[1];
            } else {
                if (Character.isDigit(symbol)) {
                    money += Character.getNumericValue(symbol);
                }
                field[row][col] = '-';
                field[newRow][newCol] = 'S';
                row = newRow;
                col = newCol;
            }
        }
        return false;
    }

    private static void findInitialIndexesForRowColAndBothPillars(char[][] field) {
        for (int r = 0; r < field.length; r++) {
            for (int c = 0; c < field.length; c++) {
                if (field[r][c] == 'S') {
                    row = r;
                    col = c;
                }
                if (field[r][c] == 'P' && firstPillar[0] == -1) {
                    firstPillar[0] = r;
                    firstPillar[1] = c;
                }
                if (field[r][c] == 'P' && firstPillar[0] != -1) {
                    secondPillar[0] = r;
                    secondPillar[1] = c;
                }
            }
        }
    }

    private static char[][] readMatrix(int size, Scanner scanner) {
        char[][] matrix = new char[size][size];
        for (int r = 0; r < size; r++) {
            matrix[r] = scanner.nextLine().toCharArray();
        }
        return matrix;
    }

    private static void printMatrix(char[][] matrix) {
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[r].length; c++) {
                System.out.print(matrix[r][c]);
            }
            System.out.println();
        }
    }
}