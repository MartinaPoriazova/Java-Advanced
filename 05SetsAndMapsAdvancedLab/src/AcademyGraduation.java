import java.util.*;

public class AcademyGraduation {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfStudents = Integer.parseInt(scanner.nextLine());
        Map<String, Double> studentsGrades = new TreeMap<>();

        while (numberOfStudents-- > 0) {
            String name = scanner.nextLine();
            String[] gradesArr = scanner.nextLine().split("\\s+");
            studentsGrades.putIfAbsent(name, 0.0);
            double sumOfGrades = 0;

            for (String grade : gradesArr) {
                sumOfGrades += Double.parseDouble(grade);
            }

            double avr = sumOfGrades / gradesArr.length;
            studentsGrades.put(name, avr);
        }

        studentsGrades.forEach((key, value) -> {
            System.out.println(key + " is graduated with " + value);
        });
    }
}
