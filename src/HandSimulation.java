import java.util.Collections;
import java.util.LinkedList;
import java.util.Random;
import java.util.Stack;


public class HandSimulation {
    
    private String[][][] firstTwo;
    private boolean soft;
    private int aceCount;
    private int[] simDeck;
    private double bankroll = 1000.0;
    private final double DEFAULT_BET = 10.0;
    private double bet;
    private final int NUM_SIMS = 100000;
    private Guide guide;
    private double deckCut;
    private LinkedList<String> randomDeck;
    private Stack<String> burntCards;
    private Random rand;
    
    
    public HandSimulation(int[] deck){
        
        simDeck = deck;
        deckCut = (1/6)*deck.length;
        bankroll = 1000.0;
        bet = 10.0;
        rand = new Random(System.nanoTime());
        randomDeck = new LinkedList<String>();
        burntCards = new Stack<String>();
        guide = new Guide();
        
        Collections.shuffle(randomDeck, rand);

        for (int i = 0; i < simDeck[0]; i++) {
            randomDeck.add("A");
        }

        for (int i = 1; i < 9; i++) {
            for (int j = 0; j < simDeck[i]; j++) {
                randomDeck.add(Integer.toString(i + 1));
            }
        }

        for (int i = 0; i < simDeck[9]; i++) {
            randomDeck.add("F");
        }
        
        
        
        for(int i = 0; i < 100000; i++){
            
            String result = "";
            boolean isDone = false;
            boolean blackJack = false;
            
            if(randomDeck.size() < (int) deckCut){ //check to see if we need to reshuffle
                while(!burntCards.isEmpty()){
                    randomDeck.addLast(burntCards.pop());
                }
                Collections.shuffle(randomDeck, rand);
            }
            
            String player = randomDeck.getFirst(); //deal first cards
            burntCards.push(randomDeck.removeFirst()); 
            String dealer = randomDeck.getFirst();
            burntCards.push(randomDeck.removeFirst());
            player.concat(randomDeck.getFirst());
            burntCards.push(randomDeck.removeFirst());
            

            
            Hand playerHand = new Hand(player);
            Hand dealerHand = new Hand(dealer);
            
            
            
            while(!isDone){
                
                String d = guide.getDecision(dealerHand, playerHand);
                
                if(d.equals("Split")){
                    Hand playerHand1 = new Hand(playerHand.getHand().substring(0));
                    Hand playerHand2 = new Hand(playerHand.getHand().substring(1));
                    
                    
                    
                }
                
                
                if(d.equals("H")){
                    
                    playerHand.addCard(randomDeck.getFirst());
                    burntCards.push(randomDeck.removeFirst());
                    int[] newValue = playerHand.getValueAndSoft();
                    if(newValue[0] == 0 && newValue[1] > 21){
                        result = "L";
                        isDone = true;
                    }
                    continue;
                }
                
                if(d.equals("D")){
                    
                    playerHand.addCard(randomDeck.getFirst());
                    burntCards.push(randomDeck.removeFirst());
                    int[] newValue = playerHand.getValueAndSoft();
                    
                    if(newValue[0] == 0 && newValue[1] > 21){
                        result = "L";
                    }
                    isDone = true;
                    
                }
                
                if(d.equals("Stay")){
                    isDone = true;
                }
                
                
            }
            
            
        }
        
        
    }
   
    private String dealHand(double bet){
        
        
        
        
        
        return "";
    }
   
    private int getValue(String hand){
        int aceCount = 0;
        int handValue = 0;
        for(int i = 0; i < hand.length(); i++){
            if(hand.charAt(i) == 'A'){
                aceCount++;
                handValue+= 11;
            } else if(hand.charAt(i) == 'F'){
                handValue+= 10;
            } else {
                handValue+= Integer.parseInt(hand.substring(i));
            }
        }
        
        if(handValue > 21 && aceCount > 0){
            while(aceCount > 0 || handValue > 21){
                handValue-= 11;
                aceCount--;
            }
        }
        return 0;
    }
    
    private Hand[] playerPlay(Hand dealer, Hand player){
        boolean isDone = false;
        Hand[] hands = new Hand[1];
        
        if(player.isBJ()){
                isDone = true;
        }
        
        while(!isDone){
            
            String d = guide.getDecision(dealer, player);
                
                if(d.equals("Split")){
                    Hand playerHand1 = new Hand(player.getHand().substring(0));
                    Hand playerHand2 = new Hand(player.getHand().substring(1));
                    hands = new Hand[2];
                    //hands[0] = playSplitHand(dealer, playerHand1);
                    //hands[1] = playSplitHand(dealer, playerHand2);
                    isDone = true;
                }
                
                
                if(d.equals("H")){
                    
                    player.addCard(randomDeck.getFirst());
                    burntCards.push(randomDeck.removeFirst());
                    int[] newValue = player.getValueAndSoft();
                    if(newValue[0] == 0 && newValue[1] > 21){
                        isDone = true;
                        hands[0] = player;
                    }
                    continue;
                }
                
                if(d.equals("D")){
                    
                    player.addCard(randomDeck.getFirst());
                    burntCards.push(randomDeck.removeFirst());
                    int[] newValue = player.getValueAndSoft();
                    bet *= 2;
                    isDone = true;
                    
                }
                
                if(d.equals("Stay")){
                    isDone = true;
                }
            
            
        }
        
        
        
        return hands;
    }
    
    
}
