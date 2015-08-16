import java.io.*;
import java.util.Scanner;


/**
 * Program to read in an input file and grag a message from the file.
 * @author ahutsona
 *
 * Student-ID:	36225268
 * Class        CIS163AA
 * Assignment:	Chapter 9 Lab Task 2
 */
public class SecretMessage {

    /**
     * Main method of the SecretMessage program.
     * @param args Not used
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {

        // Objects to read in files
        Scanner inputFile = getScanner();

        // Flag to keep reading or not
        boolean readLine = isReadLine(inputFile);

        // Place holder for the input
        String messageLine = "";
        // Read in input
        messageLine = getInput(inputFile, readLine, messageLine);

        // Get the tokens, using space as the delimiter.
        String[] tempArrayOne = getMessage(messageLine);

        // Display the message.
        displayMessage(tempArrayOne);

    }

    /**
     * Method to determine if the input file still has more to be read.
     * @param inputFile
     * @return true/false
     */
    private static boolean isReadLine(Scanner inputFile) {
        return inputFile.hasNext();
    }

    /**
     * Method to open and read in files
     * @return file for scanner to read from
     * @throws FileNotFoundException
     */
    private static Scanner getScanner() throws FileNotFoundException {
        File file = new File("secret.txt");
        return new Scanner(file);
    }

    /**
     * Method to return in the entire contents of the file as one string.
     * @param inputFile
     * @param readLine
     * @param messageLine
     * @return messageLine the contents of the file
     */
    private static String getInput(Scanner inputFile, boolean readLine, String messageLine) {
        if (readLine) {
            messageLine = inputFile.nextLine();
        }
        return messageLine;
    }

    /**
     * Method to take the first charter of every fifth word.
     * @param messageLine
     * @return tempArrayOne the array of strings
     */
    private static String[] getMessage(String messageLine) {
        String[] tokens = messageLine.split(" ");
        String[] tempArrayOne = new String[tokens.length];
        // Grab the first charter of every fifth word
        for (int i = 0; i < tokens.length; i+=5) {
            tempArrayOne[i] = String.valueOf(tokens[i].charAt(0));
        }
        return tempArrayOne;
    }

    /**
     * Method to display results.
     * @param tempArrayOne
     */
    private static void displayMessage(String[] tempArrayOne) {
        for (String secretMessage : tempArrayOne)
            if(secretMessage != null) {
                System.out.print(toUpperCase(secretMessage));
            }
    }

    /**
     * Method to convert charters in a string to uppercase.
     * @param input
     * @return uppercase
     */
    private static String toUpperCase(String input) {

        StringBuffer upperCase = new StringBuffer();

        for (char c : input.toCharArray()) {
            c = Character.toUpperCase(c);
            upperCase.append(c);
        }
        return upperCase.toString();
    }

}
