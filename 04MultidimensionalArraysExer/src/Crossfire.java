import java.util.Scanner;

public class Crossfire {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String dimensions = scanner.nextLine(); //"3 4" -> split -> ["3", "4"]
        int rows = Integer.parseInt(dimensions.split("\\s+")[0]);
        int cols = Integer.parseInt(dimensions.split("\\s+")[1]);

        int[][] matrix = new int[rows][cols];
        fillMatrix(rows, cols, matrix);

        String command = scanner.nextLine();
        while (!command.equals("Nuke it from orbit")) {
            //command = "3 3 2"
            int row = Integer.parseInt(command.split("\\s+")[0]);
            int col = Integer.parseInt(command.split("\\s+")[1]);
            int radius = Integer.parseInt(command.split("\\s+")[2]);

            //махаме по редове -> започваме от: текущия ред - радиус до текущия ред + радиуса
            for (int rowToRemove = row - radius; rowToRemove <= row + radius; rowToRemove++) {
                //проверка дали редът, който ще махна е в матрицата
                if (rowToRemove >= 0 && rowToRemove < rows) {
                    matrix[rowToRemove][col] = 0;
                }
            }

            //махаме по колони -> започваме от: текуща колона - радиус до текуща колона + радиуса
            for (int colToRemove = col - radius; colToRemove <= col + radius; colToRemove++) {
                //проверка дали колоната, който ще махна е в матрицата
                if (colToRemove >= 0 && colToRemove < cols) {
                    matrix[row][colToRemove] = 0;
                }
            }
            removeAllZeroElements(matrix, rows);
            command = scanner.nextLine();
        }
    }

    private static void removeAllZeroElements(int[][] matrix, int rows) {
        //TODO: премахваме всички 0
        //TODO: всички елементи в реда са 0 ->  трябва да премахнем реда
        //1    2   3   4   5
        //6    7   8   0   10
        //11   12  13  0   15
        //16   0   0   0    0
        //21   22  23  0    25
    }

    private static void fillMatrix(int rows, int cols, int[][] matrix) {
        //fillMatrix
        int startNumber = 1;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                matrix[row][col] = startNumber++;
            }
        }
    }

    public static void printMatrix(String[][] matrix, int rows, int cols) {
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }
}
