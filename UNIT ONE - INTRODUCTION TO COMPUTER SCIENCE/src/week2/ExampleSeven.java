package week2;

/**
 * final and modifier - constant. Makes it so you cant change the variable 
 */

public class ExampleSeven {
    public static void main(String[] args) {
        
        final int x = 7;
        
        //x = 7; Cannot reassign a value to a final variable

        final int y;
        y = 8;
        //y++; Cannot modify the variable once it is set if it is constant 

        final int NUM_STUDENTS = 18; //naming convention for constants (final variables) 
                                    //is UPPER_CASE with _ for spaces

    }
}
