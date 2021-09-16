package Homework.UnitOne;

public class HW9 {
    public static void main(String[] args) {
        
        double pennyAmount = 100;
        double pennyValue = 0.01;
        double nickelAmount = 45;
        double nickelValue = 0.05;
        double dimeAmount = 20;
        double dimeValue = 0.10;
        double quarterAmount = 30;
        double quarterValue = 0.25;
        double loonieAmount = 30;
        double loonieValue = 1;
        double toonieAmount = 20;
        double toonieValue = 2;
        double totalAmountOfMoney;

        totalAmountOfMoney = (pennyAmount * pennyValue) + (nickelAmount * nickelValue) + (dimeAmount * dimeValue) + (quarterAmount * quarterValue) + (loonieAmount * loonieValue) + (toonieAmount * toonieValue);


        System.out.println("The person has " + totalAmountOfMoney + "$");

    }

}
