import java.text.DecimalFormat;
import java.util.Random;   																// Needed for the Random class

/**
 * This class simulates rolling a pair of dice 10,000 times
 * and counts the number of times doubles of are rolled for
 * each different pair of doubles.
 *
 * @author ahutsona
 * Student-ID:	36225268
 * Class        CIS163AA
 * Assignment:	Chapter 4 Assignment
*/

public class DiceSimulation
{
   public static void main(String[] args)
   {
      	final int NUMBER = 10000 + 1;  													// Number of dice rolls

		int die1Value;       															// Value of the first die
      	int die2Value;       															// Value of the second die
      	int snakeEyes = 0;   															// Number of snake eyes rolls
      	int twos = 0;        															// Number of double two rolls
      	int threes = 0;      															// Number of double three rolls
      	int fours = 0;       															// Number of double four rolls
      	int fives = 0;       															// Number of double five rolls
      	int sixes = 0;       															// Number of double six rolls

      	/*
	     * TODO: TASK #1 Enter your code for the algorithm here
	     * TODO: Task #2 Using Other Types of Loops
	     */

	    /*
      	 * A random number generator used in
      	 * simulating the rolling of dice
      	 */
	   	Random generator = new Random();

	   	// DecimalFormat object used for formatting
		DecimalFormat numberFormat = new DecimalFormat("#,#00");

	   	System.out.println("Rolling the dice 10,000 times ...");
	   	System.out.println();

	   	int count;
	   	for (count = 1; count < NUMBER; count++) {
		   	System.out.println("Roll: " + numberFormat.format(count));
		   	die1Value = generator.nextInt(6) + 1;
		   	System.out.printf("First die rolled: %d%n", die1Value);
		   	die2Value = generator.nextInt(6) + 1;
		   	System.out.printf("Second die rolled: %d%n%n", die2Value);

		   	if (die1Value == die2Value) {
			   	if (die1Value == 1) {
				   	snakeEyes++;
			   	} else if (die1Value == 2) {
				   	twos++;
			   	} else if (die1Value == 3) {
				   	threes++;
			   	} else if (die1Value == 4) {
				   	fours++;
			   	} else if (die1Value == 5) {
				   	fives++;
			   	} else if (die1Value == 6) {
				   	sixes++;
			   	}
		   	}
	   	}

    	// Display the results
	   	count--;
      	System.out.println ("You rolled snake eyes " + snakeEyes + " times out of " +
							numberFormat.format(count) + " rolls.");
      	System.out.println ("You rolled double twos " + twos + " times out of " +
							numberFormat.format(count) + " rolls.");
      	System.out.println ("You rolled double threes " + threes + " times out of " +
							numberFormat.format(count) + " rolls.");
      	System.out.println ("You rolled double fours " + fours +" times out of " +
							numberFormat.format(count) + " rolls.");
      	System.out.println ("You rolled double fives " + fives + " times out of " +
							numberFormat.format(count) + " rolls.");
      	System.out.println ("You rolled double sixes " + sixes + " times out of " +
							numberFormat.format(count) + " rolls.");
   }
}