/**
 * This class defines an address using a streetNumber, city, state, and zip.
 */
public class Address {

    private String streetNumber;
    private String city;
    private String state;
    private String zip;

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
     * Set params
     *
     * @param streetNumber
     * @param city
     * @param state
     * @param zip
     */
    public void set(String streetNumber, String city, String state,
                    String zip) {
        this.streetNumber = streetNumber;
        this.city = city;
        this.state = state;
        this.zip = zip;
    }

    /**
     * Copy constructor
     *
     * @param object2
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