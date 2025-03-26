import java.util.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {

    static int[] dist;
    static boolean[] visited;
    static int n,k;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        dist = new int[100001];
        visited = new boolean[100001];



        System.out.println(bfs());

    }

    public static int bfs(){
        Queue<Integer> q = new LinkedList<>();
        q.add(n);
        visited[n] = true;
        dist[n] =0;

        while (!q.isEmpty()) {
            int x = q.poll();

            if (x == k) {
                return dist[x];
            }

            for (int i : new int[]{x - 1, x + 1, x * 2}) {
                if (i>=0 && i<= 100000 && !visited[i]) {
                    visited[i] = true;
                    q.add(i);
                    dist[i] = dist[x] + 1;
                }
            }
        }

        return -1;
    }


}