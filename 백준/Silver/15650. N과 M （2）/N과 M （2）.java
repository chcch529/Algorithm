import java.util.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    static StringBuilder sb= new StringBuilder();
    static int[] arr;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        arr = new int[M];

        dfs(N,M,0, 1);

        System.out.println(sb);

    }

    public static void dfs(int n, int m, int cnt, int idx){
        if (cnt == m){
            for (int i: arr){
                sb.append(i).append(" ");
            }
            sb.append("\n");


            return;
        }

        for(int i=idx; i<=n; i++){

            arr[cnt] = i;
            dfs(n,m, cnt+1, i+1);


        }
    }

}