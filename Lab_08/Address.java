/**
 * This class defines an address using a streetNumber, city, state, and zip.
 */
public class Address {

    private final String streetNumber;
    private final String city;
    private final String state;
    private final String zip;

    /**
     * Constructor
     *
     * @param road Describes the streetNumber number and name.
     * @param town Describes the city.
     * @param st Describes the state.
     * @param zipCode Describes the zip code.
     */
    public Address(String road, String town, String st, String zipCode) {
        streetNumber = road;
        city = town;
        state = st;
        zip = zipCode;
    }

    /**
     * Copy constructor
     * @param object2 The Address object
     */
    public Address(Address object2) {
        streetNumber = object2.streetNumber;
        city = object2.city;
        state = object2.state;
        zip = object2.zip;
    }

    /**
     * The toString method
     *
     * @return Information about the address.
     */
    @Override
    public String toString() {
        return (streetNumber + ", " + city + ", " + state + " " + zip);
    }
}