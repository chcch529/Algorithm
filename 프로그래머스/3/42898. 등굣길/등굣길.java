import java.util.*;

class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        int[][] board = new int[n+1][m+1];
        
        for (int[] water : puddles){
            board[water[1]][water[0]] = -1;
        }
        
        board[1][1] = 1;
        
        for(int i=1; i<=n; i++){
            for (int j=1; j<=m; j++){
                if (board[i][j] == -1){
                    continue;
                }
                
                // 우측 n+1, m
                if (board[i][j-1] > 0){
                    board[i][j] = ( board[i][j] +board[i][j-1]) % 1000000007;
                }
                
                // 아래 n+1, m
                if (board[i-1][j] > 0){
                    board[i][j] =( board[i][j] + board[i-1][j]) % 1000000007;
                }
            }
        }

        
        return board[n][m];
    }
}