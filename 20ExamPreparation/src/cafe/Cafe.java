package cafe;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Cafe {
    private List<Employee> employees;
    private String cafeName;
    private int capacity;

    public Cafe(String name, int capacity) {
        this.cafeName = cafeName;
        this.capacity = capacity;
        this.employees = new ArrayList<>();
    }

    public void addEmployee(Employee employee) {
        if (this.employees.size() < this.capacity) {
            this.employees.add(employee);
        }
    }

    public boolean removeEmployee(String name) {
//        /*int index = -1;
//        for(int i = 0; i < employees.size();i++){
//            if(employees.get(i).getName().equals(name)){
//                index = i;
//            }
//        }
//        if(index == -1){
//            employees.remove(index);
//            return true;
//        }
//        return false;*/
        int sizeBeforeRemove = employees.size();
        employees.removeIf(employee -> employee.getName().equals(name));
        return sizeBeforeRemove != employees.size();
    }

    public Employee getOldestEmployee() {
        return employees.stream().max(Comparator.comparingInt(Employee::getAge)).get();
    }


    public Employee getEmployee(String name) {
        for (Employee employee : employees) {
            if (employee.getName().equals(name)) {
                return employee;
            }
        }
        return null;
    }

    public int getSize() {
        return this.employees.size();
    }

    public String report(){
        StringBuilder sb = new StringBuilder();
        sb.append("Employees working at Cafe ").append(this.cafeName).append(":").append(System.lineSeparator());
        employees.forEach(employee -> sb.append(employee).append(System.lineSeparator()));
        return sb.toString();
    }

}
