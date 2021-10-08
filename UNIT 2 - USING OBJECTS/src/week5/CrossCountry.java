package week5;

import java.util.Scanner;

public class CrossCountry {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        processRunner(in);//Runs the scanner the first time and take in a runner
        processRunner(in);//Runs the scanner a second time and take in a runner
        processRunner(in);//Runs the scanner a third time and take in a runner
        in.close();
        

    }

    /**private static Double verifyInput(Scanner in) {

        double num = 0;

        boolean validInput = false;

        while (!validInput) {
            try {
                num = Double.parseDouble(in.nextLine());
                validInput = true;
            } catch (Exception ex) {
                System.out.print("Invalid input!!! Please enter a number: ");
            }

            return num;
        }
    }
    */

    private static void processRunner(Scanner in) {
        String firstName, lastName; //Sets firstName and lastName as a string
        String mileOne, mileTwo, finish;//Sets mileOne, mileTwo and finish as a string
        String splitTwo, splitThree;// Sets splitTwo and splitThree as a string

        System.out.print("Please enter your first name: ");
        firstName = in.next(); //Creates input to enter first name
        System.out.print("Please enter your last name: ");
        lastName = in.next(); //Creates input to enter last name
        System.out.print("Please enter mile one: ");
        mileOne = in.next(); //Creates input to enter mile one time
        System.out.print("Please enter mile two: ");
        mileTwo = in.next(); //Creates input to enter mile two time
        System.out.print("Please enter finish time: ");
        finish = in.next(); //Creates input to enter finish time

        /**
         * get the first and last name of the runner get the mileOne, mileTwo and finish
         * times for the runner
         */

        splitTwo = subtractTime(mileTwo, mileOne); //Gets the mileTwo and mileOne times and runs them through the method subtractTime 
        splitThree = subtractTime(finish, mileTwo); //Gets the finish and mileTwo times and runs them through the method subtractTime

        /**
         * display a summary of the runner
         */

        //System.out.println("Name: " + firstName + " " + lastName);
        System.out.println(String.format("Name: %s %s", firstName, lastName)); //Prints first name and last name
        System.out.println("Mile one: " + mileOne); //Prints mile one time
        System.out.println("Split two: " + splitTwo);//Prints split two time
        System.out.println("Split three: " + splitThree); //prints split three time
        System.out.println("Finish time: " + finish); //prints finish time

    }

    private static String subtractTime(String endTime, String startTime) { 
        double endTimeInSeconds = convertToSeconds(endTime); //This will run through the convertToSeconds method and convert and format the endTime to seconds 
        double startTimeInSeconds = convertToSeconds(startTime); //This will run through the convertToSeconds method and convert and format the startTime to seconds
        // System.out.println(startTimeInSeconds);

        double diffInSeconds = endTimeInSeconds - startTimeInSeconds;//makes a double that takes the endTime and starTime both in seconds and subtracts them

        return convertToTime(diffInSeconds); //Returns the difference but runs it through convertToTime so that it displays the minutes and seconds and formats it
    }

    private static String convertToTime(double timeInSeconds) { //function that converts time, to minutes and seconds
        int minutes = (int) (timeInSeconds / 60); //This makes timeInSeconds into minutes and returns it as a integer 
        double seconds = (timeInSeconds % 60); //This makes timeInSeconds and returns it into the seconds as a double 

        return String.format("%d:%06.3f", minutes, seconds); //returns the minutes and seconds and formats them
    }
    
    private static double convertToSeconds(String time) { //this function will convert and format minutes to seconds

        int index = time.indexOf(":"); //Creates a variable called index

        String front = time.substring(0, index);//String front starts at index 0 and ends at ":"
        String back = time.substring(index + 1);//String back starts at ":" and goes to the end
        int frontSeconds = Integer.parseInt(front);//Takes string "front" and makes it a integer
        frontSeconds *= 60;//Converting front minutes into seconds
        Double backSeconds = Double.parseDouble(back); //Takes string "back" and makes it a double
        return frontSeconds + backSeconds; //returns frontSeconds plus backSeconds

    }

}