package Homework.UnitOne;

/**
 *   y = ax^2 + bx + c. a,b,c are given. Find y and x
 */


public class HW10 {
    public static void main(String[] args) {
        
        double a = 12;
        double b = 25;
        double bNegative = -8;
        double c = 9;
        double y;
        double x1;
        double x2;
        
        
        double squareRootPart = (b * b) - (4 * (a * c));
        double square = Math.sqrt(squareRootPart);
        
        x1 = bNegative + square / (2*a);
        x2 = bNegative - square / (2*a); 
        
        System.out.println("X root one is: " + x1);
        System.out.println("X root two is: " + x2);
       
        // Above shows program to get X points. Below they are plugged in to get y value


        y = (a * (x1 * x1)) + (b * x1) + c;
        System.out.println("Point y is: " + y);


    }
}
