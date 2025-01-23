import java.util.*;

class Solution {
    static int answer;
    static int[] num;
    static int tar;
    public int solution(int[] numbers, int target) {
        
        num = numbers;
        tar = target;
        
        DFS(0, 0);
        
        return answer;
    }
    public static void DFS(int idx, int sum){
        
        if (idx == num.length){
            if (sum == tar) answer++;
            return;
        }
        
        DFS(idx +1, sum + num[idx]);
        DFS(idx +1, sum - num[idx]);
     
      
    }
}