import java.util.*;

class Solution {

    static int[][] board;
    static String[] routes;

    static int n,m;
    static int[] current = new int[2];
    public int[] solution(String[] park, String[] routes) {
        int[] answer = {};
        Solution.routes = routes;
        m = park[0].length();
        n = park.length;
        board = new int[n][m];
        
        for (int i=0; i<n; i++){
            for (int j=0; j<m; j++){
                char c = park[i].charAt(j);
                if (c == 'S'){
                    current[0] = i;
                    current[1] = j;
                } else if (c == 'X'){
                    board[i][j] = 1;
                }
            }
        }
        

        for (String r : routes){
            move(r);
        }
    
       return current;
    }
    
    public static void move(String route){
        String[] arr = route.split(" ");
        int cnt = Integer.parseInt(arr[1]);
  
        int dx=0;
        int dy=0;
        
        switch (arr[0]) {
            case "E": dy = 1; break;
            case "W": dy = -1; break;
            case "S": dx = 1; break;
            case "N": dx = -1; break;
        }
        
        int nx = current[0];
        int ny = current[1];
        
        for(int i=0; i< cnt; i++) {
            
            nx += dx;
            ny += dy;
            
            if (nx < 0 || nx >= n || ny < 0 || ny >= m || board[nx][ny] == 1) {
                return;
            }
        }
        
        current[0] = nx;
        current[1] = ny;
        
    }
}