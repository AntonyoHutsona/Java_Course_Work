/**
 This class defines an address using a street,
 city, state, and zip.
 */
public class Address {

	private String street;					// The street number and name
	private String city;					// The city in which the address is located
	private String state;					// The state in which the address is located
	private String zip;						// The zip code associated with the city and street

	/**
	 Constructor
	 @param road Describes the street number and name.
	 @param town Describes the city.
	 @param st Describes the state.
	 @param zipCode Describes the zip code.
	 */
	public Address(String road, String town, String st, String zipCode) {
		street = road;
		city = town;
		state = st;
		zip = zipCode;
	}

	/**
	 * Set params
	 * @param street
	 * @param city
	 * @param state
	 * @param zip
	 */
	public void set(String street, String city, String state, String zip) {
		this.street = street;
		this.city = city;
		this.state = state;
		this.zip = zip;
	}

	/**
	 * Copy constructor
	 * @param object2
	 */
	public Address(Address object2) {
		street = object2.street;
		city = object2.city;
		state = object2.state;
		zip = object2.zip;
	}
	/**
	 The toString method
	 @return Information about the address.
	 */
	@Override
	public String toString() {
		return (street + ", " + city + ", " + state + " " + zip);
	}
}