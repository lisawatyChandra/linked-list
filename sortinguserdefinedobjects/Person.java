package sortinguserdefinedobjects;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Person implements Comparable<Person> {
    private final String name;
    private final int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public int compareTo(Person otherPerson) {
        int ageComparison = getAge() - otherPerson.getAge();
        return ageComparison != 0 ? ageComparison : getName().compareTo(otherPerson.getName());
    }

//    @Override
//    public int compareTo(Person otherPerson) {
//        return getAge() - otherPerson.getAge();
//    }

    @Override
    public String toString() {
        return String.format("name: %s, age: %d", getName(), getAge());
    }

    public static void main(String[] args) {
        List<Person> persons = new ArrayList<>();
        persons.add(new Person("John", 49));
        persons.add(new Person("Arnoud", 46));
        persons.add(new Person("Lisa", 46));
        persons.add(new Person("Celia", 46));

        Collections.sort(persons);
        for (Person person : persons) {
            System.out.println(person);
        }

        System.out.println();
        Collections.sort(persons, Collections.reverseOrder());
        for (Person person : persons) {
            System.out.println(person);
        }
    }
}
