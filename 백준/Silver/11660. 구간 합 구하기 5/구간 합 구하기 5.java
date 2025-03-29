import java.util.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {


    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] board = new int[n][n];
        int[][] dp = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int a = Integer.parseInt(st.nextToken());
                board[i][j] = a;

                if (j == 0) {
                    dp[i][j] = board[i][j];
                } else {
                    dp[i][j] = board[i][j] + dp[i][j - 1];
                }
            }

        }

        StringBuilder sb = new StringBuilder();

        for (int t = 0; t < m; t++) {
            st = new StringTokenizer(br.readLine());
            int x1 =Integer.parseInt(st.nextToken()) -1;
            int y1 =Integer.parseInt(st.nextToken()) -1;
            int x2 =Integer.parseInt(st.nextToken()) -1;
            int y2 =Integer.parseInt(st.nextToken()) -1;
            int sum = 0;

            for (int i = x1; i <= x2; i++) {
                if (y1 - 1 >= 0) {
                    sum += dp[i][y2] - dp[i][y1 - 1];
                } else {
                    sum += dp[i][y2];
                }
            }

            sb.append(sum).append("\n");
        }

        System.out.println(sb);


    }

}