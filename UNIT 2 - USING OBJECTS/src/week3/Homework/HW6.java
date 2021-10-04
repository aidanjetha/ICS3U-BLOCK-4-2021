package week3.Homework;

/**
 * Create a function that accepts a String and a substring 
 * and then returns a String with the second string removed from the first String. 
 */


public class HW6 {
    public static void main(String[] args) {
        

        String str = questionSix("This is a sentence. ", "ent"); //"This is a sence"
        System.out.println(str);


    }

    private static String questionSix(String str, String substr){
        int index = str.indexOf(substr);
        String first = str.substring(0, index);
        String last = str.substring(index + substr.length());

        return first + last;

    }
}
