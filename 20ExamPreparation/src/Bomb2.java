import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

    public class Bomb2 {
        public static void main(String[] args) {
            Scanner scan = new Scanner(System.in);
            int size = Integer.parseInt(scan.nextLine());
            String [] commands = scan.nextLine().split(",");
            String[][] field = readMatrix(scan, size);

            List<Integer> position = new ArrayList<>();
            int countOfBombs = 0;
            List<Integer> endPosition = new ArrayList<>();

            findStartPositionAnd(size, field, position,endPosition);

            countOfBombs = getCountOfBombs(size, field, countOfBombs);

            boolean reachTheEnd = false;
            boolean bombsAreCleared = false;

            for(String com : commands){
                int row = position.get(0);
                int col = position.get(1);
                switch (com){
                    case "up":
                        row--;
                        if (row < 0){
                            row++;
                        }
                        break;
                    case "down":
                        row++;
                        if (row == size ){
                            row--;
                        }

                        break;
                    case "left":
                        col--;
                        if (col < 0){
                            col--;
                        }
                        break;
                    case "right":
                        col++;
                        if (col == size ){
                            col--;
                        }
                        break;

                }
                if (field[row][col].equals("B")){
                    field[row][col] = "+";
                    System.out.println("You found a bomb!");
                    countOfBombs--;
                    if (countOfBombs == 0){
                        bombsAreCleared = true;
                    }
                }else if (field[row][col].equals("e")){
                    reachTheEnd = true;
                }

                position.set(0, row);
                position.set(1, col);
                if (bombsAreCleared || reachTheEnd) {
                    break;
                }

            }

            if (bombsAreCleared){
                System.out.println("Congratulations! You found all bombs!");
            }else if (reachTheEnd){
                System.out.printf("END! %d bombs left on the field%n", countOfBombs);
            }else {
                System.out.printf("%d bombs left on the field. Sapper position: (%d,%d)", countOfBombs, position.get(0) , position.get(1) );
            }


        }

        private static int getCountOfBombs(int size, String[][] field, int countOfBombs) {
            for (int r = 0; r < size; r++) {
                for (int c = 0; c < size; c++) {
                    if (field[r][c].equals("B")){
                        countOfBombs++;
                    }
                }
            }
            return countOfBombs;
        }


        private static void findStartPositionAnd(int size, String[][] field, List<Integer> position,List<Integer> endPosition) {
            for (int r = 0; r < size; r++) {
                for (int c = 0; c < size; c++) {
                    if (field[r][c].equals("s")){
                        position.add(r);
                        position.add(c);
                    }
                    if (field[r][c].equals("e")){
                        endPosition.add(r);
                        endPosition.add(c);
                    }
                }
            }
        }

        private static String[][] readMatrix(Scanner scan, int size) {
            String[][] matrix = new String[size][size];

            for (int r = 0; r < size; r++) {
                matrix[r] = scan.nextLine().split("\\s+");
            }
            return matrix;
        }
    }

