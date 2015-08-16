import java.util.Scanner;

/**
  * This program demonstrates the Time class.
  * Student-ID:	36225268
  * Class        CIS163AA
  * Assignment:	Chapter 9 Lab Task 1
*/
public class TimeDemo {

	public static void main(String[] args) {
      	Scanner keyboard = new Scanner(System.in);
      	char answer = 'Y';
      	String enteredTime;
      	String response;

		/* TODO: CHECK ANSWER AFTER CONVERTING TO CAPITAL*/
      	while (String.valueOf(answer).toUpperCase().equals("Y")) {
         	System.out.print("Enter a military time using the ##:## format: ");
            enteredTime = keyboard.nextLine();
         	new Time(enteredTime);
         	System.out.println("Do you want to enter another (Y/N)? ");
         	response = keyboard.nextLine();
         	answer = response.charAt(0);
      	}
   	}
}