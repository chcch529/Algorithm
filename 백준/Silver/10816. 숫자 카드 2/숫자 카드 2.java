import java.util.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;



public class Main {
    static int[] A;
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        A = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++){
            A[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(A);

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        StringBuilder sb= new StringBuilder();
        for (int i=0; i<M; i++){
            int key = Integer.parseInt(st.nextToken());
            sb.append(upperBound(key) - lowerBound(key)).append(" ");
        }

        System.out.println(sb);
    }

    public static int lowerBound(int key){
        int low = 0;
        int high = A.length;

        while (low < high){
            int mid = (low + high) / 2;

            if (A[mid] >= key){
                high = mid;
            } else {
                low = mid +1;
            }
        }
        return low;
    }

    public static int upperBound(int key){
        int low = 0;
        int high = A.length;

        while (low < high){
            int mid = (low + high) / 2;

            if (A[mid] <= key){
                low = mid +1;
            } else {
                high = mid;
            }
        }
        return low;
    }

}
