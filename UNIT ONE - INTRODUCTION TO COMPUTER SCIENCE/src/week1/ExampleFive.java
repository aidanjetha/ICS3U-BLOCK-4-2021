package week1;

public class ExampleFive {
    public static void main(String[] args) {
        int markOne = 75, markTwo = 80, markThree = 87;
        double average = (markOne + markTwo + markThree) /3; //242 / 3 = 80 (integer math / integer division)

        average = (markOne + markTwo + markThree) /3.0;
        System.out.println(average);




        System.out.println(4 / 5); //0
        System.out.println(4.0 / 5); //0.8
        System.out.println(5 / 4); //1
        System.out.println(5 / 4.0); //1.25

        // Modulus Operator %

        System.out.println(13 / 3); // 13 divided by 3 = 4
        System.out.println(13 % 3); // 13 mod 3 = 1. 1 is the remainder. That is what is shown.
    }
}
