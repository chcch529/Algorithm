import java.util.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        Integer[] arr = new Integer[N];

        for (int i=0; i<N; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr, Collections.reverseOrder());
        int answer = 0;

        int len = arr.length;

        for (int i = 0; i< len; i += 3){
            answer += arr[i];
        }
        for (int i = 1; i< len; i += 3){
            answer += arr[i];
        }

        System.out.println(answer);

    }
}