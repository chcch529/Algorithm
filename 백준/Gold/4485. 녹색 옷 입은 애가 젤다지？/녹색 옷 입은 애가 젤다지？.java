import java.util.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;



public class Main {
    static class Node {
        int x, y, cost;

        Node(int x, int y, int cost) {
            this.x = x;
            this.y = y;
            this.cost = cost;
        }
    }


    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb= new StringBuilder();
        int testcase = 1;


        while(true){
            int n = Integer.parseInt(br.readLine());
            if (n == 0) break;

            int[][] grid = new int[n][n];
            int[][] dist = new int[n][n];


            for (int i=0; i<n; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j=0; j<n; j++){
                    grid[i][j] = Integer.parseInt(st.nextToken());
                    dist[i][j] = Integer.MAX_VALUE;
                }
            }

            dist[0][0] = grid[0][0];

            PriorityQueue<Node> q = new PriorityQueue<>((o1, o2) ->
                    Integer.compare(o1.cost, o2.cost));
            q.offer(new Node(0,0,grid[0][0]));

            while (!q.isEmpty()){
                Node cur = q.poll();

                if (cur.cost > dist[cur.x][cur.y]){
                    continue;
                }

                for (int i=0; i<4; i++){
                    int nx = cur.x + dx[i];
                    int ny = cur.y + dy[i];

                    if (nx >= 0 && nx < n && ny >= 0 && ny <n){
                        if (dist[nx][ny] > cur.cost + grid[nx][ny]){
                            dist[nx][ny] = cur.cost + grid[nx][ny];

                            q.offer(new Node(nx, ny, dist[nx][ny]));
                        }
                    }


                }



            }

            sb.append("Problem ").append(testcase).append(": ")
                    .append(dist[n-1][n-1]).append("\n");

            testcase++;
            
        }
        System.out.println(sb);

    }



}
