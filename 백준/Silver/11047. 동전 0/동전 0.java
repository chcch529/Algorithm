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

        int[] arr = new int[N];

        for (int i=N-1; i>=0; i--){
            arr[i] = Integer.parseInt(br.readLine());
        }
        int answer = 0;

        for (int i=0; i<N; i++){
            if (M >= arr[i]){
                answer += M / arr[i];
                M %= arr[i];
            }
            if (M == 0){
                break;
            }
        }

        System.out.println(answer);

    }


}
