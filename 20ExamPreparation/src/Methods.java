import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class Methods {
    // read deck

//    ArrayDeque<Integer> liquids = new ArrayDeque<>();
//        Arrays.stream(scan.nextLine().split("\\s+"))
//            .mapToInt(Integer::parseInt)
//                .forEach(liquids::offer);
//    ArrayDeque<Integer> ingredients = new ArrayDeque<>();
//        Arrays.stream(scan.nextLine().split("\\s+"))
//            .mapToInt(Integer::parseInt)
//                .forEach(ingredients::push);

// read  char Matrix

    private static char[][] readMatrix(int rows, int cols, Scanner scan) {
        char[][] matrix = new char[rows][cols];

        for (int row = 0; row < rows; row++) {
            String[] line = scan.nextLine().split("\\s+");
            for (int col = 0; col < matrix[row].length; col++) {
                char currentChar = line[col].charAt(0);
                matrix[row][col] = currentChar;
            }
        }
        return matrix;
    }

    // read  int Matrix със зададени роу и кол

    private static int[][] readMatrix(Scanner scanner) {
        String line = scanner.nextLine();
        String[] split = line.split("\\s+");
        int rows = Integer.parseInt(split[0]);
        int cols = Integer.parseInt(split[1]);
        int[][] matrix = new int[rows][cols];

        for (int row = 0; row < rows; row++) {
            line = scanner.nextLine();
            split = line.split("\\s+");
            for (int col = 0; col < cols; col++) {
                matrix[row][col] = Integer.parseInt(split[col]);
            }
        }
        return matrix;
    }

    // read int matrix

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

    // fill

    private static void fillMatrix(Scanner scanner, String[][] m, int rows) {
        for (int row = 0; row < rows; row++) {
            m[row] = scanner.nextLine().split("\\s+");
            //"1 2 3".split(" ") -> ["1", "2", "3"]
        }
    }

    // create char matrix от зададени роу и кол

    private static char[][] createMatrix(Scanner scanner, int rows, int cols) {
        char[][] matrix = new char[rows][cols];
        for (int row = 0; row < rows; row++) {
            String[] symbols = scanner.nextLine().split("\\s+");
            for (int col = 0; col < cols; col++) {
                matrix[row][col] = symbols[col].charAt(0);
            }
        }
        return matrix;
    }

    // create matrix of palindroms

    //3 2	aaa aba
    //      bbb bcb
    //      ccc cdc

    private static String[][] createMatrix(int rows,int cols){
        String[][] matrix = new String[rows][cols];

        char firstLetter = 'a';
        for (int row = 0; row < rows; row++) {
            char second = firstLetter;
            for (int col = 0; col < cols; col++) {
                matrix[row][col] = String.format("%c%c%c", firstLetter,second,firstLetter);
                second++;
            }
            firstLetter += 1;

        }
        return matrix;
    }


    // fill matrix standart

    private static void fillMatrix(int rows, int cols, int[][] matrix) {
        //fillMatrix
        int startNumber = 1;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                matrix[row][col] = startNumber++;
            }
        }
    }

    // fill matrix by cols

    private static void fillMatrixPatternB(int[][] matrix) {
        // 1    8
        // 2    7
        // 3    6
        // 4    5

        // четна колона - от 0 до последния
        // нечетна = последен до 0
        int startNumber = 1;
        for (int col = 0; col < matrix.length; col++) {
            if (col % 2 == 0) {
                for (int row = 0; row < matrix.length; row++) {
                    matrix[row][col] = startNumber++;
                }
            } else {
                for (int row = matrix.length - 1; row >= 0 ; row--) {
                    matrix[row][col] = startNumber++;
                }
            }
        }
    }

    private static void fillMatrixPatternA(int[][] matrix) {
        // 1    5
        // 2    6
        // 3    7
        // 4    8
        int startNumber = 1;
        for (int col = 0; col < matrix.length; col++) {
            for (int row = 0; row < matrix.length; row++) {
                matrix[row][col] = startNumber++;
//                startNumber++;
            }
        }
    }

    private static void fill(char[][] matrix, int row, int col, char fillChar, char startChar) {
        if (matrix[row][col] != startChar) {
            return;
        }

        matrix[row][col] = fillChar;

        if (row + 1 < matrix.length) {
            fill(matrix, row + 1, col, fillChar, startChar);
        }

        if (row - 1 >= 0) {
            fill(matrix, row - 1, col, fillChar, startChar);
        }

        if (col + 1 < matrix[row].length) {
            fill(matrix, row, col + 1, fillChar, startChar);
        }

        if (col - 1 >= 0) {
            fill(matrix, row, col - 1, fillChar, startChar);
        }
    }


    // print matrix

    public static void printMatrix(int rows, int cols, char[][] outputMatrix) {
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                System.out.print(outputMatrix[row][col] + " ");
            }
            System.out.println();
        }
    }

    private static void printMatrix(int[][] maxMatrix) {
        for (int[] arr : maxMatrix) {
            for (int c : arr) {
                System.out.print(c + " ");
            }
            System.out.println();
        }
    }

    // провери в граници ли е:

    private static boolean isInBounds(int[][] matrix, int row, int col) {
        return row >= 0 && row < matrix.length && col >= 0 && col < matrix[row].length;
    }

    // valid row i valid coll

    private static boolean isRowValid(boolean[][] hsChamber, int startPlRow) {
        return startPlRow >= 0 && startPlRow < hsChamber[startPlRow].length;
    }

    private static boolean isColValid(boolean[][] hsChamber, int startPlCol) {
        return startPlCol >= 0 && startPlCol < hsChamber.length;
    }


    // boolean дали е определен елемент

    private static boolean isCellFree(int row, int col, char[][] matrix) {
        return matrix[row][col] == '.';
    }


    // check for index in bound

    public static boolean isInBounds(int rows, int cols, int firstIndexForRow, int firstIndexForCol,
                                     int secondIndexForRow, int secondIndexForCol) {

        return firstIndexForRow < rows && firstIndexForRow >= 0 &&
                firstIndexForCol < cols && firstIndexForCol >= 0 &&
                secondIndexForRow < rows && secondIndexForRow >= 0 && secondIndexForCol < cols &&
                secondIndexForCol >= 0;
    }


        // boolean char Matrix - Посоки

    private static boolean check(char[][] chessTable, int row, int elem) {
        for (int i = elem + 1; i < chessTable[row].length; i++) { //RightHorizontal yes
            char charToCheck = chessTable[row][i];

            if (charToCheck == 'q') {
                return false;
            }
        }

        for (int i = elem - 1; i >= 0; i--) { //LeftHorizontal yes
            char charToCheck = chessTable[row][i];

            if (charToCheck == 'q') {
                return false;
            }
        }

        for (int i = row + 1; i < chessTable.length; i++) { //DownVertical yes
            char charToCheck = chessTable[i][elem];

            if (charToCheck == 'q') {
                return false;
            }
        }

        for (int i = row - 1; i >= 0; i--) { // UpVertical yes
            char charToCheck = chessTable[i][elem];

            if (charToCheck == 'q') {
                return false;
            }
        }
        int uldElement = elem - 1;

        for (int i = row - 1; i >= 0 && uldElement >= 0; i--, uldElement--) { // UpLeftDiagonal yes
            char charToCheck = chessTable[i][uldElement];

            if (charToCheck == 'q') {
                return false;
            }
        }
        int urdElement = elem + 1;

        for (int i = row - 1; i >= 0 && urdElement < chessTable[i].length; i--, urdElement++) { // UpRightDiagonal yes
            char charToCheck = chessTable[i][urdElement];

            if (charToCheck == 'q') {
                return false;
            }
        }
        int element = elem - 1;

        for (int i = row + 1; i < chessTable.length && element >= 0; i++, element--) { // DownLeftDiagonal
            char charToCheck = chessTable[i][element];

            if (charToCheck == 'q') {
                return false;
            }
        }
        int element1 = elem + 1;

        for (int i = row + 1; i < chessTable.length && element1 < chessTable[row].length; i++, element1++) { // DownRightDiagonal
            char charToCheck = chessTable[i][element1];

            if (charToCheck == 'q') {
                return false;
            }
        }
        return true;
    }


    // posoki:

    private static boolean isValidQueen(char[][] chessMatrix, int row, int col) {
        // right horizontal
        for (int i = col + 1; i < 8; i++) {
            char charToCheck = chessMatrix[row][i];
            if (charToCheck == 'q') {
                return false;
            }
        }
        // left horizontal
        for (int i = col - 1; i >= 0; i--) {
            char charToCheck = chessMatrix[row][i];
            if (charToCheck == 'q') {
                return false;
            }
        }
        // upper vertical
        for (int i = row - 1; i >= 0; i--) {
            char charToCheck = chessMatrix[i][col];
            if (charToCheck == 'q') {
                return false;
            }
        }
        // lower vertical
        for (int i = row + 1; i < 8; i++) {
            char charToCheck = chessMatrix[i][col];
            if (charToCheck == 'q') {
                return false;
            }
        }
        int element = col - 1;
        // upper left
        for (int i = row - 1; i >= 0 && element >= 0; i--, element--) {
            char charToCheck = chessMatrix[i][element];
            if (charToCheck == 'q') {
                return false;
            }
        }
        element = col + 1;
        // upper right
        for (int i = row - 1; i >= 0 && element < 8; i--, element++) {
            char charToChek = chessMatrix[i][element];
            if (charToChek == 'q') {
                return false;
            }
        }
        element = col - 1;
        // lower left
        for (int i = row + 1; i < 8 && element >= 0; i++, element--) {
            char charToCheck = chessMatrix[i][element];
            if (charToCheck == 'q') {
                return false;
            }
        }
        element = col + 1;
        //lower right
        for (int i = row + 1; i < 8 && element < 8; i++, element++) {
            char charToCheck = chessMatrix[i][element];
            if (charToCheck == 'q') {
                return false;
            }
        }
        return true;
    }

    // sum of diagonals:

    private static int getSumSecondaryDiagonal(int[][] matrix) {
        int sum = 0;
        // col = n - row - 1
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix.length; col++) {
                if (col == matrix.length - row - 1) {
                    sum += matrix[row][col];
                }

            }
        }
        return sum;
    }

    private static int getSumPrimaryDiagonal(int[][] matrix) {
        int sum = 0;
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix.length; col++) {
                if (row == col) {
                    sum += matrix[row][col];
                }
            }
        }
        return sum;
    }

    // rotate degreece

    private static void rotate(int rotationNumber, int rows, int cols, char[][] matrix) {
        if (rotationNumber == 90){
            for (int col = 0; col < cols; col++) {
                for (int row = rows - 1; row >= 0 ; row--) {
                    System.out.print(matrix[row][col]);
                }
                System.out.println();
            }
        }else if (rotationNumber == 180){
            for (int row = rows - 1; row >= 0; row--) {
                for (int col = cols - 1; col >= 0; col--) {
                    System.out.print(matrix[row][col]);
                }
                System.out.println();
            }
        }else if (rotationNumber == 270){
            for (int col = cols - 1; col >= 0 ; col--) {
                for (int row = 0; row < rows; row++) {
                    System.out.print(matrix[row][col]);
                }
                System.out.println();
            }
        }else {
            for (int row = 0; row < rows; row++) {
                for (int col = 0; col < cols; col++) {
                    System.out.print(matrix[row][col]);
                }
                System.out.println();
            }
        }
    }


    // Classes:

//    public boolean removeEmployee(String name) { -> премахва конкретно име
////        /*int index = -1;
////        for(int i = 0; i < employees.size();i++){
////            if(employees.get(i).getName().equals(name)){
////                index = i;
////            }
////        }
////        if(index == -1){
////            employees.remove(index);
////            return true;
////        }
////        return false;*/
    // OR:
////        int sizeBeforeRemove = employees.size();
////        employees.removeIf(employee -> employee.getName().equals(name));
////        return sizeBeforeRemove != employees.size();
//    }


//    public Pet getPet(String name, String owner) { -> филтрира и връща по някакъв признак
//        return this.data.stream()
//                .filter(pet -> pet.getName().equals(name) && pet.getOwner().equals(owner))
//                .findFirst().orElse(null);

//        //Pet currentPet = this.data.stream()
//        //        .filter(pet -> pet.getName().equals(name) && pet.getOwner().equals(owner))
//        //        .findFirst().orElse(null);
//        //
//        //return currentPet;
//
//    }

}
