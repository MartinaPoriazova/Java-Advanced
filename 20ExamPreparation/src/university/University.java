package university;

import java.util.ArrayList;
import java.util.List;

public class University {
    public List<Student> students;
    public int capacity;

    public University(int capacity) {
        this.capacity = capacity;
        this.students = new ArrayList<>();
    }

    public List<Student> getStudents() {
        return students;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getStudentCount() {
        int count = students.size();
        return count;
    }

    public String registerStudent(Student student) {
        if (students.size() < capacity) {
            if (!students.contains(student)) {
                students.add(student);
//            "Added student {firstName} {lastName}"
                return String.format("Added student %s %s", student.getFirstName(), student.getLastName());
            } else {
                return "Student is already in the university";
            }
        } else {
            return "No seats in the university";
        }
    }

    public String dismissStudent(Student student) {
        if (students.contains(student)) {
            students.remove(student);
            return String.format("Removed student %s %s", student.getFirstName(), student.getLastName());
        } else {
            return "Student not found";
        }
    }

    public Student getStudent(String firstName, String lastName) {
        return this.students.stream()
                .filter(student -> student.getFirstName().equals(firstName) && student.getLastName().equals(lastName))
                .findFirst().orElse(null);
    }

    public String getStatistics() {
        // ==Student: First Name = {firstName}, Last Name = {lastName}, Best Subject = {bestSubject}
        StringBuilder stringBuilder = new StringBuilder();

        for (Student student:students) {
            stringBuilder.append("==Student: First Name = ")
                    .append(student.getFirstName())
                    .append(", Last Name = ")
                    .append(student.getLastName())
                    .append(", Best Subject = ")
                    .append(student.getBestSubject())
                    .append("\n");
        }
      return stringBuilder.toString();
    }
}
