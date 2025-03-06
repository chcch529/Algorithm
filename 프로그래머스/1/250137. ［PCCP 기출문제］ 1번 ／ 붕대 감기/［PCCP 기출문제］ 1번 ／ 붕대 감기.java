import java.util.*;

class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int answer = 0;
        
        int end = attacks[attacks.length -1][0];
        int time = 1;
        int at = 0;
        int succes = 0;
        int currentH = health;
        while(time <= end){
            if (time == attacks[at][0]){
                currentH -= attacks[at++][1];
                succes = 0;
                
                if (currentH <= 0) return -1;
                
            } else {
                currentH += bandage[1];
                succes++;
                
                if (succes == bandage[0]){
                    currentH += bandage[2];
                    succes = 0;
                }
            }
            
            if (currentH > health ) currentH = health;
            time++;
        }
        
        return currentH;
    }
}