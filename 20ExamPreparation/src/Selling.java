import java.util.Scanner;

public class Selling {
    public static int startRow;
    public static int startCol;
    public static char currentElement;
    public static int moneyForRent;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = Integer.parseInt(scanner.nextLine());
        char[][] matrix = new char[size][size];
        readMatrix(size, scanner, matrix);

        //първоначална позиция на играча - start
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                currentElement = matrix[row][col];
                if (currentElement == 'S') {
                    startRow = row;
                    startCol = col;
                    break;
                }
            }
        }

        int newRow = 0; //редът след преместване
        int newCol = 0; //колоната след преместване
        boolean isInBakery = true;

        while (moneyForRent < 50 && isInBakery) {
            String command = scanner.nextLine();
            //up, down, left or right
            switch (command) {
                case "up":
                    //row - 1
                    newRow = startRow - 1;
                    newCol = startCol;
                    isInBakery = move(newRow, newCol, matrix);
                    break;
                case "down":
                    //row + 1
                    newRow = startRow + 1;
                    newCol = startCol;
                    isInBakery = move(newRow, newCol, matrix);
                    break;
                case "left":
                    //col - 1
                    newRow = startRow;
                    newCol = startCol - 1;
                    isInBakery = move(newRow, newCol, matrix);
                    break;
                case "right":
                    //col + 1
                    newRow = startRow;
                    newCol = startCol + 1;
                    isInBakery = move(newRow, newCol, matrix);
                    break;
            }
        }

        String message;
        if (!isInBakery) message = "Bad news, you are out of the bakery.";
        else message = "Good news! You succeeded in collecting enough money!";
        System.out.println(message);
        System.out.println("Money: " + moneyForRent);
        printMatrix(matrix);
    }

    private static boolean move(int newRow, int newCol, char[][] matrix) {
        matrix[startRow][startCol] = '-';
        if (isOutOfBounds(matrix, newRow, newCol)) {
            return false;
        }
        char symbol = matrix[newRow][newCol];
        if (Character.isDigit(symbol)) {
             moneyForRent += symbol - '0';
        } else if (symbol == 'O') {
            matrix[newRow][newCol] = '-';
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[i].length; j++) {
                    if (matrix[i][j] == 'O') {
                        newRow = i;
                        newCol =j;
                        break;
                    }
                }
                if (matrix[newRow][newCol] == 'O') {
                    break;
                }
            }
        }
        matrix[newRow][newCol] = 'S';
        startRow = newRow;
        startCol = newCol;
        return true;
    }

    //TODO: ПРОВЕРКА ДАЛИ e В МАТРИЦАТА
    private static boolean isOutOfBounds(char[][] matrix, int newRow, int newCol) {
        if (newRow < 0 || newRow >= matrix.length || newCol < 0 || newCol >= matrix[newRow].length) return true;
        else return false;
    }

    private static void readMatrix(int size, Scanner scanner, char[][] matrix) {
        for (int r = 0; r < size; r++) {
            matrix[r] = scanner.nextLine().toCharArray();
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
}