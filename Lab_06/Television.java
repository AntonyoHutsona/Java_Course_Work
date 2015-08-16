/**
 * This class handles various attributes of a television
 *
 * @author ahutsona
 * Student-ID:	36225268
 * Class        CIS163AA
 * Chapter 6 Assignment
 */
public class Television {

	private int volume;
	private boolean powerOn;
	private int channel;
	private final String MANUFACTURE;
	private final int SCREEN_SIZE;
	
	/**
	 * Constructor that initializes several instance variables
	 * @param manufacture
	 * @param screenSize
	 */
	public Television(String manufacture, int screenSize) {
		MANUFACTURE = manufacture;
		SCREEN_SIZE = screenSize;
		powerOn = false;
		volume = 20;
		channel = 2;
	}
	
	/**
	 * This method sets the power state
	 * advised input 1 or 0
	 * @param state
	 */
	public boolean isPowerOn(int state) {
		return powerOn = (state == 1);
	}

	/**
	 * This method sets the power state
	 * advised input true or false
	 * @param powerOn
	 */
	public void isPowerOn(boolean powerOn) {
		this.powerOn = powerOn;
	}

	/**
	 * This method sets the channel
	 * @param channel
	 */
	public void setChannel(int channel) {
		this.channel = channel;
	}

	/**
	 * This method increases the volume n number of times
	 * @param volume
	 */
	public void increaseVolume(int volume) {
		this.volume += volume;
	}

	/**
	 * This method decreases the volume n number of times
	 * @param volume
	 */
	public void decreaseVolume(int volume) {
		this.volume -= volume;
	}

	/**
	 * This method gets the current channel
	 * @return channel the users chosen channel
	 */
	public int getChannel() {
		return channel;
	}

	/**
	 * This returns the screen size
	 * @return SCREEN_SIZE the size of the TV passed to the constructor
	 */
	public int getScreenSize() {
		return SCREEN_SIZE;
	}

	/**
	 * This method returns the volume
	 * @return volume the current volume level
	 */
	public int getVolume() {
		return volume;
	}

	/**
	 * This returns the manufacturer
	 * @return MANUFACTURE the size of the TV passed to the constructor
	 */
	public String getManufacturer() {
		return MANUFACTURE;
	}

	/**
	 * This method returned the state of the TV
	 * @return the state of the TV off or on
	 */
	public String getPowerState() {
		return powerOn ? "on" : "off";
	}

}
