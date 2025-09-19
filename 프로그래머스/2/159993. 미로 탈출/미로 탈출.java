import java.util.*;

class Solution {
    static int[][] goL;
    static int[][] goE;
    static char[][] map;
    static int[][] sle;
    
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    
    static int row;
    static int col;
    public int solution(String[] maps) {
        int answer = 0;
    
        row = maps.length;
        col = maps[0].length();
        map = new char[row][col];
        goL = new int[row][col];
        goE = new int[row][col];
        sle = new int[3][2];
        
        
        for (int i=0; i<row; i++){
            for (int j=0; j<col; j++){
                if(maps[i].charAt(j) == 'S') {
                    sle[0][0] = i;
                    sle[0][1] = j;
                } else if (maps[i].charAt(j) == 'L'){
                    sle[1][0] = i;
                    sle[1][1] = j;
                } else if (maps[i].charAt(j) == 'E'){
                    sle[2][0] = i;
                    sle[2][1] = j;
                }
                map[i][j] = maps[i].charAt(j);
            }
        }
        
        if(! bfs(sle[0][0], sle[0][1], goL, 'L')) return -1;
        if(! bfs(sle[1][0], sle[1][1], goE, 'E')) return -1;
        
        answer = (goL[sle[1][0]][sle[1][1]] + goE[sle[2][0]][sle[2][1]]);

        return answer;

        
    }
    
    public static boolean bfs(int x, int y, int[][] visited, char dest){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y});
        visited[x][y] = 0;
        
        while (!q.isEmpty()){
            int[] cur = q.poll();
            
            for (int i=0; i<4; i++){
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];
                
                if (nx >= 0 && ny >= 0 && nx <row && ny <col){
                    if (map[nx][ny] != 'X' && visited[nx][ny] == 0){
                        q.add(new int[]{nx, ny});
                        visited[nx][ny] = visited[cur[0]][cur[1]] + 1;
                        
                        if(map[nx][ny] == dest){
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }
}