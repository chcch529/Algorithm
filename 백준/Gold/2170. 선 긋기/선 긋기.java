import java.util.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[][] line = new int[n][2];


        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            line[i][0] = x;
            line[i][1] = y;

        }

        Arrays.sort(line, ((o1, o2) -> {
            if (o1[0] == o2[0]) {
                return o1[1] - o2[1];
            }
            return o1[0] - o2[0];
        }));

        int total = Math.abs(line[0][1] - line[0][0]);
        int max = line[0][1];

        for (int i = 1; i < n; i++) {
            max = Math.max(max, line[i-1][1]);
            int x = line[i][0];
            int y = line[i][1];


            if (y >= max) {
                if (x > max) { // 아예 새로운 선
                    total += Math.abs(y - x);
                } else { // 이미 그어진 선 걸침

                    total += Math.abs(y - max);
                }
            }


        }

        System.out.println(total);

    }

}

