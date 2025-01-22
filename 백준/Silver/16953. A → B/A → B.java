import java.util.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int cnt = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());

        cal(A, B);

        System.out.println(cnt);

    }

    public static void cal(long a, long b) {
        if (a == b){
            cnt ++;
            return;
        } else if (a > b) {
            cnt = -1;
            return;
        }

        if (b % 2 == 0){
            cnt++;
            b /= 2;
            cal(a,b);
        } else if ( b % 10 == 1 ){
            b = (b-1)/10;
            cnt++;
            cal(a, b);
        } else {
            cnt = -1;
        }
        
    }
}