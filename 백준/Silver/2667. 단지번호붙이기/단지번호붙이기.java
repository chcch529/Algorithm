import java.util.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[][] grid;
    static boolean[][] visited;
    static int count = 0;
    static ArrayList<Integer> homes;
    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        grid = new int[N][N];
        visited = new boolean[N][N];
        homes = new ArrayList<>();

        for (int i =0; i<N;i++){
            String line = br.readLine();
            for (int j =0; j<N;j++){
                grid[i][j] = line.charAt(j) - '0';
            }
        }

        for (int i =0; i<N; i++){
            for (int j =0; j<N; j++){

                if (grid[i][j] == 1 && !visited[i][j]){
                    count++;
                    homes.add(0);
                    DFS(i,j);

                }
            }
        }

        Collections.sort(homes);
        StringBuilder sb =new StringBuilder();
        sb.append(count+"\n");

        for (int i : homes){
            sb.append(i+"\n");

        }

        System.out.println(sb);
    }

    public static void DFS(int x, int y){
        visited[x][y] = true;
        homes.set(count-1, homes.get(count-1)+1);

        for (int i =0; i<4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx < grid.length && ny < grid[0].length && nx >=0 && ny>=0){
                if (grid[nx][ny] == 1 && !visited[nx][ny]) {
                    DFS(nx,ny);
                }
            }
        }


    }
}