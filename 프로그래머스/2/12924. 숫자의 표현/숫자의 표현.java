import java.util.*;

class Solution {
    public int solution(int n) {
        int answer = 0;
        int sum = 0;
        
        int left = 1;
        int right = 1;
        
        while (right <= n){
            if (sum > n){
                sum -= left++;
            } else if (sum < n){
                sum += right++;
            } else{
                answer++;
                sum -= left++;
            }
            
        }
        
        return answer+1;
    }
}