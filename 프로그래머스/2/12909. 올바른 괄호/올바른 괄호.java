import java.util.*;

class Solution {
    boolean solution(String s) {
        boolean answer = true;
        
        Stack<Character> stack = new Stack<>();
        
        for (int i = 0; i < s.length(); i++){
            if (stack.isEmpty() && s.charAt(i) == (')')) {
                return false;
            }
            
            
            if (s.charAt(i) == ('(')) {
                stack.push('(');
            } else {
                stack.pop();
            }
            
        }
        
        if (stack.isEmpty()){
            answer = true;
        } else answer = false;
        

        return answer;
    }
}