import java.util.*;

class Solution {
    public Stack solution(int[] progresses, int[] speeds) {

        int term = 0;
        
        Stack<Integer> baepo = new Stack<>();
        Stack<Integer> temp = new Stack<>();
        
        
        for(int i =0; i<progresses.length; i++){
            term = 100 - progresses[i];
            term = (int) Math.ceil(term * 1.0 /speeds[i] * 1.0);
            System.out.println(term);
            if (i==0) {
                temp.push(term);
                baepo.push(1);
            } else if (term <= temp.peek()){
                baepo.push(baepo.pop() + 1);
            } else {
                temp.push(term);
                baepo.push(1);
            }
        }
        
        return baepo;
    }
}