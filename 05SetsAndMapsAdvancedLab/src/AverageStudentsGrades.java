import java.util.*;

public class AverageStudentsGrades {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int studentsCount = Integer.parseInt(scanner.nextLine());
        Map<String, List<Double>> studentsGrades = new TreeMap<>();

        for (int i = 0; i < studentsCount; i++) {
            String[] studentInfo = scanner.nextLine().split("\\s+");
            String studentName = studentInfo[0];
            double currentGrade = Double.parseDouble(studentInfo[1]);

            studentsGrades.putIfAbsent(studentName, new ArrayList<>());
            studentsGrades.get(studentName).add(currentGrade);
        }

        studentsGrades.forEach((key, value) -> {
            double sumOfGrades = 0;

            for (Double aDouble : value) {
                sumOfGrades += aDouble;
            }

            double avrOfGrades = sumOfGrades / value.size();
            System.out.print(key + " -> ");

            value.forEach(e ->
                    System.out.printf("%.2f ", e));
            System.out.printf("(avg: %.2f)\n", avrOfGrades);
        });
    }
}
