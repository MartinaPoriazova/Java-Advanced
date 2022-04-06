import java.util.Scanner;

public class ReVolt {
    public static int startRow;
    public static int startCol;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = Integer.parseInt(scanner.nextLine());
        int countOfCommands = Integer.parseInt(scanner.nextLine());
        char[][] matrix = new char[size][size];
        readMatrix(size, scanner, matrix);

        //първоначална позиция на играча
        //f -> позиция на играча
        //- -> празно
        //B -> бонус
        //T -> капан
        //F -> финал
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                char currentElement = matrix[row][col];
                if (currentElement == 'f') { // start position
                    startRow = row;
                    startCol = col;
                    break;
                }
            }
        }

        boolean hasWon = false;
        while (countOfCommands > 0) {
            String command = scanner.nextLine();
            int newRow = 0; //редът след преместване
            int newCol = 0; //колоната след преместване
            switch (command) {
                case "up":
                    newRow = isOutOfBounds(startRow - 1, size); //TODO: ПРОВЕРКА ДАЛИ РЕДЪТ В МАТРИЦАТА
                    newCol = isOutOfBounds(startCol, size); //TODO: ПРОВЕРКА ДАЛИ колоната В МАТРИЦАТА
                    if (matrix[newRow][newCol] == 'B') {
                        newRow = isOutOfBounds(startRow - 2, size);
                        newCol = isOutOfBounds(startCol, size);
                    }
                    break;
                case "down":
                    newRow = isOutOfBounds(startRow + 1, size);
                    newCol = isOutOfBounds(startCol, size);
                    if (matrix[newRow][newCol] == 'B') {
                        newRow = isOutOfBounds(startRow + 2, size);
                        newCol = isOutOfBounds(startCol, size);
                    }
                    break;
                case "left":
                    newRow = isOutOfBounds(startRow, size);
                    newCol = isOutOfBounds(startCol - 1, size);
                    if (matrix[newRow][newCol] == 'B') {
                        newRow = isOutOfBounds(startRow, size);
                        newCol = isOutOfBounds(startCol - 2, size);
                    }
                    break;
                case "right":
                    newRow = isOutOfBounds(startRow, size);
                    newCol = isOutOfBounds(startCol + 1, size);
                    if (matrix[newRow][newCol] == 'B') {
                        newRow = isOutOfBounds(startRow, size);
                        newCol = isOutOfBounds(startCol + 2, size);
                    }
                    break;
            }
            //проверка: на новата позиция имаме ли B, T, F
            if (matrix[newRow][newCol] == 'T') {
                //нямаме преместване
                newRow = startRow;
                newCol = startCol;
            } else {
                //има преместаване
                if (matrix[newRow][newCol] == 'F') {
                    hasWon = true;
                    matrix[startRow][startCol] = '-';
                    matrix[newRow][newCol] = 'f';
                    startRow = newRow;
                    startCol = newCol;
                    break;
                }
                matrix[startRow][startCol] = '-';
                matrix[newRow][newCol] = 'f';
                startRow = newRow;
                startCol = newCol;
            }
            countOfCommands--;
        }
        if (hasWon) {
            System.out.println("Player won!");
        } else {
            System.out.println("Player lost!");
        }
        printMatrix(matrix);

    }

    private static int isOutOfBounds(int value, int size) {
        //ако е вътрев матрицата ред или колона -> връщам стойността
        //ако е извън -> връщаме новата стойност
        if (value < 0) {
            value = size - 1;
        } else if (value >= size ) {
            value = 0;
        }
        return value;
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
