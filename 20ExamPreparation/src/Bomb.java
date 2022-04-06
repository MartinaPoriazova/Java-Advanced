import java.util.Scanner;

public class Bomb {
    static int startRow = 0;
    static int startCol = 0;
    static int ourBombs = 0;
    static int neededBombs = 0;


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = Integer.parseInt(scanner.nextLine());
        String[] commands = scanner.nextLine().split(",");
        char[][] field = readMatrix(size, scanner);
        setRowCol(field);

        boolean isGameOver = false;
        for (String command : commands) {
            switch (command) {
                case "up":
                    isGameOver = move(startRow - 1, startCol, field);
                    break;
                case "down":
                    isGameOver = move(startRow + 1, startCol, field);
                    break;

                case "left":
                    isGameOver = move(startRow, startCol - 1, field);
                    break;
                case "right":
                    isGameOver = move(startRow, startCol + 1, field);
                    break;
            }

            if (ourBombs == neededBombs) {
                System.out.println("Congratulations! You found all bombs!");
                return;
            }
            if (isGameOver) {
                System.out.printf("END! %d bombs left on the field", neededBombs - ourBombs);
                return;
            }
        }

        System.out.printf("%d bombs left on the field. Sapper position: (%d,%d)", neededBombs - ourBombs, startRow, startCol);

    }

    private static boolean move(int newRow, int newCol, char[][] field) {
        if (!isOutOfBounds(newRow, newCol, field)) {
            char symbol = field[newRow][newCol];
            if (symbol == 'e') {
                return true;
            } else {
                if (symbol == 'B') {
                    System.out.println("You found a bomb!");
                    ourBombs++;
                }
                field[startRow][startCol] = '+';
                field[newRow][newCol] = 's';
                startRow = newRow;
                startCol = newCol;
            }
        }
        return false;
    }

    private static void setRowCol(char[][] field) {
        for (int r = 0; r < field.length; r++) {
            for (int c = 0; c < field.length; c++) {
                char symbol = field[r][c];
                if (symbol == 's') {
                    startRow = r;
                    startCol = c;
                }
                if (symbol == 'B') {
                    neededBombs++;
                }
            }
        }
    }

    private static char[][] readMatrix(int size, Scanner scanner) {
        char[][] matrix = new char[size][size];
        for (int r = 0; r < size; r++) {
            String[] line = scanner.nextLine().split("\\s+");
            for (int c = 0; c < size; c++) {
                matrix[r][c] = line[c].charAt(0);
            }
        }
        return matrix;
    }

    private static boolean isOutOfBounds(int newRow, int newCol, char[][] field) {
        return newRow < 0 || newRow >= field.length || newCol < 0 || newCol >= field[newRow].length;
    }
}