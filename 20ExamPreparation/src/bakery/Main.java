package bakery;

public class Main {
    public static void main(String[] args) {
        Bakery bakery = new Bakery("Barny", 10);
        Employee employee = new Employee("Stephen", 40, "Bulgaria");
        System.out.println(employee);

        bakery.add(employee);

        System.out.println(bakery.remove("Employee name"));

        Employee secondEmployee = new Employee("Mark", 34, "UK");
        bakery.add(secondEmployee);

        Employee oldestEmployee = bakery.getOldestEmployee(); // Employee with name Stephen
        Employee employeeStephen = bakery.getEmployee("Stephen"); // Employee with name Stephen
        System.out.println(oldestEmployee); //Employee: Stephen, 40 (Bulgaria)
        System.out.println(employeeStephen); //Employee: Stephen, 40 (Bulgaria)

        System.out.println(bakery.getCount()); //2

        System.out.println(bakery.report());
    }
}
