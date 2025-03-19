import java.util.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    static int n,m;
    static int[][] board;
    static ArrayList<int[]> home;
    static ArrayList<int[]> chicken;
    static boolean[] visited;
    static int answer = Integer.MAX_VALUE;


    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        board = new int[n+1][n+1];
        home = new ArrayList<>();
        chicken = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                int k = Integer.parseInt(st.nextToken());
                if (k == 1) {
                    home.add(new int[]{i, j});
                } else if (k == 2) {
                    chicken.add(new int[]{i, j});
                }
            }
        }

        int num = chicken.size();
        visited = new boolean[num];

        dfs(num, 0, 0);

        System.out.println(answer);
    }

    public static void dfs(int size, int depth, int start){
        if (depth == m) {
            int sum = 0;

            for (int[] hom : home) {
                int minDist = Integer.MAX_VALUE;

                for (int i = 0; i < size; i++) {
                    if (visited[i]) {
                        // 최단거리 구하기
                        int[] chi = chicken.get(i);

                        int dist = Math.abs(chi[0] - hom[0]) + Math.abs(chi[1] - hom[1]);
                        minDist = Math.min(minDist, dist);
                    }
                }
                sum += minDist;
            }

            answer = Math.min(sum, answer);
            return;

        }


        for (int i = start; i < size; i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(size, depth+1, i+1);
                visited[i] = false;
            }
        }
    }



}