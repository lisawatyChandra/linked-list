package treeset;

import java.util.TreeSet;

public class TreeSetDemo {
    public static void main(String[] args) {
        // Creating a TreeSet whose nodes are sorted by name
        TreeSet<Employee> tSetSortedByName = new TreeSet<>(new NameComparator());
        tSetSortedByName.add(new Employee("Lisa", 125000));
        tSetSortedByName.add(new Employee("Arnoud", 134000));
        tSetSortedByName.add(new Employee("Lisa", 12500));
        tSetSortedByName.add(new Employee("Celia", 15000));
        tSetSortedByName.add(new Employee("Lily", 150000));
        tSetSortedByName.add(new Employee("Brenda", 5000));
        tSetSortedByName.add(new Employee("Julian", 105000));

        for (Employee e : tSetSortedByName) {
            System.out.println(e);
        }

        System.out.println("**************************************");

        // Creating a TreeSet whose nodes are sorted by salary
        TreeSet<Employee> tsetSortedBySalary = new TreeSet<>(new SalaryComparator());
        tsetSortedBySalary.add(new Employee("Lisa", 125000));
        tsetSortedBySalary.add(new Employee("Lisa", 115000));
        tsetSortedBySalary.add(new Employee("Lisa", 105000));
        tsetSortedBySalary.add(new Employee("Lisa", 95000));
        tsetSortedBySalary.add(new Employee("Emily", 125000));
        tsetSortedBySalary.add(new Employee("Phoebe", 125000));
        tsetSortedBySalary.add(new Employee("Lucy", 125000));

        for (Employee e : tsetSortedBySalary) {
            System.out.println(e);
        }
    }
}

/*

Name: Arnoud -- Salary: 134000
Name: Brenda -- Salary: 5000
Name: Celia -- Salary: 15000
Name: Julian -- Salary: 105000
Name: Lily -- Salary: 150000
Name: Lisa -- Salary: 125000
[NOTE: different employees with identical names will not get inserted into the TreeSet]

**************************************

Name: Lisa -- Salary: 95000
Name: Lisa -- Salary: 105000
Name: Lisa -- Salary: 115000
Name: Lisa -- Salary: 125000
[NOTE:  different employees with identical salary will not get inserted into the TreeSet]

 */
