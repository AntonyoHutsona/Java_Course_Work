import java.io.*;
import java.util.*;
import java.text.DecimalFormat;
import java.nio.channels.FileChannel;


/**
 *  This program demonstrates the BankAccount and
 *  derived classes.
 *
 * Student-ID:	36225268
 * Class        CIS163AA
 * Assignment:	Chapter 10
*/

public class BankTransactions {

   static DecimalFormat currency = new DecimalFormat("$#,##0.00");

   public static void main(String[] args) throws IOException {

      // Random nums object
      Random generator = new Random();
      // Loop to create random dollars and cents values
      ArrayList<Double> data = new ArrayList<>();
      for (int idx = 0; idx < 1000; idx++) {
         data.add(((generator.nextInt(1000000) + 1) + generator.nextDouble()));
      }
      ArrayList<Double> data2 = new ArrayList<>();
      for (int idx = 0; idx < 100; idx++) {
         data2.add(((generator.nextInt(100000) + 1) + generator.nextDouble()));
      }
      // Write transactions to file
      String transFileName = "transactions.txt";
      String transFileName2 = "transactions2.txt";
      writeToFile(transFileName, data);
      writeToFile(transFileName2, data2);
      // Read transactions from file
      File fileIn = new File(transFileName);
      File fileIn2 = new File(transFileName2);
      Scanner inputFile = getScanner(fileIn);
      Scanner inputFile2 = getScanner(fileIn2);
      // Sort the input and process transactions
      ArrayList<Double> checkingTransactionsIn = new ArrayList<>();
      ArrayList<Double> checkingTransactionsOut = new ArrayList<>();
      ArrayList<Double> saveingsTransactionsIn = new ArrayList<>();
      ArrayList<Double> saveingsTransactionsOut = new ArrayList<>();
      arrangeInputData(checkingTransactionsIn, saveingsTransactionsIn, checkingTransactionsOut, saveingsTransactionsOut,
                       inputFile, inputFile2, transFileName, transFileName2);
      processCheckingAccounts(checkingTransactionsIn, checkingTransactionsOut);
      processSaveingsAccounts(saveingsTransactionsIn, saveingsTransactionsOut);
   }

   /**
    * Method to write to a file.
    * @param
    * @param
    */
   private static void writeToFile(String fileName, List<Double> data) { createTransactions(fileName, data); }

