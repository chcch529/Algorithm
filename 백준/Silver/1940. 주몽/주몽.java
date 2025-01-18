import java.util.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int start=0, end=(arr.length)-1;
        int cnt =0;
        while(start < end){
            if (arr[start] + arr[end] == M){
                start++;
                end--;
                cnt++;
            } else if (arr[start] + arr[end] < M){
                start++;
            } else {
                end--;
            }
        }

        System.out.println(cnt);
    }

}
