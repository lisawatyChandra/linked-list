package comparator.example1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/*
    In order to be able to use Collections.sort() on a list
    of Dog, without explicitly passing in a comparator object,
    the Dog class must implement Comparable<Dog> and overrides
    `compareTo` method of the Comparable interface.
    The `compareTo` method will determine the Dog objects'
    natural ordering when we call the following method:
    `Collections.sort(listOfDogs)`

    Then, when we want to sort the list of Dog objects by attributes
    other than the attribute used in its natural ordering, we must
    implement Comparator<Dog> and overrides `compare` method of the
    Comparator interface. Then we can call this method:
    `Collections.sort(listOfDogs, an instance of Dog with no args constructor)`
 */
public class Dog implements Comparator<Dog>, Comparable<Dog> {
    private String name;
    private int age;

    public Dog() {}

    public Dog(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getDogName() {
        return name;
    }

    public int getDogAge() {
        return age;
    }

    // this method overrides Comparable#compareTo method,
    // this method is used to determine this object's
    // natural ordering
    @Override
    public int compareTo(Dog dog) {
        return getDogName().compareTo(dog.getDogName());
    }

    // this method overrides Comparator#compare method,
    // this method is used to determine this object's
    // alternate ordering.  Since this object has only
    // two attributes, one used as its natural ordering,
    // the other as its alternate ordering
    @Override
    public int compare(Dog dog1, Dog dog2) {
        return dog1.getDogAge() - dog2.getDogAge();
    }

    @Override
    public String toString() {
        return String.format("%s: %d", getDogName(), getDogAge());
    }

    public static void main(String[] args) {
        // takes a list of Dog objects
        List<Dog> list = new ArrayList<>();
        list.add(new Dog("Shaggy", 3));
        list.add(new Dog("Lacy", 2));
        list.add(new Dog("Roger", 10));
        list.add(new Dog("Tommy", 4));
        list.add(new Dog("Tammy", 1));

        Collections.sort(list, new Dog());
        for (Dog dog : list) {
            System.out.println(dog);
        }
        System.out.println();

        /*
            If Dog didn't implement Comparable<Dog>, calling `Collections.sort(listOfDogs)`
            will cause the following error:

            Required type: List<T>
            Provided: List<Dog>
            Reason: no instance(s) of type variable(s) T exist so that Dog conforms to Comparable<? Super T>

         */
        Collections.sort(list);
        list.forEach(System.out::println);
    }
}
