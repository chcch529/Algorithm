import java.util.*;

class Solution {
    static int[] diffs;
    static int[] times;
    static long limit;
    
    public int solution(int[] diffs, int[] times, long limit) {

        Solution.diffs = diffs;
        Solution.times = times;
        Solution.limit = limit;
        
        int left = 1, right = Integer.MAX_VALUE;
        int level = right;
        
        while(left <= right){
            int mid = left + (right - left) / 2;
            
            if (puzzle(mid)){
                level = mid;
                
                right = mid -1; 
                
            } else{ 
                left = mid + 1;
                
            }
        }
        
        return level;
    }
    
    public static boolean puzzle(int level){
        long total = 0;
        int n = diffs.length;
        
        for (int i =0; i<n; i++){
            
            if (diffs[i] <= level){
                total += (long) times[i];
            } else {
                int wrong = diffs[i] - level;
                if (i == 0){
                    total += (long) times[i] * wrong + times[i];
                } else {
                    total += (long) (times[i] + times[i-1]) * wrong + times[i];
                }
            }
            
            if (total > limit) return false;
        }
        
        return true;
        
    }
    
}