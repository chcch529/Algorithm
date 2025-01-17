import java.util.*;
import java.awt.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};
    static int[][] grid;
    static boolean[][] visited;
    static int[][] cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        grid = new int[N][M];
        visited = new boolean[N][M];
        cnt = new int[N][M];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < line.length(); j++) {
                grid[i][j] = line.charAt(j) - '0';
            }

        }

        BFS(0,0);

        System.out.println(cnt[N-1][M-1]);

    }

    public static void BFS(int x, int y){
        Queue<Point> queue = new LinkedList<Point>();

        queue.add(new Point(x, y));

        visited[x][y] = true;
        cnt[x][y] = 1;

        while (!queue.isEmpty()){
            Point p = queue.poll();

            for(int i=0; i<4; i++){

                int nx = p.x + dx[i];
                int ny = p.y + dy[i];
                if(nx>=0 && nx<grid.length && ny >=0 && ny<grid[0].length){
                    if(grid[nx][ny] == 1 && !visited[nx][ny]){
                        queue.add(new Point(nx, ny));
                        visited[nx][ny] = true;
                        cnt[nx][ny] = cnt[p.x][p.y] +1;
                    }

                }
            }
        }

//
//        for (int i=0; i<4; i++){
//            int nx = x + dx[i];
//            int ny = y + dy[i];
//
//            if(nx>=0 && nx<grid.length && ny >=0 && ny<grid[0].length){
//                if(grid[nx][ny] == 1 && !visited[nx][ny]){
//                    BFS(nx,ny);
//                    cnt++;
//                }
//            }
//        }

    }

}