package week3.Homework;

public class HW1 {
    public static void main(String[] args) {
        System.out.println(randomNumOnetoOnehundred());

    }

    public static void randomNumOnetoOnehundred(){
        int num = (int) (Math.random()*100) + 1;
        String randomNumber = num;
        return randomNumber;

    }
}
