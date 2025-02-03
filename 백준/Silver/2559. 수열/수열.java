import java.util.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        int[] sum = new int[N-K+1];

        st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());

        }

        for (int j=0; j<=N-K; j++) {
            for (int i = 0; i < K; i++) {
                sum[j] += arr[j+i];
            }
        }

        int max = Integer.MIN_VALUE;
        for(int i: sum){
            max = Math.max(max, i);
        }

        System.out.println(max);

    }


}
