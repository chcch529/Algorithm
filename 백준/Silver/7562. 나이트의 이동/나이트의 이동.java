import java.util.*;
import java.awt.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[][] grid;
    static int[][] visited;
    static Point now;
    static Point dest;
    static int[] dx = {-1,-2,-2,-1,
                        1, 2, 2, 1};
    static int[] dy = { 2, 1, -1,-2,
                        -2,-1, 1, 2};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int t=0; t<T; t++){
            int I = Integer.parseInt(br.readLine());
            grid = new int[I][I];
            visited = new int[I][I];

            StringTokenizer st = new StringTokenizer(br.readLine());
            now = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            st = new StringTokenizer(br.readLine());
            dest = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

            BFS(now.x, now.y);

            System.out.println(visited[dest.x][dest.y]-1);
        }

    }

    public static void BFS(int x, int y){
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(x,y));
        visited[x][y] = 1;

        while (!queue.isEmpty()){
            Point p = queue.poll();
            for (int i =0; i<8; i++){
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];

                if (nx>=0 && ny>=0 && nx <grid.length && ny <grid[0].length){
                    if (visited[nx][ny] == 0){
                        queue.offer(new Point(nx, ny));
                        visited[nx][ny] = visited[p.x][p.y] + 1;
                        if (nx == dest.x && ny == dest.y) return;
                    }
                }
            }
        }
    }

}