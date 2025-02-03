import java.util.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static boolean[] visited;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        visited = new boolean[N+1];
        arr = new int[M];

        dfs(N,M, 0);

        System.out.println(sb);

    }

    public static void dfs(int n, int m, int cnt){
        if (cnt == m){
            for (int i: arr){
                sb.append(i).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i =1; i<=n; i++){
            if(!visited[i]){
                visited[i] = true;
                arr[cnt] = i;
                dfs(n,m,cnt+1);
                visited[i] = false;
            }
        }


    }
}