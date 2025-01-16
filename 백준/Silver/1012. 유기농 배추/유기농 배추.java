import java.util.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};
    static int[][] grid;
    static boolean[][] visited;
    static ArrayList<Integer> cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for (int t = 0; t<T; t++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            grid = new int[N][M];
            visited = new boolean[N][M];
            cnt = new ArrayList<>();

            for(int k=0; k<K; k++){
                st = new StringTokenizer(br.readLine());
                int y = Integer.parseInt(st.nextToken());
                int x = Integer.parseInt(st.nextToken());
                grid[x][y] = 1;
            }

            for (int i=0; i<N; i++){
                for (int j=0; j<M; j++){
                    if(grid[i][j] == 1 && !visited[i][j]){
                        BFS(i,j);
                        cnt.add(0);
                    }
                }
            }

            sb.append(cnt.size()).append("\n");

        }
        System.out.print(sb);
    }

    public static void BFS(int x, int y){

        visited[x][y] = true;

        for (int i=0; i<4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx>=0 && nx < grid.length && ny>=0 && ny< grid[0].length){
                if(grid[nx][ny] == 1 && !visited[nx][ny]){
                    BFS(nx, ny);
                }
            }
        }
    }

}