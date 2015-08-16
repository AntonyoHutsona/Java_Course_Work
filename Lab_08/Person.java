/**
 This class defines a person by name and address.
 */

public class Person {

	private String lastName;				// The person's last name
	private String firstName;				// The person's first name
	private Address home;					// The person's address

	/**
	 Constructor
	 @param last The person's last name.
	 @param first The person's first name.
	 @param residence The person's address.
	 */
	public Person(String last, String first, Address residence) {
		lastName = last;
		firstName = first;
		home = new Address(residence);
	}

	/**
	 * Copy constructor
	 * @param personTwo
	 */
	public Person(Person personTwo) {
		lastName = personTwo.lastName;
		firstName = personTwo.firstName;
		home = personTwo.home;

	}

	/**
	 * Set lastName
	 * @param lastName
	 */
	public void setLastName(String lastName) {this.lastName = lastName;}

	/**
	 * Set firstName
	 * @param firstName
	 */
	public void setFirstName(String firstName) {this.firstName = firstName;}

	/**
	 * Copy constructor
	 * @return home
	 */
	public Address getHome() {return new Address(this.home);}

	/**
	 The toString method
	 @return Information about the person.
	 */
	public String toString() {
		return(firstName + " " + lastName + ", " + getHome());
	}
}