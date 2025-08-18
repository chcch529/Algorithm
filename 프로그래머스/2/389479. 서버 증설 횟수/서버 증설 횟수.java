import java.util.*;

class Solution {
    public int solution(int[] players, int m, int k) {
        int answer = 0;
        
        int[] server = new int[24];
        
        for (int i=0; i<24; i++){
            if(players[i] >= m){
                int need = players[i] / m;
                
                // 필요만큼 서버 ㄴㄴ
                if(need > server[i]){
                    int on = need - server[i];
                    
                    for(int j=0; j<k; j++){
                        if (i+j <24) server[i+j] += on;
                    }
                    
                    answer += on;
                }
            }
        }
        
        return answer;
    }
}