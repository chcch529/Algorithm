import java.util.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static boolean[][] grid;
    static boolean[][] visited;
    static int count;
    static ArrayList<Integer> area;

    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        grid = new boolean[N][M];
        visited = new boolean[N][M];
        area = new ArrayList<>();

        for (int i =0; i<K; i++){
            st = new StringTokenizer(br.readLine());
            int downX = Integer.parseInt(st.nextToken());
            int downY = Integer.parseInt(st.nextToken());
            int upX = Integer.parseInt(st.nextToken());
            int upY = Integer.parseInt(st.nextToken());

            for ( int x= downX; x<upX; x++){
                for (int y= downY; y<upY; y++){
                    grid[x][y] = true;
                }
            }
        }

        for(int i =0; i<N; i++){
            for (int j=0; j<M; j++){

                if (!grid[i][j] && !visited[i][j]){
                    count++;
                    area.add(0);
                    DFS(i,j);
                }
            }
        }

        Collections.sort(area);

        StringBuilder sb = new StringBuilder();
        sb.append(count).append("\n");

        for (int i: area){
            sb.append(i).append(" ");
        }

        System.out.println(sb);
    }

    public static void DFS(int x, int y){
        visited[x][y] = true;
        area.set(count-1, area.get(count-1)+1);

        for(int i=0; i<4; i++){
            int nx = x +dx[i];
            int ny = y +dy[i];

            if(nx >=0 && ny>=0 && nx<visited.length && ny<visited[0].length){
                if(!grid[nx][ny] && !visited[nx][ny]){
                    DFS(nx,ny);
                }
            }
        }


    }
}