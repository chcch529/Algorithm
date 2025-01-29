import java.awt.*;
import java.util.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    static int[][] grid;
    static boolean[][] iVisited;

    static int[] dy = {-1,1,0,0};
    static int[] dx = {0,0,-1,1};


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        grid = new int[N][M];
        iVisited = new boolean[N][M];

        for (int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<M; j++){
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        int cnt = 0;

        while (true){
            int bing = 0;
            boolean allWater = true;
            for (int i=0; i<N; i++){
                for (int j=0; j<M; j++){
                    if (!iVisited[i][j] && grid[i][j] > 0){
                        BFS(i, j);
                        bing++;
                    } else if (grid[i][j] > 0){
                        allWater = false;
                    }
                }
            }

            if (bing >= 2) {
                break;
            }

            if (allWater){
                cnt = 0;
                break;
            }

            iVisited = new boolean[N][M];


            cnt ++;


        }

        System.out.println(cnt);



    }

    public static void BFS(int x, int y){
        Queue<Point> queue = new LinkedList<>();
        Point p = new Point(x,y);
        queue.add(p);
        iVisited[x][y] = true;

        while (!queue.isEmpty()){
            Point now = queue.poll();

            int iceCnt = 0;


            for (int i=0; i<4; i++){
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];

                if (nx >=0 && nx < grid.length && ny >=0 && ny < grid[0].length){
                    // 주변 물 체크
                    // 0이 된 빙산이 아니고    물
                    if(!iVisited[nx][ny] && grid[nx][ny] <= 0){
                        iceCnt++;

                    // 주변 빙산 queue에 넣기
                    } else if(!iVisited[nx][ny] && grid[nx][ny] > 0){
                        queue.add(new Point(nx, ny));
                        iVisited[nx][ny] = true;

                    }
                }
            }

            grid[now.x][now.y] -= iceCnt;


        }
    }


}