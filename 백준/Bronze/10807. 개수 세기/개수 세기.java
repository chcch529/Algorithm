import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());



        int find = Integer.parseInt(br.readLine());

        int count = 0;

        for (int i =0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            if(arr[i] == find)count++;
        }
        System.out.println(count);
    }
}
