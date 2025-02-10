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

        int[] A = new int[N];
        for (int i =0; i<N; i++){
            A[i] = Integer.parseInt(br.readLine());;
        }
        Arrays.sort(A);

        int l = 0, r = 0;

        int an = Integer.MAX_VALUE;
        while (r < N){
            int temp = A[r] - A[l];
            if (temp == M){
                an = temp;
                break;
            } else if (temp < M) {
                r++;
                continue;
            }

            an = Math.min(an, temp);
            l++;
        }

        System.out.println(an);

    }


}
