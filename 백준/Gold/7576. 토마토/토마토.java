import java.util.*;
import java.awt.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[][] grid;
    static int[][] days;
    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};
    static Queue<Point> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        grid = new int[N][M];
        days = new int[N][M];

        for (int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<M; j++){
                grid[i][j] = Integer.parseInt(st.nextToken());
                if (grid[i][j] == 1){
                    queue.offer(new Point(i,j));
                }
            }
        }
        int cnt = 0;

        cnt = BFS();


        for (int i=0; i<N; i++){
            for (int j=0; j<M; j++){
                if (grid[i][j] == 0){
                    cnt = -1;
                }
            }
        }

        System.out.println(cnt);

    }

    public static int BFS(){
        int cnt = 0;

        while (!queue.isEmpty()) {
            Point p = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];
                if (nx >= 0 && ny >= 0 && nx < grid.length && ny < grid[0].length) {
                    if (grid[nx][ny] == 0) {
                        queue.offer(new Point(nx, ny));
                        grid[nx][ny] = 1;
                        days[nx][ny] = days[p.x][p.y] +1;
                        cnt = Math.max(days[nx][ny], cnt);
                    }

                }
            }
        }
        return cnt;
    }
}