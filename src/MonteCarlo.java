import java.util.Collections;
import java.util.LinkedList;
import java.util.Random;
import java.util.Stack;

public class MonteCarlo {

    private LinkedList<Character> deck;
    private char dealerCard;
    private char[] playerHand;
    private int playerCount, dealerCount;
    private Stack<Character> dealtCards;
    private Random rand;

    public MonteCarlo(LinkedList<Character> deckIn, String dealer, String player) {

        deck = new LinkedList<Character>();
        deck = deckIn;

        dealtCards = new Stack<Character>();
        dealerCard = dealer.charAt(0);

        playerHand = new char[player.length()];

        for (int i = 0; i < player.length(); i++) {
            playerHand[i] = player.charAt(i);
        }
        rand = new Random(System.nanoTime());

    }

    public String simulate(String action) {

        if (action.equals("hit")) {

            while (!dealtCards.isEmpty()) {
                deck.addFirst(dealtCards.pop());
            }

            Collections.shuffle(deck, rand);

            int aceCount = 0;
            playerCount = 0;

            for (int i = 0; i < playerHand.length; i++) {
                if (playerHand[i] == 'A') {
                    playerCount += 11;
                    aceCount++;
                } else if (playerHand[i] == 'F') {
                    playerCount += 10;
                } else {
                    playerCount += Character.getNumericValue(playerHand[i]);
                }
            }

            if (deck.getFirst() == 'A') {
                playerCount += 11;
                aceCount++;
                dealtCards.push(deck.removeFirst());
            } else if (deck.getFirst() == 'F') {
                playerCount += 10;
                dealtCards.push(deck.removeFirst());
            } else {
                playerCount += Character.getNumericValue(deck.getFirst());
                dealtCards.push(deck.removeFirst());
            }

            while (playerCount > 21 && aceCount > 0) {
                playerCount -= 10;
                aceCount--;
            }

            if (playerCount > 21) {
                return "LpB";
            }

            int aceCountDealer = 0;
            dealerCount = 0;
            int dealerCardCount = 0;

            if (dealerCard == 'A') { //establish dealer values
                dealerCount = 11;
                aceCountDealer++;
                dealerCardCount++;
            } else if (dealerCard == 'F') {
                dealerCount = 10;
                dealerCardCount++;
            } else {
                dealerCount = Character.getNumericValue(dealerCard);
                dealerCardCount++;
            }

            boolean dealerDone = false;

            while (dealerDone == false) {
                if (deck.getFirst() == 'A') {
                    dealerCount += 11;
                    aceCountDealer++;
                    dealtCards.push(deck.removeFirst());
                    dealerCardCount++;
                } else if (deck.getFirst() == 'F') {
                    dealerCount += 10;
                    dealtCards.push(deck.removeFirst());
                    dealerCardCount++;
                } else {
                    dealerCount += Character.getNumericValue(deck.getFirst());
                    dealtCards.push(deck.removeFirst());
                    dealerCardCount++;
                }

                while (dealerCount > 21 && aceCountDealer > 0) {
                    dealerCount -= 10;
                    aceCountDealer--;
                }

                if (dealerCount > 16 && dealerCount < 22) {
                    dealerDone = true;
                }

                if (dealerCount > 21) {
                    return "WdB";
                }
            }

            if (dealerCount > playerCount || (dealerCount == 21 && playerCount == 21 && dealerCardCount == 2)) {
                return "L";
            }

            if (dealerCount == playerCount) {
                return "P";
            }

            if (dealerCount > playerCount) {
                return "L";
            }

            if (playerCount > dealerCount) {
                return "W";
            }
        }

        if (action.equals("stay")) {

            while (!dealtCards.isEmpty()) {
                deck.addFirst(dealtCards.pop());
            }

            Collections.shuffle(deck, new Random(System.nanoTime()));

            int aceCount = 0;
            playerCount = 0;

            for (int i = 0; i < playerHand.length; i++) {
                if (playerHand[i] == 'A') {
                    playerCount += 11;
                    aceCount++;
                } else if (playerHand[i] == 'F') {
                    playerCount += 10;
                } else {
                    playerCount += Character.getNumericValue(playerHand[i]);
                }
            }

            while (playerCount > 21 && aceCount > 0) {
                playerCount -= 10;
                aceCount--;
            }

            int aceCountDealer = 0;
            dealerCount = 0;
            int dealerCardCount = 0;

            if (dealerCard == 'A') { //establish dealer values
                dealerCount = 11;
                aceCountDealer++;
                dealerCardCount++;
            } else if (dealerCard == 'F') {
                dealerCount = 10;
                dealerCardCount++;
            } else {
                dealerCount = Character.getNumericValue(dealerCard);
                dealerCardCount++;
            }

            boolean dealerDone = false;

            while (dealerDone == false) {
                if (deck.getFirst() == 'A') {
                    dealerCount += 11;
                    aceCountDealer++;
                    dealtCards.push(deck.removeFirst());
                    dealerCardCount++;
                } else if (deck.getFirst() == 'F') {
                    dealerCount += 10;
                    dealtCards.push(deck.removeFirst());
                    dealerCardCount++;
                } else {
                    dealerCount += Character.getNumericValue(deck.getFirst());
                    dealtCards.push(deck.removeFirst());
                    dealerCardCount++;
                }

                while (dealerCount > 21 && aceCountDealer > 0) {
                    dealerCount -= 10;
                    aceCountDealer--;
                }

                if (dealerCount > 16 && dealerCount < 22) {
                    dealerDone = true;
                }

                if (dealerCount > 21) {
                    return "WdB";
                }
            }

            if (dealerCount > playerCount || (dealerCount == 21 && playerCount == 21 && dealerCardCount == 2)) {
                return "L";
            }

            if (dealerCount == playerCount) {
                return "P";
            }

            if (dealerCount > playerCount) {
                return "L";
            }

            if (playerCount > dealerCount) {
                return "W";
            }

        }
        return null;
    }
}
