import java.util.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int max = 0;
        int piro = 0;
        int cnt = 0;

        while(cnt<24){
            if (piro + A <= M){
                piro += A;
                max += B;
            } else {
                piro -= C;
                if (piro < 0) piro = 0;
            }
            cnt++;
        }

        System.out.println(max);

    }


}