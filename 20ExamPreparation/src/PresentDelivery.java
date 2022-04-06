import java.util.Scanner;

public class PresentDelivery {

    public static int presents;
    public static int santaROw;
    public static int santaCol;
    public static int niceKids = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        presents = Integer.parseInt(scanner.nextLine());
        int size = Integer.parseInt(scanner.nextLine());
        char[][] neighbourhood = new char[size][size];

        for (int i = 0; i < size; i++) {
            String line = scanner.nextLine().replaceAll("\\s+", "");
            neighbourhood[i] = line.toCharArray();

            if (line.contains("S")) {
                santaROw = i;
                santaCol = line.indexOf("S");
            } else if (line.contains("V")) {
                santaROw = i;
                santaCol = line.indexOf("S");
            }


        }

        int allNiceKids = niceKids;
        String direction = scanner.nextLine();

        while (presents > 0 && !direction.equals("Christmas morning")) {
            if (direction == "up") {
                moveSanta(neighbourhood);
            }
            direction = scanner.nextLine();
        }

        if (presents == 0) {
            System.out.println("Santa ran out of presents.");
        }
        printMatrix(neighbourhood);

        if (niceKids == 0) {
            System.out.printf("Good job, Santa! %d happy nice kid/s.\n", allNiceKids);
        } else {
            System.out.printf("No presents for %d nice kid/s.\n", niceKids);
        }

    }

    private static void moveSanta(char[][] neighbourhood) {
        int newRow = santaROw - 1;
        int newColl = santaCol;

        if (isOutOfBoubds(neighbourhood, newRow, newColl)) {
            presents = 0;
            return;
        }
        char nextStep = neighbourhood[newRow][newColl];
        if (nextStep == 'v') {
            presents--;
        } else if (nextStep == 'C') {
            givesPresents(neighbourhood, newRow, newColl);
        }
        neighbourhood[santaROw][santaCol] = '-';
        neighbourhood[newRow][newColl] = 'S';
        santaROw = newRow;
        santaCol = newColl;
    }

    private static void givesPresents(char[][] neighbourhood, int r, int c) {
        int row = r-1;
        int col = c;
        char nextCell = neighbourhood[row][col];
        if (nextCell == 'X' || nextCell == 'V') {
            if (nextCell == 'V') {
                niceKids--;
            }
            presents--;
            neighbourhood[row][col] = '-';
        }
    }

    private static boolean isOutOfBoubds(char[][] matrix, int r, int c) {
        return r < 0 || r >= matrix.length || c < 0 || c >= matrix[r].length;
    }


    public static void printMatrix(char[][] matrix) {
        for (char[] arr : matrix) {
            for (char c : arr) {
                System.out.print(c + " ");
            }
            System.out.println();
        }
    }

}
