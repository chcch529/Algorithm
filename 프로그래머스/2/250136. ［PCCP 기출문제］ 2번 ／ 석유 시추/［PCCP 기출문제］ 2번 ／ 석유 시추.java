import java.awt.*;
import java.util.*;

class Solution {
    public static int[][] land;
    public static boolean[][] visited;
    
    public static int[] dx = {0,0,1,-1};
    public static int[] dy = {1,-1,0,0};
    
    public static int n,m;
    
    public static int cnt;
    
    public int solution(int[][] land) {
        int answer = 0;
        Solution.land = land;
        
        n = land.length;
        m = land[0].length;
        
        int[] result = new int[m];
        visited = new boolean[n][m];
        
        for (int i=0; i< n; i++){
            for (int j=0; j<m; j++){
                if (!visited[i][j] && land[i][j] == 1){
                    cnt = 1;
                    Set<Integer> col = bfs(i,j);

                    for (int k: col){
                        result[k] += cnt;
                    }
                    
                }
            }
        }
        
        for (int i: result){
            answer = Math.max(answer, i);
        }
        
        return answer;
    }
    
    public static Set<Integer> bfs(int x, int y){
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(x,y));
        visited[x][y] = true;
        
        Set<Integer> col = new HashSet<>();
        col.add(y);

        
        while(!q.isEmpty()){
            Point p = q.poll();
            
            for (int i=0; i<4; i++){
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];
                
                if (nx >= 0 && nx < n && ny >= 0 && ny < m){
                    if (!visited[nx][ny] && land[nx][ny] == 1){
                        q.offer(new Point(nx,ny));
                        visited[nx][ny] = true;
                        col.add(ny);
                        cnt += 1;
                    }
                }
            }
        }
        
        return col;
    }
}