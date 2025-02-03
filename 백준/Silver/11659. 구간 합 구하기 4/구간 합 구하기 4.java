import java.util.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] num = new int[N+1];
        int[] sum = new int[N+1];

        st = new StringTokenizer(br.readLine());
        for (int i=1; i<=N; i++){
            num[i] = Integer.parseInt(st.nextToken());
            sum[i] = sum[i-1] + num[i];
        }

        StringBuilder sb = new StringBuilder();

        for (int m=0; m<M; m++){
            st = new StringTokenizer(br.readLine());

            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());

            int s = i != j ? sum[j] - sum[i-1]: num[i];

            sb.append(s).append("\n");
        }

        System.out.println(sb);

    }


}