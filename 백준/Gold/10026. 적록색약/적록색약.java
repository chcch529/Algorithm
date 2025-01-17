import java.util.*;
import java.awt.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static char[][] grid;
    static char[][] gGrid;
    static boolean[][] visited;
    static boolean[][] gVisited;

    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        grid = new char[N][N];
        gGrid = new char[N][N];
        visited = new boolean[N][N];
        gVisited = new boolean[N][N];

        for(int i =0; i<N; i++){
            String line = br.readLine();
            for(int j=0; j<N; j++){
                if (line.charAt(j) == 'G'){
                    gGrid[i][j] = 'R';
                } else gGrid[i][j] = line.charAt(j);
                grid[i][j] = line.charAt(j);
            }
        }

        int cnt = 0;
        int gCnt = 0;
        for(int i =0; i<N; i++) {
            for (int j = 0; j < N; j++) {
                if(!visited[i][j]) {
                    DFS(i, j, grid, visited);
                    cnt++;
                }
                if(!gVisited[i][j]) {
                    DFS(i, j, gGrid, gVisited);
                    gCnt++;
                }

            }
        }

        System.out.println(cnt+" "+gCnt);

    }

    public static void DFS(int x, int y, char[][] grid, boolean[][] visited){
        Queue<Point> queue = new LinkedList<>();

        queue.offer(new Point(x,y));
        visited[x][y] = true;

        while (!queue.isEmpty()){
            Point p = queue.poll();
            for (int i=0; i<4; i++){
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];
                if (nx>=0 && ny>=0 && nx <grid.length && ny <grid[0].length) {
                    if (!visited[nx][ny] && grid[nx][ny] == grid[p.x][p.y]) {
                        queue.offer(new Point(nx, ny));
                        visited[nx][ny] = true;

                    }
                }
            }
        }


    }

}