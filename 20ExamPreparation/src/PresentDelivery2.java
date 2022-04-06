import java.util.Scanner;

public class PresentDelivery2 {
    public static int presents;
    public static int santaRow;
    public static int santaCol;
    public static int niceKids = 0;
    public static int giftedPresents = 0;
    public static int badKids = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        presents = Integer.parseInt(scanner.nextLine());

        int size = Integer.parseInt(scanner.nextLine());

        char[][] neighbourhood = new char[size][size];

        for (int r = 0; r < size; r++) {
            String line = scanner.nextLine().replaceAll("\\s+", "");
            neighbourhood[r] = line.toCharArray();

            if (line.contains("S")) {
                santaRow = r;
                santaCol = line.indexOf("S");
            }

            for (char e : line.toCharArray()) {
                if (e == 'V') {
                    niceKids++;
                } else if (e == 'X') {
                    badKids++;
                }
            }
        }

        int allNiceKids = niceKids;

        String direction = scanner.nextLine();

        while (!direction.equals("Christmas morning")) {
            if (direction.equals("up")) {
                ensureMoveSanta(neighbourhood, santaRow - 1, santaCol);
            } else if (direction.equals("down")) {
                ensureMoveSanta(neighbourhood, santaRow + 1, santaCol);
            } else if (direction.equals("left")) {
                ensureMoveSanta(neighbourhood, santaRow, santaCol - 1);
            } else {
                ensureMoveSanta(neighbourhood, santaRow, santaCol + 1);
            }

            if (presents <= 0) {
                break;
            }

            direction = scanner.nextLine();
        }

        if (presents <= 0 && giftedPresents - badKids <= niceKids) {
            System.out.println("Santa ran out of presents!");
        }

        printMatrix(neighbourhood);

        if (niceKids == 0) {
            System.out.println("Good job, Santa! " + allNiceKids + " happy nice kid/s.");
        } else {
            System.out.println("No presents for " + niceKids + " nice kid/s.");
        }
    }

    private static void ensureMoveSanta(char[][] neighbourhood, int newRow, int newCol) {

        if (isOutOfBounds(neighbourhood, newRow, newCol)) {
            presents = 0;
            return;
        }

        char nextStep = neighbourhood[newRow][newCol];

        if (nextStep == 'V') {
            presents--;
            niceKids--;
            giftedPresents++;
        } else if (nextStep == 'C') {
            givesPresents(neighbourhood, newRow, newCol);
        }

        neighbourhood[santaRow][santaCol] = '-';
        neighbourhood[newRow][newCol] = 'S';
        santaRow = newRow;
        santaCol = newCol;
    }

    private static void givesPresents(char[][] neighbourhood, int r, int c) {
        givePresents(neighbourhood, r - 1, c);
        givePresents(neighbourhood, r + 1, c);
        givePresents(neighbourhood, r, c - 1);
        givePresents(neighbourhood, r, c + 1);
    }

    private static void givePresents(char[][] neighbourhood, int row, int col) {
        char nextCell = neighbourhood[row][col];

        if (nextCell == 'X' || nextCell == 'V') {
            if (nextCell == 'V') {
                niceKids--;
            }
            presents--;
            giftedPresents++;
            neighbourhood[row][col] = '-';
        }
    }

    private static boolean isOutOfBounds(char[][] matrix, int r, int c) {
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