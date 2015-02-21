import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Random;

public class RandomDeck {

    int[] deckValues;
    LinkedList<Character> randomDeck;
    int hitWin;
    int hitPush;
    int hitBust;
    int hitLose;
    int stayWin;
    int stayLose;
    int stayPush;

    public RandomDeck(int[] deck, String dealer, String hand) {
        int[] deckValues = deck;
        hitWin = 0;
        hitPush = 0;
        hitBust = 0;
        hitLose = 0;
        stayWin = 0;
        stayLose = 0;
        stayPush = 0;

        randomDeck = new LinkedList<Character>();

        for (int i = 0; i < deckValues[0]; i++) {
            randomDeck.add('A');
        }

        for (int i = 1; i < 9; i++) {
            for (int j = 0; j < deckValues[i]; j++) {
                randomDeck.add(Integer.toString(i + 1).charAt(0));
            }
        }

        for (int i = 0; i < deckValues[9]; i++) {
            randomDeck.add('F');
        }

        MonteCarlo mc = new MonteCarlo(randomDeck, dealer, hand);

        String resultH = "";
        String resultS = "";

        for (int i = 0; i < 40000; i++) {

            resultH = mc.simulate("hit");

            if (resultH.equals("LpB")) {
                hitLose++;
                hitBust++;
            }
            if (resultH.equals("L")) {
                hitLose++;
            }
            if (resultH.equals("W")) {
                hitWin++;
            }
            if (resultH.equals("WdB")) {
                hitWin++;
            }
            if (resultH.equals("P")) {
                hitPush++;
            }
        }

        for (int i = 0; i < 40000; i++) {

            resultS = mc.simulate("stay");

            if (resultS.equals("L")) {
                stayLose++;
            }
            if (resultS.equals("W")) {
                stayWin++;
            }
            if (resultS.equals("WdB")) {
                stayWin++;
            }
            if (resultS.equals("P")) {
                stayPush++;
            }

        }


    }

    public int[] getHitWinLosePush() {

        int[] hitWinLosePush = new int[3];
        hitWinLosePush[0] = hitWin;
        hitWinLosePush[1] = hitLose;
        hitWinLosePush[2] = hitPush;

        return hitWinLosePush;

    }

    public int[] getStayWinLosePush() {

        int[] stayWinLosePush = new int[3];
        stayWinLosePush[0] = stayWin;
        stayWinLosePush[1] = stayLose;
        stayWinLosePush[2] = stayPush;

        return stayWinLosePush;
    }
}
