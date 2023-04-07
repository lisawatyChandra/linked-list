## Guide to Comparable Interface

As we know that comparing primitive values like int, char, float is very easy and can 
be done with comparison operators like <, >, == etc.

But comparing objects is a little different. For example, how would you compare two
`Employee`s? How would you compare two `Student`s?

You need to explicitly define how the objects of user-defined classes should be compared.
For this purpose, Java provides two interfaces called `Comparable` and `Comparator`.


### 1. What will we learn?

* Overview of `Comparable` interface
* Sort user-defined objects in ascending order.
* Sort user-defined objects in descending order.
* Sort String and wrapper classes.

### 2. Overview of `Comparable` interface

By default, a user-defined class is not comparable. That is, its objects can't be compared.
To make an object comparable, the class must implement the `Comparable` interface.

The `Comparable` interface has a single method called `compareTo()` that you need to implement
in order to define how an object compares with the supplied object:
```java
public interface Comparable<T> {
    public int compareTo(T object);
}
```

When you define the `compareTo()` method in your classes, you need to make sure that the return
value of this method is:
* negative, if this object is less than the supplied object
* zero, if this object is equal to the supplied object
* positive, if this object is greater than the supplied object

*Note:*
Many predefined Java classes like `String`, `Date`, `LocalDate`, `LocalDateTime`, etc, 
implement the `Comparable` interface to define the (default) ordering of their instances.

`Comparable` interface provides default order for the objects of a class. This default ordering is 
also called the natural ordering of the objects. For example, if the `List` consists of `String`
elements, it will be sorted in alphabetical order. If it consists of `Date` elements, it will be 
sorted into chronological order. How does this happen? `String` and `Date` both implement the 
`Comparable` interface. 

`Comparable` implementation provides a natural ordering for a class, which allows objects of that
class to be sorted automatically.

How do you implement the `Comparable` interface in a user-defined class? By defining a `compareTo()`
method to make the objects of that class comparable.

### 3. Sort user-defined objects in ascending order

