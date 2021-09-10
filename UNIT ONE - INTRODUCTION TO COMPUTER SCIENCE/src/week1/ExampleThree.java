package week1;


/**
 * Escape Sequences
 */

public class ExampleThree {
    public static void main(String[] args) {
        
        //double quotes encapsulate string literals 
        // -putting a quote in a string literal gets Java upset

        System.out.println("This is \"very\" important"); //backslash escapes a character


        //System.out.println("This is \very important"); // \v is not a valid escape sequence

        System.out.println("This is very \\important");
        System.out.println("This\nis\nvery\nimportant"); // \n is newLine
    }
}
