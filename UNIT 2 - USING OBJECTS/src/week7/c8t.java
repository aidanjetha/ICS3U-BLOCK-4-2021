package week7;

import java.util.Scanner;

public class c8t {
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

        /**
         * Code below prints out point of all players when game is over, and tells you who wins at the end
         */
        while (!gameOver(playerPoints, c1Points, c2Points)) {
            String result = playRound();
            int firstDash = result.indexOf("-");
            int secondDash = result.lastIndexOf("-");
            // int secondDash = result.indexOf("-", firstDash + 1);
            playerPoints += Integer.parseInt(result.substring(0, firstDash));
            c1Points += Integer.parseInt(result.substring(firstDash + 1, secondDash));
            c2Points += Integer.parseInt(result.substring(secondDash + 1));

            System.out.println("Player total points are: " + playerPoints);
            System.out.println("Computer 1 total points are: " + c1Points);
            System.out.println("Computer 2 total points are: " + c2Points);
        }

        System.out.println("Game Over!!");
        if (playerPoints <= c1Points && playerPoints <= c2Points){
            System.out.println("Player wins the game!");
        }
        if (c1Points < playerPoints && c1Points <= c2Points){
            System.out.println("Computer 1 wins the game!");
        }
        if (c2Points < c1Points && c2Points < playerPoints){
            System.out.println("Computer 2 wins the game!");
        }
        

    }

    /**
     * Method below is playRound. It is the main loop for the game, it runs the player and computer turns. It deals and prints cards and stores the values.  
     */
    private static String playRound() {

        Scanner in = new Scanner(System.in);
        String playerHand = "";
        String c1Hand = "";
        String c2Hand = "";

        String topCard = "";
        

        for (int i = 0; i < 5; i++) {
            playerHand += getCard() + " ";
            c1Hand += getCard() + " ";
            c2Hand += getCard() + " ";

        }

        

        System.out.println("Player: " + playerHand);
        System.out.println("Computer 1: XX XX XX XX XX");
        System.out.println("Computer 2: XX XX XX XX XX");

        topCard = getCard();
        System.out.println("The top card is: " + topCard);

        while (playerHand.trim().length() > 0 && c1Hand.trim().length() > 1 && c2Hand.trim().length() > 1) {
            String temp = processPlayer(playerHand, topCard, in);
            playerHand = temp.substring(0, temp.indexOf("-"));
            topCard = temp.substring(temp.indexOf("-") + 1);

            temp = processComputer(c1Hand, topCard, playerHand, c2Hand);
            c1Hand = temp.substring(0, temp.indexOf("-"));
            topCard = temp.substring(temp.indexOf("-") + 1);

            temp = processComputer(c2Hand, topCard, playerHand, c1Hand);
            c2Hand = temp.substring(0, temp.indexOf("-"));
            topCard = temp.substring(temp.indexOf("-") + 1);

        } 
        int playerScore = countScore(playerHand);
        int c1Score = countScore(c1Hand);
        int c2Score = countScore(c2Hand);

        System.out.println("Round is over!");
        System.out.println("Player got: " + playerScore + " points this round.");
        System.out.println("Computer 1 got: " + c1Score + " points this round");
        System.out.println("Computer 2 got: " + c2Score + " points this round");

        return playerScore + "-" + c1Score + "-" + c2Score;

    }


    /**
     * Method below are the rules when the computer plays. It runs and prints what the computer does depending the situation.
     */
    private static String processComputer(String myHand, String topCard, String opp1Hand, String opp2Hand) {
        int numDrawm = 0;
        while (!canPlayHand(myHand, topCard) && numDrawm <= 5) {
            myHand = drawCard(myHand);
            System.out.println("Computer drawing cards...");
            numDrawm++;

        }
        myHand = " " + myHand + " ";
        

        String topCardSuit = topCard.substring(topCard.length() - 1);
        String topCardRank = topCard.substring(0, topCard.length() - 1);

        int findSuit = myHand.indexOf(topCardSuit);
        int findRank = myHand.indexOf(topCardRank);
        if (topCardRank.equals("8")) {
            findRank = -1;
        }
        int findEight = myHand.indexOf("8");
        //System.out.println(myHand);

        if ((opp1Hand.length() < 4 || opp2Hand.length() < 4)) {
            for (int i = 0 ; i < 4 ; i++){
                String targetSuit = "";
                if (i == 0) targetSuit = "D";
                if (i == 1) targetSuit = "C";
                if (i == 2) targetSuit = "H";
                if (i == 3) targetSuit = "S";

                if (opp1Hand.length() < 4 && opp1Hand.indexOf(targetSuit) > -1){
                    continue; 
                }
                
                if (opp2Hand.length() < 4 && opp2Hand.indexOf(targetSuit) > -1){
                    continue; 
                }
                String targetCard = topCardRank + targetSuit;
                int targtIndex = myHand.indexOf(targetCard);
                if (targtIndex > -1){
                    myHand = playCard(myHand, targetCard);
                    topCard = targetCard;
                    System.out.println("Computer played! New top card is: " + topCard);
                    return myHand + "-" + topCard;
                }

                if (findEight > -1){
                    String eightCard = myHand.substring(findEight, findEight + 3).trim();
                    myHand = playCard(myHand, eightCard);
                    topCard = "8" + targetSuit;
                    System.out.println("Computer played an eight! Top card is: " + eightCard);
                    System.out.println("Computer changed the suit! New top card is: " + topCard);
                    return myHand + "-" + topCard;
                }
            }

        } 

        if (findSuit > -1) {

            String findCardSuit = "";

            findCardSuit = myHand.substring(findSuit - 2, findSuit + 1).trim();
            String check8 = findCardSuit.substring(0, 1);
            String temp = myHand.substring(findSuit + 1, myHand.length());
            while (check8.equals("8") && temp.length() > 1) {
                int tempSuitIndex = temp.indexOf(topCardSuit);
                if (tempSuitIndex > -1) {
                    findCardSuit = temp.substring(tempSuitIndex - 2, tempSuitIndex + 1).trim();
                    check8 = findCardSuit.substring(0, 1);
                } else {
                    temp = temp.substring(tempSuitIndex, temp.length());
                }
            }
            if (!check8.equals("8")) {
                myHand = playCard(myHand, findCardSuit);
                topCard = findCardSuit;
                System.out.println("Computer played! New top card is: " + topCard);
                return myHand + "-" + topCard;
            }

        }

        if (findRank > -1) {
            String findCardRank = "";

            findCardRank = myHand.substring(findRank, findRank + 3).trim();
            myHand = playCard(myHand, findCardRank);
            topCard = findCardRank;
            System.out.println("Computer played! New top card is: " + topCard);
            return myHand + "-" + topCard;
        }

        if (findEight > -1) {
            String findCardEight = "";

            findCardEight = myHand.substring(findEight, findEight + 3).trim();
            myHand = playCard(myHand, findCardEight);

            System.out.println("Computer played an 8: " + findCardEight);

            if (myHand.length() < 2) {
                topCard = findCardEight;
            } else {
                int chooseSuitIndex = myHand.substring(1, myHand.length()).indexOf(" ");
                String newSuit = myHand.substring(chooseSuitIndex, chooseSuitIndex + 1);
                topCard = "8" + newSuit;

            }

            System.out.println("Suit changed! New card is: " + topCard);
            return myHand + "-" + topCard;
        }

        

        return myHand + "-" + topCard;
    }

    

    /**
     * The process player method below allows the player to input cards to play and prints them. It also checks to make sure the cards entered are allowed.
     */
    private static String processPlayer(String playerHand, String topCard, Scanner in) {

        

        int numDrawm = 0;
        while (!canPlayHand(playerHand, topCard) && numDrawm <= 5) {
            playerHand = drawCard(playerHand);
            System.out.println("Drawing cards...  Your new cards are: " + playerHand);
            numDrawm++;

        }

        while (canPlayHand(playerHand, topCard)) {
            boolean validInput = false;

            if (!validInput) {
                System.out.println("The top card is: " + topCard);
                System.out.println("Your cards are: " + playerHand + " what card do you want to play?: ");
                String answer = in.nextLine().toUpperCase();
                if (answer.length() < 2){
                    System.out.println("Invalid Input!");
                    continue;
                }
                String playCardSuit = answer.substring(answer.length() - 1);
                String playCardRank = answer.substring(0, answer.length() - 1);

                String topCardSuit = topCard.substring(topCard.length() - 1);
                String topCardRank = topCard.substring(0, topCard.length() - 1);

                if (playerHand.indexOf(answer) > -1 && (playCardSuit.equals(topCardSuit) || playCardRank.equals(topCardRank) || playCardRank.equals("8"))) {
                    playerHand = playCard(playerHand, answer);
                    topCard = answer;
                    System.out.println("New top card is: " + topCard);
                    System.out.println("Card placed!");

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
    
                    } //Closes if statemnt if card placed = 8


                    return playerHand + "-" + topCard;

                } 
                
              

                 else {
                    System.out.println("Invalid input. Please enter valid card!");

                }

               

            } //Close if statment inside while loop

        } //Close while loop for canPlayHand = true
        return playerHand + "-" + topCard;
    } //Close process player


    private static String playCard(String playerHand, String cardToPlay) {
        int index = playerHand.indexOf(cardToPlay); //Stores the index of where the card that is being played from the player hand
        String firstHalf = playerHand.substring(0, index); //First half of the string, goes from the beggining to the stored index
        String secondHalf = playerHand.substring(index + cardToPlay.length(), playerHand.length()); //Takes the remaining half of the card
        return firstHalf.trim() + " " + secondHalf.trim(); //Returns both halfs 
    }

    private static String drawCard(String playerHand) {
        
        playerHand = playerHand.trim() + " " + getCard();
        return playerHand;
    }

    
    /**
     * This method checks if the player is allowed to play a card, then returns true.
     */
    private static boolean canPlayHand(String playerHand, String topCard) {
        boolean canPlay = false;
        String topCardSuit = topCard.substring(1, 2);
        String topCardRank = topCard.substring(0, 1);

        if (playerHand.indexOf("8") > -1) {
            canPlay = true;
        }

        if (playerHand.indexOf(topCardSuit) > -1) {
            canPlay = true;
        }

        if (playerHand.indexOf(topCardRank) > -1) {
            canPlay = true;
        }

        return canPlay;
    }

    /**
     * This method assigns a value to each card to count the score at the end, then returns the score
     */
    private static int countScore (String myHand){
        myHand = myHand.trim() + " ";
        int score = 0;
        while (myHand.length() > 1){
            int index = myHand.indexOf(" ");
            String card = myHand.substring(0, index);
            myHand = myHand.substring(index + 1, myHand.length());
            String cardRank = card.substring(0, card.length()-1);
            
            if (cardRank.equals("A")){
                score += 1;
            } else if (cardRank.equals("2")){
                score += 2;
            } else if (cardRank.equals("3")){
                score += 3;
            } else if (cardRank.equals("4")){
                score += 4;
            } else if (cardRank.equals("5")){
                score += 5;
            } else if (cardRank.equals("6")){
                score += 6;
            } else if (cardRank.equals("7")){
                score += 7;
            } else if (cardRank.equals("8")){
                score += 50;
            } else if (cardRank.equals("10")){
                score += 10;
            } else if (cardRank.equals("J")){
                score += 10;
            } else if (cardRank.equals("Q")){
                score += 10;
            } else if (cardRank.equals("K")){
                score += 10;
            } else if (cardRank.equals("9")){
                score += 9;
            } 
        } 
        return score;
    }

    /**
     * This method returns true if any player gets 100 or more points 
     */
    private static boolean gameOver(int playerPoints, int c1Points, int c2Points) {
        return playerPoints >= 100 || c1Points >= 100 || c2Points >= 100;
    }

   
    /**
     * This method makes a card by getting a random face and suit then puts them together
     */
    private static String getCard() { // Call this 5 times.
        String card = getFace() + getSuit();

        return card;
    }

    /**
     * This method picks a random suit the returns it
     */
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

    /**
     * This method picks a random face and then returns it
     */
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
