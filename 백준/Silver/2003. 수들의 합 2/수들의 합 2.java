import java.util.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] arr = new int[N+1];

        st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int start=0, end=0;
        int cnt =0;
        int sum =0;

        while (end<=N){
            if (sum < M) {
                sum += arr[end++];
            } else {
                sum -= arr[start++];
            }
            if ( sum == M){
                cnt++;
            }
        }

        System.out.println(cnt);
    }

}
