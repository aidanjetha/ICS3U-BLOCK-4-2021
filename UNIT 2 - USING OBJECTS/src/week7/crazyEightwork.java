package week7;

import java.util.Scanner;

public class crazyEightwork {
    public static void main(String[] args) {

        c8work();
        

    }

    private static String c8work(){
        Scanner in = new Scanner(System.in);
        String playCardRank = "8";
        String topCard = "";
        String playerHand = " 8H 9C 4S 2D QS ";
        

        if (playCardRank.equals("8")) {
            boolean validInput2 = false;
            while (!validInput2) {
                System.out.println("What suit do you want to pick (S, C, D, H): ");
                String answerSuit = in.nextLine().toUpperCase();
                if (answerSuit.equals("S") || answerSuit.equals("C") || answerSuit.equals("D")
                        || answerSuit.equals("H")) {

                    topCard = playCardRank + answerSuit;
                    System.out.println("New top card is: " + topCard);
                    validInput2 = true;
                } else {
                    System.out.println("Please enter a valid suit!");
                }
                
            } //Closes while loops inside of if statement for if card placed = 8

        }
        return playerHand + "-" + topCard;

    }

        
}