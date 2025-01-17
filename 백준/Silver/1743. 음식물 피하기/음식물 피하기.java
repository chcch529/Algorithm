import java.util.*;
import java.awt.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[][] grid;
    static boolean[][] visited;

    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        grid = new int[N][M];
        visited = new boolean[N][M];

        for (int i=0; i<K; i++){
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken()) -1;
            int c = Integer.parseInt(st.nextToken()) -1;

            grid[r][c] = 1;
        }

        int max = 0;

        for(int i=0; i<N; i++){
            for (int j=0; j<M; j++){
                if(!visited[i][j] && grid[i][j] == 1){
                    max = Math.max(max, BFS(i,j));
                }
            }
        }

        System.out.println(max);


    }

    public static int BFS(int x, int y){
        int cnt = 1;
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(x,y));
        visited[x][y] = true;


        while (!queue.isEmpty()) {
            Point p = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];

                if (nx>=0 && ny>=0 && nx <grid.length && ny <grid[0].length) {
                    if (!visited[nx][ny] && grid[nx][ny] == 1) {
                        queue.offer(new Point(nx, ny));
                        visited[nx][ny] = true;
                        cnt++;
                    }
                }
            }
        }
        return cnt;
    }

}