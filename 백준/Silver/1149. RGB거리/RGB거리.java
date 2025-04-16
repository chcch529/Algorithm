import java.util.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    static int[][] rgbHome;
    static int[][] dp;
    static int n;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        rgbHome = new int[n][3];
        dp = new int[n][3];
        
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            rgbHome[i][0] = r;
            rgbHome[i][1] = g;
            rgbHome[i][2] = b;
        }

        dp[0][0] = rgbHome[0][0];
        dp[0][1] = rgbHome[0][1];
        dp[0][2] = rgbHome[0][2];

        for (int i = 1; i < n; i++) {
            dp[i][0] = rgbHome[i][0] + Math.min(dp[i - 1][1], dp[i - 1][2]);
            dp[i][1] = rgbHome[i][1] + Math.min(dp[i - 1][0], dp[i - 1][2]);
            dp[i][2] = rgbHome[i][2] + Math.min(dp[i - 1][0], dp[i - 1][1]);

        }

        int result = Integer.MAX_VALUE;
        for (int i = 0; i < 3; i++) {
            result = Math.min(result, dp[n - 1][i]);
        }

        System.out.println(result);
    }
}