import java.util.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;



public class Main {
    static int[] A;
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        A = new int[N];
        int max = 0;
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++){
            A[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, A[i]);
        }


        System.out.println(binary(max, M));
    }

    public static int binary(int max, int key){
        int low = 0, high = max;

        while (low <= high){
            int mid = low + (high - low) /2;
            long sum = 0;
            for (int i: A){
                sum += Math.max(i - mid, 0);
            }

            if (sum >= key){
                low = mid +1;
            } else {
                high = mid -1;
            }
        }

        return high;
    }

}
