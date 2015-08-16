import java.io.*;
import java.util.*;

/**
 * Write a program that reads babynames.txt and produces two files,
 * boynames.txt and girlnames.txt
 *
 * @author ahutsona
 * Student-ID:	36225268
 * Class        CIS150AA
 * Assignment:	OOP_ P11.1
 */

public class BabyNames {

    /**
     * Main method for BabyNames program.
     * @param args Not used
     */
    public static void main(String[] args) {

        // ArrayList to hold the names
        ArrayList<String> maleBabyNames = new ArrayList<>();
        ArrayList<String> femaleBabyNames = new ArrayList<>();

        // Scanner to read input files
        Scanner inputFile = getScanner();

        // Sort the input
        arrangeInputData(maleBabyNames, femaleBabyNames, inputFile);

        // Write to file
        writeToFile(maleBabyNames, femaleBabyNames);
        maleBabyNames.forEach(System.out::println);

    }

    /**
     * Method to create a file t read from.
     * @return the input file to be read in
     */
    private static Scanner getScanner()  {

        File file = null;
        Scanner read = null;
        try {
            file = new File("babynames.txt");
            read = new Scanner(file);
        } catch (FileNotFoundException e) {
            System.out.println("The " + file + " file could either not be found or opened.");
            e.printStackTrace();
        }
        if (read == null) {
            throw new AssertionError("The value of `read` can not be null. Method call `getScanner`");
        }
        return read;
    }

    /**
     * Method to sort out the baby names into an array list of boy & girl names.
     * @param maleBabyNames
     * @param femaleBabyNames
     * @param inputFile
     */
    private static void arrangeInputData(ArrayList<String> maleBabyNames, ArrayList<String> femaleBabyNames,
                                         Scanner inputFile) {

        inputFile.useDelimiter("[^aA-zZ]+");
        while (inputFile.hasNext()) {
            String maleNames = inputFile.next();
            String femaleNames = inputFile.next();
            maleBabyNames.add(maleNames);
            femaleBabyNames.add(femaleNames);
        }
        inputFile.close();                                        // close the input file
    }

    /**
     * Method to write to a file.
     * @param maleBabyNames
     * @param femaleBabyNames
     */
    private static void writeToFile(ArrayList<String> maleBabyNames, ArrayList<String> femaleBabyNames) {

        printBabyNames("boynames.txt", maleBabyNames);
        printBabyNames("girlnames.txt", femaleBabyNames);
    }

    /**
     * Method to print baby names array list.
     * @param fileName (must not be null)
     * @param names
     */
    private static void printBabyNames(String fileName, ArrayList<String> names) {

        try {
            PrintWriter outputFile = null;
            try {
                outputFile = new PrintWriter(new File(fileName));
                names.forEach(outputFile::println);
            }finally {
                assert outputFile != null;
                outputFile.close();                               // close the output file
            }
        }catch (FileNotFoundException | InputMismatchException e) {
            System.out.println("Output file could not be created or opened");
            e.printStackTrace();
        }

    }

}