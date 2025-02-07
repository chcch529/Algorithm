import java.util.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;



public class Main {
    static int[] A;
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        A = new int[K];
        int max = 0;
        for (int i=0; i<K; i++){
            A[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, A[i]);
        }

        System.out.println(binary(max, N));
    }

    public static int binary(int max, int key){
        long low = 1, high = max;

        while (low <= high){
            long mid = (low + (high - low) / 2);

            int cnt = 0;
            for (int i: A){
                cnt += (int) (i / mid);
            }

            if (cnt >= key){
                low = mid +1;

            } else {
                high = mid -1;
            }
        }

        return (int) high;
    }

}
