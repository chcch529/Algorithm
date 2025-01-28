import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        
        for (int i=0; i< prices.length -1; i++){
            int now = prices[i];
            for (int j=i+1; j< prices.length; j++){
                if (now <= prices[j]){
                    answer[i] += 1;
                } else{
                    answer[i] += 1;
                    break;
                }
            }
        }
        return answer;
    }
}