package week5;

import java.util.Scanner;

public class UsingScanner {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        exampleOne();
        in.close();
    }

    private static void exampleOne() {
        
        System.out.print("Please enter your name: ");  
        String name = in.nextLine();

        System.out.println("Hello " + name);
   
    }


}
