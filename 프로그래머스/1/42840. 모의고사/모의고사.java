import java.util.*;

class Solution {
    public ArrayList solution(int[] answers) {
        ArrayList<Integer> answer = new ArrayList<>();
        
        char[] supo1 = "12345".toCharArray();
        char[] supo2 = "21232425".toCharArray();
        char[] supo3 = "3311224455".toCharArray();
        
        int[] cnt = new int[3];
        
        for (int i =0; i<answers.length; i++){
            char c = (char) (answers[i] + '0');
            
            if (c == supo1[i%5]) cnt[0]++;
            if (c == supo2[i%8]) cnt[1]++;
            if (c == supo3[i%10]) cnt[2]++;
            
            
        }
        
        int max = Math.max(cnt[0], Math.max(cnt[1], cnt[2]));
        
        for (int i =0; i<3; i++){
            if (max == cnt[i]){
                answer.add(i+1);
            }
        }
        
        return answer;
    }
}