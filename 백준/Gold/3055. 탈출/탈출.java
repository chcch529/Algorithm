import java.util.*;
import java.awt.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static char[][] grid;
    static int[][] visited;
    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};
    static Queue<Point> water = new LinkedList<>();
    static Queue<Point> gosm = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        grid = new char[R][C];
        visited = new int[R][C];

        for (int i=0; i<R; i++){
            String line = br.readLine();
            for (int j=0; j<C; j++){
                grid[i][j] = line.charAt(j);
                if(grid[i][j] == 'S'){
                    gosm.offer(new Point(i,j));

                } else if (grid[i][j] == '*') {
                    water.offer(new Point(i,j));
                }
            }
        }

        int cnt = BFS();

        System.out.println(cnt == -1? "KAKTUS": cnt);

    }

    public static int BFS(){
        while(!gosm.isEmpty()){
            // 물이 먼저 이동
            int waterSize = water.size();
            for(int W = 0; W<waterSize; W++) {
                Point w = water.poll();
                for (int i = 0; i < 4; i++) {
                    int nx = w.x + dx[i];
                    int ny = w.y + dy[i];

                    if (nx >= 0 && ny >= 0 && nx < grid.length && ny < grid[0].length) {
                        if (grid[nx][ny] == '.') {
                            water.add(new Point(nx, ny));
                            grid[nx][ny] = '*';
                        }
                    }
                }
            }
            // 물 차고 나서 고슴도치 한칸 이동
            int gosmSize = gosm.size();
            for (int G=0; G<gosmSize; G++) {
                Point g = gosm.poll();
                for (int i = 0; i < 4; i++) {
                    int nx = g.x + dx[i];
                    int ny = g.y + dy[i];

                    if (nx >= 0 && ny >= 0 && nx < grid.length && ny < grid[0].length) {
                        if (grid[nx][ny] == '.' && visited[nx][ny] == 0) {
                            grid[g.x][g.y] = '.';
                            grid[nx][ny] = 'S';
                            gosm.offer(new Point(nx, ny));
                            visited[nx][ny] = visited[g.x][g.y] + 1;
                        }
                        if (grid[nx][ny] == 'D') {
                            visited[nx][ny] = visited[g.x][g.y] + 1;
                            return visited[nx][ny];
                        }
                    }
                }
            }
        }


        return -1;
    }
}