import java.util.*;

class Solution {
    public String solution(String X, String Y) {
        String answer = "";
        
        int[] x = new int[10];
        int[] y = new int[10];
        
        for (char c: X.toCharArray()){
            x[c - '0'] += 1;
        }
        for (char c: Y.toCharArray()){
            y[c - '0'] += 1;
        }
        
        StringBuilder sb = new StringBuilder();
        
        int cnt;
        for (int i=9; i>=0; i--){
            cnt = Math.min(x[i], y[i]);
            
            for (int j= 0; j<cnt; j++){
                sb.append(i);
            }
        }
        
        if (sb.length() == 0){
            answer = "-1";
        } else if (sb.charAt(0) == '0'){
            answer = "0";
        } else{
            answer = sb.toString();
        }
        
        return answer;
    }
}