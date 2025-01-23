import java.util.*;
import java.awt.*;

class Solution {
    static int[][] maps;
    static int[][] visited;
    
    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};
    public int solution(int[][] maps) {
        int answer = 0;
        
        Solution.maps = maps;
        visited = new int[maps.length][maps[0].length];
        
        BFS();
        
        answer = visited[maps.length-1][maps[0].length -1];
        
        return answer == 0? -1 : answer;
    }
    
    public static void BFS(){
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(0,0));
        visited[0][0] = 1;
        
        while (!queue.isEmpty()){
            Point p = queue.poll();
            for (int i=0; i<4; i++){
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];
                
                if (nx >=0 && nx < maps.length
                   && ny >= 0 && ny < maps[0].length && maps[nx][ny] != 0){
                    
                    if (visited[nx][ny] == 0){
                        queue.add(new Point(nx,ny));
                        visited[nx][ny] += visited[p.x][p.y] +1;
                    }
                }
                
            }
        }
        
    }
}