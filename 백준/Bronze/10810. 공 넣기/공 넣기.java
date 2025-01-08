import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];

        for (int a =0; a<M; a++){
            StringTokenizer stt = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(stt.nextToken());
            int j = Integer.parseInt(stt.nextToken());
            int k = Integer.parseInt(stt.nextToken());

            for (int I = i-1; I<=j-1; I++){
                arr[I] = k;
            }
        }

        for (int i = 0; i<N;i++){
            System.out.print(arr[i] + " ");
        }

    }
}
