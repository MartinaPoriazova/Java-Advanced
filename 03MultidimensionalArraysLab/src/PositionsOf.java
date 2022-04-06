import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PositionsOf {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[][] matrix = readMatrix(scanner);
        int number = Integer.parseInt(scanner.nextLine());

        boolean isFound = false;
        List<int[]> output = new ArrayList<>();

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                int currentNumber = matrix[row][col];
                if (currentNumber == number) {
                    output.add(new int[]{row, col});
                    // ako e boolean ->
//                    isFound = true;
//                    System.out.println(row + " " + col);
                    // ako e List of String->
                    // output.add(row + " " + col);
                }
            }
        }

        if (output.isEmpty()) {
            System.out.println("not found");
        } else {
            for (int[] indexes : output) {
                System.out.println(indexes[0] + " " + indexes[1]);
            }
        }
        // ako e List ot String:
//        if (output.isEmpty()) {
//            output.add("not found");
//        }
//        for (String s:output) {
//            System.out.println(s);
//        }
        // boolean:
//        if (!isFound) {
//            System.out.println("not found");
//        }

    }

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
}
