import java.util.*;
class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        
        int N = (nums.length)/2;
        
        Set<Integer> set = new HashSet<>();
        
        for (int n: nums){
            set.add(n);
        }
        
        answer = set.size() > N ? N : set.size();
        
        return answer;
    }
    
}
