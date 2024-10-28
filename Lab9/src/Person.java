

// Define the Person class
public class Person {

    // Instance variables to store the name and age of a person
    private String name;
    private int age;

    // Default constructor
    public Person() {
        name = "";
        age = 0;
    }

    // Constructor that takes a name and age to initialize the instance variables
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // toString method to return a string representation of the person, formatted ala "Fred is 32 years old"
    public String toString() {
        return name + " is " + age + " years old";
    }

    // Mutator method to increment the age of the person
    public void incrementAge() {
        age++;
    }

    // Accessor method to return the name of the person
    public String getName() {
        return name;
    }

    // Accessor method to return the age of the person
    public int getAge() {
        return age;
    }
}
