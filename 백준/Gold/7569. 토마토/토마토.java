import java.util.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    static int[][][] box;
    static int[][][] visited;

    static int[] dx = {0,0,-1,1,0,0};
    static int[] dy = {-1,1,0,0,0,0};
    static int[] dz = {0,0,0,0,-1,1};

    static Queue<int[]> queue = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());

        box = new int[M][N][H];
        visited = new int[M][N][H];


        boolean allTo = true;
        for (int h=0; h<H; h++) {
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    box[i][j][h] = Integer.parseInt(st.nextToken());

                    
                    if ( box[i][j][h] == 1){
                        int[] tomato = {i, j, h};
                        queue.add(tomato); // 시작점 저장
                        visited[i][j][h] = 1;
                    } else if ( box[i][j][h] == 0) {
                        allTo = false; // 전부 토마토는 아님
                    } else if (box[i][j][h] == -1){
                        visited[i][j][h] = -1;
                    }
                }
            }
        }

        BFS();

        int max = 0;
        boolean to = true;
        for (int i =0; i<M; i++){
            for (int j=0; j<N; j++){
                for (int h=0; h<H; h++){
                    max = Math.max(max, visited[i][j][h]);
                    if (visited[i][j][h] == 0){
                        to = false;
                        break;
                    }
                }
            }
        }
                //        모든곳 방문함  : 전부 토마토 : 불가능
        System.out.println(to ? max-1 : allTo ? 0 : -1);

    }

    public static void BFS(){

        while (!queue.isEmpty()){
            int[] now = queue.poll();

            for (int i=0; i<6; i++){
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];
                int nz = now[2] + dz[i];

                if (nx >= 0 && nx < box.length && ny >=0 && ny < box[0].length
                    && nz >=0 && nz < box[0][0].length){
                    if (visited[nx][ny][nz] == 0
                        && box[nx][ny][nz] == 0) {

                        visited[nx][ny][nz] = visited[now[0]][now[1]][now[2]] + 1;
                        int[] next = {nx, ny, nz};
                        queue.add(next);
                    }

                }

            }
        }

    }


}