import java.util.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    static int n, cnt;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        cnt = 0;

        int r = Integer.parseInt(st.nextToken()) + 1;
        int c = Integer.parseInt(st.nextToken()) + 1;

        z(r,c,0);

        System.out.println(cnt);
    }

    private static void z(int r, int c, int depth) {
        int half = n-1-depth;

        if (1 <= r && r <= Math.pow(2, half) ) {
            if (1 <= c && c <= Math.pow(2, half) ) { // 1


            } else { // 2
                cnt += (int) Math.pow(4, half);

                c -= (int) Math.pow(2, half);

            }
        } else {
            if (1 <= c && c <= Math.pow(2, half) ) { // 3
                cnt += (int) Math.pow(4, half) * 2;

                r -= (int) Math.pow(2, half);

            } else { // 4
                cnt += (int) Math.pow(4, half) * 3;

                r -= (int) Math.pow(2, half);
                c -= (int) Math.pow(2, half);
            }
        }

        if (half == 0) {
            return;
        }

        z(r,c,depth+1);
    }

}