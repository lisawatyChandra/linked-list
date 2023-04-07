package sortinguserdefinedobjects;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Employee {
    private String name;
    private double salary;
    private LocalDate joinDate;

    public Employee(String name, double salary, LocalDate joinDate) {
        this.name = name;
        this.salary = salary;
        this.joinDate = joinDate;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public LocalDate getJoinDate() {
        return joinDate;
    }

    @Override
    public String toString() {
        return "name = " + name + ", salary = " + salary + ", join date = " + joinDate.toString();
    }

    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Rajeev", 100000.00, LocalDate.of(2010, 7, 10)));
        employees.add(new Employee("Chris", 95000.50, LocalDate.of(2017, 3, 19)));
        employees.add(new Employee("David", 134000.00, LocalDate.of(2017, 9, 28)));
        employees.add(new Employee("Steve", 100000.00, LocalDate.of(2016, 5, 18)));

        for (Employee employee : employees) {
            System.out.println(employee);
        }

        System.out.println();

//        Collections.sort(employees, Comparator.comparing(Employee::getJoinDate));
//        System.out.println("Employees sorted by join date in ascending order:");
//        for (Employee employee : employees) {
//            System.out.println(employee);
//        }

        System.out.println();

        Collections.sort(employees, Comparator.comparing(Employee::getSalary)
            .thenComparing(Employee::getName));
        System.out.println("Employees sorted by salary and name in ascending order:");
        for (Employee employee : employees) {
            System.out.println(employee);
        }

        System.out.println();

        Collections.sort(employees, Comparator.comparing(Employee::getName).reversed());
        System.out.println("Employees sorted by name in descending order:");
        for (Employee employee : employees) {
            System.out.println(employee);
        }

        System.out.println();

        /*
            We can also use lambda expression for the second argument to `Collections.sort()`
         */
        Collections.sort(employees, (e1, e2) -> {
            if (e1.getJoinDate().compareTo(e2.getJoinDate()) > 0) {
                return 1;
            } else if (e1.getJoinDate().compareTo(e2.getJoinDate()) < 0) {
                return -1;
            } else {
                return 0;
            }
        });
        System.out.println("Employees sorted by join date in ascending order:");
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }
}
