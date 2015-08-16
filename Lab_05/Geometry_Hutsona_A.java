import java.util.Scanner;

/**
 * This program demonstrates static methods.
 * @author ahutsona
 * Student-ID:	36225268
 * Class        CIS163AA
 * Chapter 5 Assignment
 */

public class Geometry_Hutsona_A {

	/**
	 * The main method for a program that calculates various values for geometric shapes
	 * @param args Not used
	 */
	public static void main(String[] args) {

		int choice;       // The user's choice
		double value; 	  // The method's return value
		double radius;    // The radius of the circle
		double length;    // The length of the rectangle
		double width;     // The width of the rectangle
		double height;    // The height of the triangle
		double base;      // The base of the triangle
		double side1;     // The first side of the triangle
		double side2;     // The second side of the triangle
		double side3;     // The third side of the triangle
		String answer;	  // The user's Y or N decision

		// Create a scanner object to read from the keyboard
		Scanner keyboard = new Scanner(System.in);

		// The do loop allows the menu to be displayed first
		do {

			// TODO: TASK #1 Call the printMenu method
			getPrintMenu();
			// FIXME: What if I enter a String/char here for nextInt?
			choice = keyboard.nextInt();
			while (choice < 1 || choice > 6) {

				System.out.println("\nPlease enter a valid choice.");
				getPrintMenu();
				choice = keyboard.nextInt();
			}
			switch (choice) {

				case 1:
					System.out.print("Enter the radius of the circle: ");
					radius = keyboard.nextDouble();
					// TODO: TASK #3 Call the circleArea method and store the result in the value variable
					value = circleArea(radius);
					System.out.printf("The area of the circle is %.4f%n", value);
					break;
				case 2:
					System.out.print("Enter the length of the rectangle: ");
					length = keyboard.nextDouble();
					System.out.print("Enter the width of the rectangle: ");
					width = keyboard.nextDouble();
					// TODO: TASK #3 Call the rectangleArea method and store the result in the value variable
					value = rectangleArea(length, width);
					System.out.println("The area of the rectangle is " + value);
					break;
				case 3:
					System.out.print("Enter the height of the triangle: ");
					height = keyboard.nextDouble();
					System.out.print("Enter the base of the triangle: ");
					base = keyboard.nextDouble();
					// TODO: TASK #3 Call the triangleArea method and store the result in the value variable
					value = triangleArea(height, base);
					System.out.println("The area of the triangle is " + value);
					break;
				case 4:
					System.out.print("Enter the radius of the circle: ");
					radius = keyboard.nextDouble();
					// TODO: TASK #3 Call the circumference method and store the result in the value variable
					value = circleCircumference(radius);
					System.out.printf("The circumference of the circle is %.4f%n", value);
					break;
				case 5:
					System.out.print("Enter the length of the rectangle: ");
					length = keyboard.nextDouble();
					System.out.print("Enter the width of the rectangle: ");
					width = keyboard.nextDouble();
					// TODO: TASK #3 Call the perimeter method and store the result in the value variable
					value = rectanglePerimeter(length, width);
					System.out.println("The perimeter of the rectangle is " + value);
					break;
				case 6:
					System.out.print("Enter the length of side 1 of the triangle: ");
					side1 = keyboard.nextDouble();
					System.out.print("Enter the length of side 2 of the triangle: ");
					side2 = keyboard.nextDouble();
					System.out.print("Enter the length of side 3 of the triangle: ");
					side3 = keyboard.nextDouble();
					// TODO: TASK #3 Call the perimeter method and store the result in the value variable
					value = trianglePerimeter(side1, side2, side3);
					System.out.println("The perimeter of the triangle is " + value);
					break;
				default:
					System.out.println("You did not enter a valid choice.");
			}

			keyboard.nextLine(); // Consume the new line

			System.out.print("Do you want to exit the program (Y/N)?: ");
			answer = keyboard.nextLine().substring(0, 1);

		} while (!answer.equalsIgnoreCase("y"));

	}


	// TODO: TASK #1 Create the printMenu method here
	// TODO: TASK #2 Create the value-returning methods here
	// TODO: TASK #4 Write javadoc comments for each method
	/**
	 * This method prints the geometry calculator menu.
	 */
	public static void getPrintMenu() {

		System.out.print("\nThis is a geometry calculator\n");
		System.out.print("Choose what you would like to calculate\n");
		System.out.print("1.  Find the area of a circle\n");
		System.out.print("2.  Find the area of a rectangle\n");
		System.out.print("3.  Find the area of a triangle\n");
		System.out.print("4.  Find the circumference of a circle\n");
		System.out.print("5.  Find the perimeter of a rectangle\n");
		System.out.print("6.  Find the perimeter of a triangle\n");
		System.out.print("Enter the number of your choice: ");
	}

	/**
	 * This method calculates the circumference of a circle.
	 * @param radius The length of a line segment from its center to its perimeter
	 * @return The circles circumference
	 */
	public static double circleCircumference(double radius) {

		return 2 * Math.PI * radius;
	}

	/**
	 * This method calculates the area of a circle.
	 * @param radius The length of a line segment from its center to its perimeter
	 * @return The area of a circle
	 */
	public static double circleArea(double radius) {

		return Math.PI * Math.pow(radius, 2.0);
	}

	/**
	 * This method calculates the area of a rectangle.
	 * @param length Length of rectangle
	 * @param width Width of rectangle
	 * @return The area of the rectangle
	 */
	public static double rectangleArea(double length,
									   double width) {

		return length * width;
	}

	/**
	 * This method calculates the area of a triangle.
	 * @param height Height of triangle
	 * @param base base of triangle
	 * @return The area of a triangle
	 */
	public static double triangleArea(double height,
									  double base) {

		return (height * base)/2.0;
	}

	/**
	 * This method calculates the perimeter of a rectangle.
	 * @param length Length of rectangle
	 * @param width Width of rectangle
	 * @return The perimeter of a rectangle
	 */
	public static double rectanglePerimeter(double length,
											double width) {

		return (2 * length) + (2 * width);
	}

	/**
	 * This method calculates the perimeter of a triangle.
	 * @param side1 First side of triangle
	 * @param side2 Second side of triangle
	 * @param side3 Third side of triangle
	 * @return The perimeter of a triangle
	 */
	public static double trianglePerimeter(double side1,
										   double side2,
										   double side3) {

		return side1 + side2 + side3;
	}

}