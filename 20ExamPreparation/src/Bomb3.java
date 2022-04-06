
import java.util.Scanner;

public class Bomb3 {
    static int startRow = 0;
    static int startCol = 0;
    static int bombs = 0;
    static boolean foundEnd = false;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = Integer.parseInt(scanner.nextLine());
        String[] commands = scanner.nextLine().split(",");
        char[][] matrix = new char[size][size];
        for (int row = 0; row < size; row++) {
            String line = scanner.nextLine().replaceAll("\\s+", "");
            matrix[row] = line.toCharArray();
            if (line.contains("s")) {
                startRow = row;
                startCol = line.indexOf("s");
            }
            for (char chars : matrix[row]) {
                if (chars == 'B') {
                    bombs++;
                }
            }
        }
        for (String command : commands) {
            switch (command) {
                case "up":
                    foundEnd = moveSapper(matrix, startRow - 1, startCol);
                    break;
                case "down":
                    foundEnd = moveSapper(matrix, startRow + 1, startCol);
                    break;
                case "left":
                    foundEnd = moveSapper(matrix, startRow, startCol - 1);
                    break;
                case "right":
                    foundEnd = moveSapper(matrix, startRow, startCol + 1);
                    break;
            }
            if (foundEnd) {
                break;
            }
        }
        if (bombs == 0) {
            System.out.println("Congratulations! You found all bombs!");
        } else if (foundEnd) {
            System.out.printf("END! %d bombs left on the field", bombs);
        } else {
            System.out.printf("%d bombs left on the field. Sapper position: (%d,%d)", bombs, startRow, startCol);
        }
    }

    public static boolean moveSapper(char[][] matrix, int newRow, int newCol) {
        startRow = newRow;
        startCol = newCol;
        isInBounds(matrix);
        char current = matrix[startRow][startCol];
        matrix[startRow][startCol] = '+';
        if (current == 'B') {
            System.out.println("You found a bomb!");
            bombs--;
        } else if (current == 'e') {
            return true;
        }
        return false;
    }

    public static void isInBounds(char[][] matrix) {
        if (startRow >= matrix.length) {
            startRow = matrix.length - 1;
        } else if (startRow < 0) {
            startRow = 0;
        }
        if (startCol >= matrix.length) {
            startCol = matrix.length - 1;
        } else if (startCol < 0) {
            startCol = 0;
        }
    }
}