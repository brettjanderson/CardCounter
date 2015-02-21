public class Guide {
    
    private String[][][] guide;
    private String[][][] guideValue;
    
    public Guide(){
        
        guide = new String[12][12][12];
        guide = buildSplitGuide();
        guideValue = new String[12][22][12];
        guideValue = buildValueGuide();
    }
    
    public String getDecision(Hand dealer, Hand player){
        if(player.isSplitable()){
            return guide[player.getValue()/2][player.getValue()/2][dealer.getValue()];
        } else { 
            
            int[] d = player.getValueAndSoft();
            
            
            
        }
        
        return "";
    }
    
    private String[][][] buildSplitGuide(){
        
        for(int i = 2; i < 12; i++){    
            guide[11][11][i] = "Split";
        }
        
        for(int i = 2; i < 12; i++){    
            guide[10][10][i] = "Stay";
        }
        
        for(int i = 2; i < 7; i++){    
            guide[9][9][i] = "Split";
        }
            guide[9][9][7] = "Stay";
            guide[9][9][8] = "Split";
            guide[9][9][9] = "Split";
            guide[9][9][10] = "Stay";
            guide[9][9][11] = "Stay";
            
        for(int i =2; i<12; i++){
            guide[8][8][i] = "Split";
        }
        
        for(int i =2; i<8; i++){
            guide[7][7][i] = "Split";
        }
        
        for(int i =8; i<12; i++){
            guide[7][7][i] = "H";
        }
            guide[6][6][2] = "H";
        for(int i =3; i<7; i++){
            guide[6][6][i] = "Split";
        }
        for(int i =7; i<12; i++){
            guide[6][6][i] = "H";
        }
        for(int i =2; i<10; i++){
            guide[5][5][i] = "D";
        }
        for(int i =10; i<12; i++){
            guide[5][5][i] = "H";
        }
        for(int i =2; i<12; i++){
            guide[4][4][i] = "H";
        }
        
            guide[3][3][2] = "H";
            guide[3][3][3] = "H";
        for(int i =4; i<8; i++){
            guide[3][3][i] = "Split";
        }
        
        for(int i =8; i<12; i++){
            guide[3][3][i] = "H";
        }
        
            guide[2][2][2] = "H";
            guide[2][2][3] = "H";
        for(int i =4; i<8; i++){
            guide[2][2][i] = "Split";
        }
        for(int i =8; i<12; i++){
            guide[2][2][i] = "H";
        }
        return guide;
    }
    
    private String[][][] buildValueGuide(){
        
        for(int i = 0; i < 12; i++){
            guideValue[1][21][i] = "Stay";
            guideValue[1][20][i] = "Stay";
            guideValue[1][19][i] = "Stay";
            guideValue[0][21][i] = "Stay";
            guideValue[0][20][i] = "Stay";
            guideValue[0][19][i] = "Stay";
            guideValue[0][18][i] = "Stay";
            guideValue[0][17][i] = "Stay";
            guideValue[0][11][i] = "D";
            guideValue[0][10][i] = "D";
           }
            guideValue[0][11][10] = "H";
            guideValue[0][10][10] = "H";
            guideValue[0][10][11] = "H";
            
        for(int i = 2; i < 7; i++){
            guideValue[0][16][i] = "Stay";
            guideValue[0][15][i] = "Stay";
            guideValue[0][14][i] = "Stay";
            guideValue[0][13][i] = "Stay";
            guideValue[0][12][i] = "Stay";
        }
            guideValue[0][12][2] = "H";
            guideValue[0][12][3] = "H";
            
        for(int i = 7; i < 12; i++){
            guideValue[0][14][i] = "H";
            guideValue[0][13][i] = "H";
            guideValue[0][12][i] = "H";
        }
            guideValue[0][16][7] = "H";
            guideValue[0][16][8] = "H";
            guideValue[0][16][9] = "Surr";
            guideValue[0][16][10] = "Surr";
            guideValue[0][16][11] = "H";
            guideValue[0][15][7] = "H";
            guideValue[0][15][8] = "H";
            guideValue[0][15][9] = "H";
            guideValue[0][15][10] = "Surr";
            guideValue[0][15][11] = "H";
            
            guideValue[0][9][2] = "H";
            guideValue[0][9][3] = "D";
            guideValue[0][9][4] = "D";
            guideValue[0][9][5] = "D";
            guideValue[0][9][6] = "D";
            guideValue[0][9][7] = "H";
            guideValue[0][9][8] = "H";
            guideValue[0][9][9] = "H";
            guideValue[0][9][10] = "H";
            guideValue[0][9][11] = "H";
            
        for(int i = 2; i < 12; i++){
            guideValue[0][5][i] = "H";
            guideValue[0][6][i] = "H";
            guideValue[0][7][i] = "H";
            guideValue[0][8][i] = "H";
        }
            
        
        return guideValue;
    }
    
}
