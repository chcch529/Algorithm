import java.util.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;



public class Main {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i=0; i<N; i++){
            A[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(A);


        StringBuilder sb = new StringBuilder();

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<M; i++){
            int key = Integer.parseInt(st.nextToken());
            sb.append(binary(key, A)).append("\n");
        }

        System.out.println(sb);


    }

    public static int binary(int key, int[] A){
        int low = 0;
        int high = A.length -1;

        while (low <= high){
            int mid = (low + high) / 2;

            if (A[mid] == key){
                return 1;
            } else if (A[mid] > key) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return 0;

    }



}
