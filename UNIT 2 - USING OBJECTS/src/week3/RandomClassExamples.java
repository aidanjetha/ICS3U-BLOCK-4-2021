package week3;


public class RandomClassExamples {
    public static void main(String[] args) {
        double r = Math.random(); // number of integers = smallest integer + biggest integer + 1
        System.out.println(r);

        int lower = -5;
        int upper = 5;
        int numPossibilities = (upper + lower + 1);

        int rand = (int) (r * numPossibilities) + lower;

        String str = "Random Numbers"; // Change a random character in str to "x"

        int index = (int)(Math.random() * str.length());
        str = str.substring(0, index) + "x" + str.substring(index + 1);
        System.out.println(str);


}
}