   /**
    * Method to print baby names array list.
    * @param fileName (must not be null)
    * @param data
    */
   private static void createTransactions(String fileName, List<Double> data) {

      try {
         PrintWriter outputFile = null;
         try {
            outputFile = new PrintWriter(new File(fileName));
            data.forEach(outputFile::println);
         }finally {
            assert outputFile != null;
            // close the output file
            outputFile.close();
         }
      }catch (FileNotFoundException e) {
         System.out.println("Output file could not be created or opened");
         e.printStackTrace();
      }

   }
   /**
    * Method to create a file t read from.
    * @return the input file to be read in
    */
   private static Scanner getScanner(File fileIn)  {

      /*
         Not REALLY needed. IDE requires that the file being read in must be in
         the root directory of the project. These are the objects to get the needed
         directory.
      */
      File source = new File(fileIn.getAbsoluteFile().getParent() + File.separator + fileIn);
      File dest = new File(fileIn.getAbsoluteFile().getParent());
      File finalDest = new File(dest.getAbsoluteFile().getParent() + File.separator + fileIn);

      try {
         copyFile(new File(String.valueOf(source)), new File(String.valueOf(finalDest)));
      } catch (IOException e) {
         e.printStackTrace();
      }

      File file = null;
      Scanner read = null;
      try {
         file = new File(String.valueOf(fileIn));
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

   private static void arrangeInputData(List<Double> checkingTransactionsIn
           , List<Double> saveingsTransactionsIn, List<Double> checkingTransactionsOut
           , List<Double> saveingsTransactionsOut, Scanner inputFile, Scanner inputFile2, String transFileName
           , String transFileName2) throws IOException {

            //double tt = 0;
            Scanner input = new Scanner(new File(transFileName));
            Scanner input2 = new Scanner(new File(transFileName2));
            /*
                  Fill appropriate array list.
                     At this point:
                        line1 = money put into the checking account
                        line2 = money taken out of the checking account
                  After line2 sequence starts over as long as the file still
                  contains a new line with doubles.
               */
            while (input.hasNext()) {
               // Parse inputFile
               double cIn = input.nextDouble();
               double cOut = input.nextDouble();
               checkingTransactionsIn.add(cIn);
               checkingTransactionsOut.add(cOut);
            }
            /*
                  Fill appropriate array list.
                     At this point:
                        line1 = money put into the saveings account
                        line2 = money taken out of the saveings account
                  After line2 sequence starts over as long as the file still
                  contains a new line with doubles.
               */
            //input2.useDelimiter("^\\d+(\\.\\d+)*$+");
            while (input2.hasNext()) {
               // Parse inputFile
               double sIn = input2.nextDouble();
               double sOut = input2.nextDouble();
               saveingsTransactionsIn.add(sIn);
               saveingsTransactionsOut.add(sOut);
            }
      /*for (int i = 0; i < checkingTransactionsIn.size(); i++) {
         tt += checkingTransactionsIn.get(i);
         System.out.println(checkingTransactionsIn.get(i));
      }
      System.out.println(tt);*/

   }

   private static void processCheckingAccounts(List<Double> checkingTransactionsIn
           , List<Double> checkingTransactionsOut) {

      // Test the CheckingAccount class.
      CheckingAccount myCheckingAccount = new CheckingAccount("A.Hutsona", 1000000);

      System.out.println("Account Number " + myCheckingAccount.getAccountNumber() + " belonging to " +
                         myCheckingAccount.getOwner());

      System.out.println("Initial balance = " + currency.format(myCheckingAccount.getBalance()));

      double deposit = 0.0, withdraw = 0.0, avgChkDeposits = 0.0, avgChkWdrl = 0.0;

      for (Double aCheckingTransactionsIn : checkingTransactionsIn) {
         deposit += aCheckingTransactionsIn;
      }

      for (Double aCheckingTransactionsOut : checkingTransactionsOut) {
         withdraw += aCheckingTransactionsOut;
      }

      myCheckingAccount.deposit(deposit);
      System.out.println("Total deposits " + currency.format(deposit) + ",  balance = " +
                         currency.format(myCheckingAccount.getBalance()));

      boolean success =  myCheckingAccount.withdraw(withdraw);
      if (success) { // Unsuccessful withdrawal
            System.out.println("Total of withdrawals " + currency.format(withdraw) +
                               " , balance = " + currency.format(myCheckingAccount.getBalance()));
         } else { // Unsuccessful withdrawal
            System.out.println("Insufficient funds to withdraw " +
                               currency.format(withdraw) +
                               ", balance = " + currency.format(myCheckingAccount.getBalance()));
         }
      if (checkingTransactionsIn.size() > 0) {
         avgChkDeposits = deposit / checkingTransactionsIn.size();
      }
      if (checkingTransactionsOut.size() > 0) {
         avgChkWdrl = withdraw / checkingTransactionsOut.size();
      }
      System.out.println("Average deposits: " + currency.format(avgChkDeposits));
      System.out.println("Average withdrawals: " + currency.format(avgChkWdrl));

   }

   private static void processSaveingsAccounts(List<Double> saveingsTransactionsIn
           , List<Double> saveingsTransactionsOut) {

      System.out.println();
      System.out.println();
      System.out.println();

      SavingsAccount mySaveingsAccount = new SavingsAccount("A.Hutsona", 1000000);

      System.out.println("Account Number " + mySaveingsAccount.getAccountNumber() + " belonging to " +
                         mySaveingsAccount.getOwner());

      System.out.println("Initial balance = " + currency.format(mySaveingsAccount.getBalance()));

      double deposit = 0.0, withdraw = 0.0, avgSvgDeposits = 0.0, avgSvgWdrl = 0.0;;

      for (Double aCheckingTransactionsIn : saveingsTransactionsIn) {
         deposit += aCheckingTransactionsIn;
      }

      for (Double aCheckingTransactionsOut : saveingsTransactionsOut) {
         withdraw += aCheckingTransactionsOut;
      }

      mySaveingsAccount.deposit(deposit);
      System.out.println("Total deposits " + currency.format(deposit) + ",  balance = " +
                         currency.format(mySaveingsAccount.getBalance()));

      boolean success =  mySaveingsAccount.withdraw(withdraw);
      if (success) { // Unsuccessful withdrawal
         System.out.println("Total of withdrawals " + currency.format(withdraw) +
                            " , balance = " + currency.format(mySaveingsAccount.getBalance()));
      } else { // Unsuccessful withdrawal
         System.out.println("Insufficient funds to withdraw " +
                            currency.format(withdraw) +
                            ", balance = " + currency.format(mySaveingsAccount.getBalance()));
      }
      if (saveingsTransactionsIn.size() > 0) {
         avgSvgDeposits = deposit / saveingsTransactionsIn.size();
      }
      if (saveingsTransactionsOut.size() > 0) {
         avgSvgWdrl = withdraw / saveingsTransactionsOut.size();
      }
      mySaveingsAccount.postInterest();
      System.out.println("Average deposits: " + currency.format(avgSvgDeposits));
      System.out.println("Average withdrawals: " + currency.format(avgSvgWdrl));
   }

private static void copyFile(File source, File dest) throws IOException {

   FileChannel inputChannel = null;
   FileChannel outputChannel = null;

   try {
      inputChannel = new FileInputStream(source).getChannel();
      outputChannel = new FileOutputStream(dest).getChannel();
      outputChannel.transferFrom(inputChannel, 0, inputChannel.size());
   } finally {
      if (inputChannel != null) {
         inputChannel.close();
      }
      if (outputChannel != null) {
         outputChannel.close();
      }

   }

}
}
