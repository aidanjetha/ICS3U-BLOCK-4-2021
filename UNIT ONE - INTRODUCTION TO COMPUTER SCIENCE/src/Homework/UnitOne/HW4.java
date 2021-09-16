package Homework.UnitOne;

public class HW4 {
    public static void main(String[] args) {
        
        int initialVelocity;
        int finalVelocity;
        int time;
        int acceleration; 

        acceleration = 10;
        time = 20;
        initialVelocity = 50;

        finalVelocity = initialVelocity + (acceleration * time);

        System.out.println(finalVelocity);
    
    }
}
