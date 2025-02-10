import java.util.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;



public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        int[] A = new int[N];

        int len = N+1;
        int sum = 0;
        int l = 0;
        for (int i =0; i<N; i++){
            A[i] = Integer.parseInt(st.nextToken());
            sum += A[i];

            while (sum >= S){
                len = Math.min(len, i - l +1);
                sum -= A[l++];
            }

        }

        System.out.println(len == N+1 ? 0 : len);

    }


}