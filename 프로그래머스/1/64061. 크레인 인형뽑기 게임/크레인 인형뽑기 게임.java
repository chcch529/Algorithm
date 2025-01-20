import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        
        
        for (int m =0; m<moves.length; m++){
            int get = moves[m] -1;
            
            for (int i=0; i<board.length; i++){
                if (board[i][get] != 0){
                    
                    if(!stack.isEmpty()){
                        if (stack.peek() == board[i][get]){
                            stack.pop();
                            answer += 2;
                            board[i][get] = 0;
                            break;
                        } 
                    } 
                    stack.push(board[i][get]);
                    board[i][get] = 0;
                    
                    break;
                    
                }
            }
        }
        return answer;
    }
}