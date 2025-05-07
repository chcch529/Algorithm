import java.util.*;

class Solution {
    static int[][] board;
    static boolean[][] visited;
    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};
    static int answer;
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        characterX *= 2;
        characterY *= 2;
        itemX *= 2;
        itemY *= 2;
        answer = 0;
        
        board = new int[102][102];
        visited = new boolean[102][102];
        
        for (int[] rec: rectangle){
            for(int i= rec[0]*2 +1; i<rec[2]*2; i++){
                for(int j= rec[1]*2 + 1; j< rec[3]*2; j++){
                    board[i][j] = 2;
                }
            }
            for(int i= rec[0]*2; i<=rec[2]*2; i++){
                if(board[i][rec[1]*2] != 2) board[i][rec[1]*2] = 1;
                if(board[i][rec[3]*2] != 2) board[i][rec[3]*2] = 1;
            }
            for(int i= rec[1]*2; i<=rec[3]*2; i++){
                if(board[rec[0]*2][i] != 2) board[rec[0]*2][i] = 1;
                if(board[rec[2]*2][i] != 2) board[rec[2]*2][i] = 1;
                
            }

            
        }
        
        bfs(characterX, characterY, itemX, itemY);
        
        return answer;
    }
    
    public static void bfs(int x, int y, int itemX, int itemY){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x,y, 0});
        visited[x][y] = true;
        
        while(!q.isEmpty()){
            int[] cur = q.poll();
            
            if(cur[0] == itemX && cur[1] == itemY){
                answer = cur[2] / 2;
                return;
            }
            
            for (int i=0; i<4; i++){
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];
                
                if(nx >=0 && nx <=101 && ny >=0 && ny<=101){
                    if (board[nx][ny] == 1 && !visited[nx][ny]){
                        q.add(new int[]{nx, ny, cur[2] + 1});
                        visited[nx][ny] = true;
                    }
                }
            }
        }
    }
        
}