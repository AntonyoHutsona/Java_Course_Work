import java.io.*;

/**
  * This program creates a list of songs for a CD
  * by reading from a file.
  *
  * @author ahutsona
  * Student-ID:	36225268
  * Class        CIS163AA
  * Assignment:	Chapter_07_Assignment CompactDisc
*/

public class CompactDisc
{
   public static void main(String[] args)throws IOException {

	   FileReader file = new FileReader("Classics.txt");
	   BufferedReader input = new BufferedReader(file);
       String title, artist;
	   final int ARRAY_LENGTH = 6;

       /* TODO: ADD LINES FOR TASK #3 HERE
        * Declare an array of Song objects, called cd,
        * with a size of 6
	    */
	   Song[] cd = new Song[ARRAY_LENGTH];
       for (int i = 0; i < cd.length; i++) {

		   // First line in file goes to title
		   title = input.readLine();
		   // Second line in file goes to artist
		   artist = input.readLine();

 	   	   /* TODO: ADD LINES FOR TASK #3 HERE
            * Fill the array by creating a new song with the title and artist and storing it in the
            * appropriate position in the array
            */
		   cd[i] = new Song(title,artist);
       }

       System.out.println("Contents of Classics:");
	   for (Song aCd : cd) {

		 	// TODO: ADD LINES FOR TASK #3 HERE
		 	System.out.print(aCd.toString());
	   }
   }

}