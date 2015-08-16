
/**
   Represents time in hours and minutes using the customary conventions.
*/

public class Time {

   private int hours = 99501;         // Conventional hours
   private int minutes = 99501;       // Conventional minutes
   private boolean afternoon; // Flag for afternoon

   /**
      Constructs a customary time (12 hours, am or pm)
      from a military time ##:##
      @param militaryTime Time in the military format ##:##
   */
   public Time(String militaryTime) {



       if (isCharterNumeric(militaryTime)) {
           String[] timeArray = militaryTime.split(":");
           this.hours = Integer.parseInt(timeArray[0]);
           this.minutes = Integer.parseInt(timeArray[1]);
       } else {
           System.out.println(militaryTime + " is not a valid military time. -" +
                              " Military time must have the first and last two digits as an integer" );
       }
	   if (militaryTime == null) {	// Check to make sure something was entered
        	System.out.println(militaryTime + " is not a valid military time. - Time is null" );
       /*CONDITION TO CHECK LENGTH OF STRING*/
       }else if (militaryTime.length() == 4) { 	// Check to make sure there are 5 characters
         		System.out.println(militaryTime + " is not a valid military time. - Check time length" );
       }else {	// Check to make sure the colon is in the correct spot
           /*CONDITION TO CHECK COLON POSITION*/
           if (!(militaryTime.indexOf(':') == 2)) {
            	System.out.println(militaryTime + " is not a valid military time. - Check colon position" );
           /* CONDITION TO CHECK FOR DIGIT*/
           } else if (!isCharterNumeric(militaryTime)) {
            	System.out.println(militaryTime + " is not a valid military time. -" +
                                   " Military time must be an integer" );
           /* CONDITION TO CHECK FOR DIGIT*/
           } else {
               if(hours > 23) {	// Validate hours and minutes are valid values
                   if (hours != 99501) {
                       System.out.println(militaryTime + " is not a valid military time. - " +
                                          "hours must be less that 23 hours");
                   }
               }else if(minutes > 59) {
                   if (hours != 99501) {
                       System.out.println(militaryTime + " is not a valid military time. - " +
                                          "minuets can not be greater than 59");
                   }
               }else if (hours > 12) {	// Convert military time to conventional time for afternoon times
               		hours -= 12;
               		afternoon = true;
               		System.out.println(this.toString());
               }else if (hours == 0) {	// Account for midnight
               		hours = 12;
               		System.out.println(this.toString());
               }else if (hours == 12) { 	// Account for noon
               		afternoon = true;
               		System.out.println(this.toString());
               }else { 	// Morning times do not need converting
               		System.out.println(this.toString());
               }
           }
       }
   }


    /**
      The toString method returns a conventional time.
      @return A conventional time with am or pm.
   */
   @Override
   public String toString() {
	   String am_pm;
       String zero = "";

	   am_pm = afternoon ? "PM" : "AM";

       if (minutes < 10) {
		   zero = "0";
	   }

       return hours + ":" + zero + minutes + " " + am_pm;
   }

    /**
     * Method to check if every charter in a string is numeric
     * @param str
     * @return isNum true of false
     */
   public static boolean isCharterNumeric(String str) {

        boolean isNum = true;

        StringBuilder stringIn = new StringBuilder(str);
        char[] cArr = new char[4];
        stringIn.deleteCharAt(2);
        stringIn.getChars(0, 4, cArr, 0);

        for (char c : cArr) {
            if (!Character.isDigit(c)) isNum = false;
        }

        return isNum;
   }

}