import java.awt.*;
import java.util.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    static int[][] grid;
    static int[][] visited;

    static int N,M;

    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        grid = new int[N][M];
        visited = new int[N][M];

        for (int i=0; i<N; i++){
            Arrays.fill(visited[i], -1);
        }

        Point goal = new Point();

        for (int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<M; j++){
                grid[i][j] = Integer.parseInt(st.nextToken());
                if (grid[i][j] == 2){
                    goal = new Point(i, j);
                    visited[i][j] = 0;
                } else if (grid[i][j] == 0){
                    visited[i][j] = 0;
                }
            }
        }

        bfs(goal);

        StringBuilder sb = new StringBuilder();

        for (int i=0; i<N; i++){
            for (int j =0; j<M; j++){
                sb.append(visited[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    public static void bfs(Point goal){
        Queue<Point> q = new LinkedList<>();
        q.add(goal);

        while (!q.isEmpty()){
            Point p = q.poll();

            for (int i=0; i<4;i++){
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];

                if (nx >= 0 && nx < N && ny >=0 && ny < M){
                    if (grid[nx][ny] == 0){
                        visited[nx][ny] = 0;
                        continue;
                    }
                    if (visited[nx][ny] == -1 && grid[nx][ny] == 1){
                        visited[nx][ny] = visited[p.x][p.y] + 1;
                        q.add(new Point(nx, ny));
                    }
                }
            }
        }
    }

}
