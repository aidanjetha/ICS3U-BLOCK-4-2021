package week7;

import java.util.Scanner;

public class crazyEight {
    private static final int NUM_SUITS = 4;
    private static final String HEARTS = "H";
    private static final String DIAMONDS = "D";
    private static final String CLUBS = "C";
    private static final String SPADES = "S";
    private static final int CARDS_PER_SUIT = 13;
    private static final String ACE = "A";
    private static final String JACK = "J";
    private static final String QUEEN = "Q";
    private static final String KING = "K";

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int playerPoints = 0, c1Points = 0, c2Points = 0;

        // int player1Cards = 0;
        String playerHand = "";
        String computer1Hand = "";
        String computer2Hand = "";

        for (int i = 0; i < 5; i++) {
            playerHand += getCard() + " ";
            computer1Hand += getCard() + " ";
            computer2Hand += getCard() + " ";

        }
        System.out.println("Player: " + playerHand);
        System.out.println("Computer 1: XX XX XX XX XX");
        System.out.println("Computer 2: XX XX XX XX XX");

        boolean Continue = continueGame(in);
        /**
         * while (Continue) { player1Cards = playerHand.length(); if (player1Cards >=
         * 14) System.out.println(firstCard()); else { Continue = false; }
         * 
         * }
         */

        if (Continue) {
            System.out.println(topCard());
        } else if (!Continue) {
            System.out.println("Thanks for playing!");
        }

        boolean playACard = playACard(in, playerHand);
        playACard(in, playerHand);
        enterACard(in, playACard, playerHand);

        // if (identifyEight()){
        // System.out.println(newFirstCard());
        // }

        while (!gameOver(playerPoints, c1Points, c2Points)) {
            String result = playRound();
            int firstDash = result.indexOf("-");
            int secondDash = result.lastIndexOf("-");
            // int secondDash = result.indexOf("-", firstDash + 1);
            playerPoints += Integer.parseInt(result.substring(0, firstDash));
            c1Points += Integer.parseInt(result.substring(firstDash + 1, secondDash));
            c2Points += Integer.parseInt(result.substring(secondDash + 1));

            System.out.println(playerPoints + " " + c1Points + " " + c2Points);
        }

    }

    
    private static String playRound() {
        String playerHand = "";
        String c1Hand = "";
        String c2Hand = "";

        String topCard = "";

        /*
         * hand-topCard
         */

        String temp = processPlayer(playerHand, topCard);
        playerHand = temp.substring(0, temp.indexOf("-"));
        topCard = temp.substring(temp.indexOf("-") + 1);

        temp = processComputer(c1Hand, topCard, playerHand, c2Hand);
        c1Hand = temp.substring(0, temp.indexOf("-"));
        topCard = temp.substring(temp.indexOf("-") + 1);

        temp = processComputer(c2Hand, topCard, playerHand, c1Hand);
        c2Hand = temp.substring(0, temp.indexOf("-"));
        topCard = temp.substring(temp.indexOf("-") + 1);

        return "17-0-8";
    }

    
   private static String processComputer(String myHand, String topCard, String oppHand1, String oppHand2) {
    return null;
 }

 private static String processPlayer(String playerHand, String topCard, boolean playACard, Scanner in) {
   return null;

 }

 private static boolean gameOver(int playerPoints, int c1Points, int c2Points) {
    return playerPoints >= 100 || c1Points >= 100 || c2Points >= 100;
 }

 


    private static boolean enterACard(Scanner in, boolean playACard, String playerHand) {
        while (playACard) {
            System.out.print("Enter your card: ");
            String answer = in.nextLine().toUpperCase();
            if (answer.length() == 1) {
                return true;
            } else {
                System.out.println("Invalid input. Please enter your card: ");
            }
        }
        return false;
    }

    
     private static boolean playACard(Scanner in, String playerHand) {
        boolean validInput = false;

        while (!validInput) {
            System.out.println("Your cards are: " + playerHand + " Do you want to play a card: ");
            String answer = in.nextLine().toUpperCase();
            if (answer.equals("CONTINUE") || answer.equals("Y") || answer.equals("YES"))
                return true;
            else if (answer.equals("STOP") || answer.equals("N") || answer.equals("NO")) {
                return false;
            } else {
                System.out.println("Invalid Input: Play or Quit only!");
            }
        }

        return false;
    }
     
    

    /**
     * private static String newFirstCard() { String newfirstCard = ""; for (int i =
     * 0; i < 1 ; i++){ newfirstCard += getCard() + " "; } String printFirst =
     * "Shuffling deck... New card on top is: " + newfirstCard; return printFirst; }
     * 
     * 
     * private static boolean identifyEight() { if
     * (firstCard().substring(0,1).equals("8")){ return true; } else { return false;
     * } }
     */

    private static String topCard() {
        String topCard = firstCard();
        return topCard;
    }

    private static String firstCard() {
        String firstCard = "";
        for (int i = 0; i < 1; i++) {
            firstCard += getCard() + " ";
        }
        String printFirst = "Card on top is: " + firstCard;
        return printFirst;

    }

    private static boolean continueGame(Scanner in) {
        boolean validInput = false;

        while (!validInput) {
            System.out.print("Do you want to [C]ontinue or [S]top: ");
            String answer = in.nextLine().toUpperCase();
            if (answer.equals("CONTINUE") || answer.equals("C") || answer.equals("YES"))
                return true;
            else if (answer.equals("STOP") || answer.equals("S") || answer.equals("NO")) {
                return false;
            } else {
                System.out.println("Invalid Input: Stop or Continue only!");
            }
        }

        return false;
    }

    private static String getCard() { // Call this 5 times.
        String card = getFace() + getSuit();

        return card;
    }

    private static String getSuit() {
        int suit = (int) (Math.random() * NUM_SUITS);

        if (suit == 0)
            return HEARTS;
        else if (suit == 1)
            return DIAMONDS;
        else if (suit == 2)
            return CLUBS;
        else
            return SPADES;

    }

    private static String getFace() {
        int suit = (int) (Math.random() * CARDS_PER_SUIT);
        if (suit >= 2 && suit <= 10)
            return suit + "";
        else if (suit == 1)
            return ACE;
        else if (suit == 11)
            return JACK;
        else if (suit == 12)
            return QUEEN;
        else
            return KING;

    }
}
