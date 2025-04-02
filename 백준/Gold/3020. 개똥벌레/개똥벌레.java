import java.util.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());

        int[] bottom = new int[h];
        int[] top = new int[h];

        for (int i = 0; i < n; i++) {
            int hei = Integer.parseInt(br.readLine());

            if ((i + 1) % 2 == 0) {
                top[hei -1]++;
            } else {
                bottom[h - hei]++;
            }
        }

        for (int i = 0; i < h -1; i++) {
            bottom[i + 1] += bottom[i];
        }
        for (int i = h - 1; i > 0; i--) {
            top[i - 1] += top[i];
        }

        int cnt = 0;
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < h; i++) {
            int sum = top[i] + bottom[i];
            if (min > sum) {
                min = sum;
                cnt = 1;
            } else if (min == sum) {
                cnt++;
            }
        }

        System.out.println(min + " " + cnt);

    }



}

