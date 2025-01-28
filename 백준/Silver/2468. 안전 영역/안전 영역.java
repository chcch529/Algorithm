import java.awt.*;
import java.util.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    static int[][] grid;
    static boolean[][] visited;

    static int[] dy = {-1,1,0,0};
    static int[] dx = {0,0,-1,1};

    static Set<Integer> set = new HashSet<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        grid = new int[N][N];

        for (int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j=0; j<N; j++){
                grid[i][j] = Integer.parseInt(st.nextToken());
                set.add(grid[i][j]);
            }
        }
        int max = 0;

        Integer[] check = set.toArray(new Integer[0]);

        for(int c: check) {
            int cnt = 0;
            visited = new boolean[N][N];

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (!visited[i][j] && grid[i][j] > c) {
                        Point p = new Point(i,j);
                        BFS(c, p);
                        cnt++;
                    }
                }
            }

            max = Math.max(max, cnt);
        }

        System.out.println(max == 0? 1 : max);


    }

    public static void BFS(int c, Point p){
        Stack<Point> stack = new Stack<>();
        stack.push(p);
        visited[p.x][p.y] = true;

        while(!stack.isEmpty()){
            Point now = stack.pop();

            for (int i=0; i<4; i++){
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];

                if (nx >=0 && nx <grid.length && ny >=0 && ny< grid.length
                    && grid[nx][ny] > c && !visited[nx][ny]){

                    visited[nx][ny] = true;
                    stack.push(new Point(nx, ny));
                }
            }

        }

    }


}