
import java.util.Scanner;  // Needed for the Scanner class

/**
 * This class demonstrates the Television class.
 *
 * @author ahutsona
 * Student-ID:	36225268
 * Class        CIS163AA
 * Chapter 6 Assignment
 */

public class TelevisionDemo {

   public static void main(String[] args) {

	    // Create a Scanner object to read from the keyboard
		Scanner keyboard = new Scanner (System.in);

		// Declare and instantiate a television object
		Television bigScreen = new Television("Toshiba", 55);

		// Turn the power on
		bigScreen.isPowerOn(1);

		// Display the state of the television
	   	getTVInfo(bigScreen);

		// Prompt the user for input and store into station
		System.out.print("What channel do you want? ");
	   	int bigScreenTVStation = keyboard.nextInt();

		// Change the channel on the television and adjust volume
		bigScreen.setChannel(bigScreenTVStation);
		bigScreen.increaseVolume(1);

		/*
		 * Display the the current channel and
		 * volume of the television and
		 * adjust volume
		 */
	   	getTVState(bigScreen);
	   	System.out.println("Too loud! Lowering the volume.");
		bigScreen.decreaseVolume(6);

		/*
		 * Display the the current channel and
		 * volume of the television
		 */
		getTVState(bigScreen);
      	// TODO: HERE IS WHERE YOU DO TASK #5
      	// Second object of the Television class
		Television portable = new Television("Sharp",19);

	   	// Turning the TV power on
	   	portable.isPowerOn(true);

	    // Display the state of the television
	   	System.out.println();
	  	getTVInfo(portable);

	   	/*
	   	 * Get and set channel preference from user
	   	 * Make adjustments to volume
	   	 */
	   	System.out.print("What channel would you like for me to go to? ");
	    int portableTVStation = keyboard.nextInt();
	   	portable.setChannel(portableTVStation);
	   	portable.decreaseVolume(2);

	   	/*
		 * Display the the current channel and
		 * volume of the television
		 */
	   getTVState(portable);

   }
	public static void getTVInfo(Television tv) {
		System.out.println("A " + tv.getScreenSize() + " inch " +
				tv.getManufacturer() + " has been turned " + tv.getPowerState());
	}
	public static void getTVState(Television tv) {
		System.out.println("Channel: " + tv.getChannel() + " Volume: " + tv.getVolume());
	}

}