/**
 * This class defines a person by name and address.
 */

public class Person {

    private final String lastName;
    private final String firstName;
    private final Address home;

    /**
     * Constructor
     * @param last The person's last name.
     * @param first The person's first name.
     * @param residence The person's address.
     */
    public Person(String last, String first, Address residence) {
        lastName = last;
        firstName = first;
        home = new Address(residence);
    }

    /**
     * Copy constructor
     * @param personTwo The Person object
     */
    public Person(Person personTwo) {
        lastName = personTwo.lastName;
        firstName = personTwo.firstName;
        home = personTwo.home;
    }

    /**
     * Copy constructor
     * @return home The Address of Person
     */
    private Address getHome() {
        return new Address(this.home);
    }

    /**
     * The toString method
     * @return Information about the person.
     */
    public String toString() {
        return (firstName + " " + lastName + ", " + getHome());
    }
}