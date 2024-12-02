

public class Family {

    // Instance variables to store the information about the people (maximally 10 people per family)
    private static final int MAX_PEOPLE = 10;
    private Person[] people;
    private int numPeople;

    // Default constructor that initializes the instance variables to a family of 0 people
    public Family() {
        people = new Person[MAX_PEOPLE];
        numPeople = 0;
    }

    // IO method to display the family(each object int the array)
    public void display() {
        for (int index = 0; index < numPeople; index++) {
            System.out.println(people[index]);
        }
    }

    // Mutator method to add a person to the family
    public boolean addPerson(String name, int age) {
        if (numPeople < MAX_PEOPLE) {
            people[numPeople] = new Person(name, age);
            numPeople++;
            return true;
        } else {
            return false;
        }
    }

    // Mutator method that makes the necessary changes for a birthday
    public void birthday(String name) {
        int i = 0;
        while (i < numPeople && !people[i].getName().equals(name)) {
            i++;
        }
        if (i < numPeople) {
            people[i].incrementAge();
        }
    }

    // Accessor method to return the number of people
    public int getNumberOfPeople() {
        return numPeople;
    }


    // Accessor method to return the total age of the people
    public int getTotalAge() {
        int totalAge = 0;
        for (int i = 0; i < numPeople; i++) {
            totalAge += people[i].getAge();
        }
        return totalAge;
    }
}//end of family class
