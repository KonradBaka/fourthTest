package pl.kurs.exercise4.model;

import java.io.Serializable;
import java.util.Objects;

public class Person implements Serializable {

    private String firstName;
    private String lastName;
    private String town;
    private int age;

    public Person() {
    }

    public Person(String firstName, String lastName, String town, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.town = town;
        this.age = age;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age && Objects.equals(firstName, person.firstName) && Objects.equals(lastName, person.lastName) && Objects.equals(town, person.town);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, town, age);
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", town='" + town + '\'' +
                ", age=" + age +
                '}';
    }
}
