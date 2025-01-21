import java.util.*;

class Solution {
    public int solution(int[] ingredient) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        
        for (int i: ingredient){
            stack.push(i);
            
            if (stack.size() >= 4){
                if (i == 1){
                    int pang = stack.pop();
                    int go = stack.pop();
                    int ya = stack.pop();
                    int ppang = stack.pop();
                    if (go == 3 && ya ==2 && ppang == 1){
                        answer++;
                        
                    } else{
                        stack.push(ppang);
                        stack.push(ya);
                        stack.push(go);
                        stack.push(i);
                    }

                }
            }
        }
        
        
        return answer;
    }
}