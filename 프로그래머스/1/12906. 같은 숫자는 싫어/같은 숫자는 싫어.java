import java.util.*;

public class Solution {
    public List<Integer> solution(int []arr) {
        int[] answer = {};
        
        List<Integer> stack = new ArrayList<>();
        
        for (int i =0; i<arr.length; i++){
            if (i==0) stack.add(arr[0]);
            else if (stack.get(stack.size()-1) == arr[i]) continue;
            else stack.add(arr[i]);
        }
        
      
        
        
        return stack;
    }
}