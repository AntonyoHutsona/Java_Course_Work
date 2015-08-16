/**
 * This class reads numbers from a file, calculates the
 * mean and standard deviation, and writes the results
 * to a file.
 *
 * Student:	    Antonyo Hutsona
 * Student-ID:	36225268
 * Class        CIS163AA
 * Assignment:	Chapter 4 Assignment
 */

// TODO: TASK #3 Add the file I/O import statement here
import java.io.*;
import java.text.DecimalFormat;
import java.util.Scanner;

public class StatsDemo {

	// TODO: Task #3 TASK #3 Add the throws clause
	public static void main(String[] args) throws IOException {

		double sum = 0;      															// The sum of the numbers
		double mean = 0;     															// The average of the numbers
		double stdDev = 0;   															// The standard deviation


		Scanner keyboard = new Scanner(System.in);										// Read from keyboard
		DecimalFormat precision = new DecimalFormat("#0.000");							// Control formatting

		// Prompt the user and read in the file name
		System.out.println("This program calculates statistics on a file " +
				"containing a series of numbers.");
		System.out.print("Enter the file name:  ");
		String filename = keyboard.nextLine();

		// TODO: Task #4 Calculating the Mean
		File file = new File(filename);                            						// Open the file
		Scanner inputFile = new Scanner(file);                    						// Read the file

		/*
	  	 * Loop to read ahead calculate the sum
	  	 */
		int count = 0;
		while (inputFile.hasNext()) {
			double number = inputFile.nextDouble();
			sum += number;
			count++;
		}
		inputFile.close();

		// Calculation of the mean
		mean = sum / count;

		// TODO: Task #5 Calculating the Standard Deviation
		File fileTwo = new File(filename);                        						// Open the file
		Scanner inputFileTwo = new Scanner(fileTwo);            						// Read the file

	  	/*
	  	 * Loop to read ahead calculate the sum
	  	 * of the square of the difference
	  	 */
		count = 0;
		sum = 0;
		while (inputFileTwo.hasNext()) {
			sum += Math.pow(inputFileTwo.nextDouble() - mean, 2.0);
			count++;
			/*
		     * Seems redundant, but its what #5 part d wants
		     * the whole point of the hasNext method is to look
		     * ahead for more data
		     */
			if (inputFileTwo.hasNextDouble()) {
				inputFileTwo.nextLine();
			}
		}
		inputFileTwo.close();

		// Calculation of standard deviation
		double variance = sum / count;
		stdDev = Math.sqrt(variance);

		// TODO: Task #3 Writing Output to a File
		FileWriter fileWriter = new FileWriter("Results.txt");							// Open/Create file
		PrintWriter printWriter = new PrintWriter(fileWriter);							// Write to file

		// Write to Results file
		printWriter.println("The Mean & the Standard Deviation are as follows:");
		printWriter.println("Mean = " + precision.format(mean));
		printWriter.println("Standard Deviation = " + precision.format(stdDev));
		printWriter.close();

		// Display message to user
		System.out.print("The calculations of the Mean and the Standard Deviation\ncan be found in " +
						"\"Results.txt\", located in your \ncurrent working directory.");
	}
}