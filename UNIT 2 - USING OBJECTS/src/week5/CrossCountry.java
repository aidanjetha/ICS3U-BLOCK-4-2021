package week5;

import java.util.Scanner;

public class CrossCountry {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        processRunner(in);
        processRunner(in);
        processRunner(in);
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
        String firstName, lastName;
        String mileOne, mileTwo, finish;
        String splitTwo, splitThree;

        System.out.print("Please enter your first name: ");
        firstName = in.next();
        System.out.print("Please enter your last name: ");
        lastName = in.next();
        System.out.print("Please enter mile one: ");
        mileOne = in.next();
        System.out.print("Please enter mile two: ");
        mileTwo = in.next();
        System.out.print("Please enter finish time: ");
        finish = in.next();

        /**
         * get the first and last name of the runner get the mileOne, mileTwo and finish
         * times for the runner
         */

        splitTwo = subtractTime(mileTwo, mileOne);
        splitThree = subtractTime(finish, mileTwo);

        /**
         * display a summary of the runner
         */

        //System.out.println("Name: " + firstName + " " + lastName);
        System.out.println(String.format("Name: %s %s", firstName, lastName));
        System.out.println("Mile one: " + mileOne);
        System.out.println("Split two: " + splitTwo);
        System.out.println("Split three: " + splitThree);
        System.out.println("Finish time: " + finish);

    }

    private static String subtractTime(String endTime, String startTime) {
        double endTimeInSeconds = convertToSeconds(endTime);
        double startTimeInSeconds = convertToSeconds(startTime);
        // System.out.println(startTimeInSeconds);

        double diffInSeconds = endTimeInSeconds - startTimeInSeconds;

        return convertToTime(diffInSeconds);
    }

    private static String convertToTime(double timeInSeconds) {
        int minutes = (int) (timeInSeconds / 60);
        double seconds = (timeInSeconds % 60);

        return String.format("%d:%06.3f", minutes, seconds); // Static because it belongs to String class
    }

    private static double convertToSeconds(String time) {

        int index = time.indexOf(":");

        String front = time.substring(0, index);
        String back = time.substring(index + 1);
        int frontSeconds = Integer.parseInt(front);
        frontSeconds *= 60;
        Double backSeconds = Double.parseDouble(back);
        return frontSeconds + backSeconds;

    }

}