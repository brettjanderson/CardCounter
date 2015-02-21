
public class Hand {
    
    private int handValue;
    private int aceCount;
    private String hand;
    private boolean blackJack;
    private boolean isSplitable;
    
    public Hand(String hand){
        
        this.hand = hand;
        aceCount = 0;
        handValue = 0;
        blackJack = false;
        isSplitable = true;
        
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
        
        if(hand.equals("AF") || hand.equals("FA")){
            blackJack = true;
        }
        
    }
    
    public void addCard(String card){
        hand.concat(card);
        if(card.charAt(0) == 'A'){
                aceCount++;
                handValue+= 11;
            } else if(card.charAt(0) == 'F'){
                handValue+= 10;
            } else {
                handValue+= Integer.parseInt(card.substring(0));
            }
        
    }
    
    
    public boolean isSplitable(){
        return ((hand.charAt(0) == hand.charAt(1)) && hand.length() < 3 && isSplitable);
    }
    
    
    public int[] getValueAndSoft(){
        
        int[] value = new int[2];
        int handValue2 = handValue;
        int aceCount2 = aceCount;
        
        if(handValue2 > 21 && aceCount2 > 0){
            while(aceCount2 > 0 || handValue2 > 21){
                handValue2-= 11;
                aceCount2--;
            }
            if(aceCount2 > 0){
                value[0] = 1;
                value[1] = handValue2;
                return value;
            }  else {
                value[0] = 0;
                value[1] = handValue2;
                return value;
            }
        } else {
           
            if(aceCount2 > 0){
                value[0] = 1;
                value[1] = handValue2;
                return value;
            }  else {
                value[0] = 0;
                value[1] = handValue2;
                return value;
        }
  
        }
    
}
    public String getHand() {
        return hand;
    }
    
    public int getValue(){
        return handValue;
    }
    
    public boolean isBJ(){
        return blackJack;
    }
    
    public void setSplitableFalse(){
        isSplitable = false;
    }
    
}