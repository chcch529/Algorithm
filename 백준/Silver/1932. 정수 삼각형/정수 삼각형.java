import java.util.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] tri = new int[n][n];
        int[][] dp = new int[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j<=i; j++) {
                tri[i][j] = Integer.parseInt(st.nextToken());
                dp[i][j] = tri[i][j];
            }
        }
        if (n == 1) {
            System.out.println(tri[0][0]);
            return;
        }


        dp[0][0] = tri[0][0];
        dp[1][0] = tri[0][0] + tri[1][0];
        dp[1][1] = tri[0][0] + tri[1][1];

        for (int i = 1; i < n-1; i++) {
            for (int j = 0; j <= i; j++) {

                int left = dp[i][j] + tri[i + 1][j];
                int right = dp[i][j] + tri[i + 1][j+1];

                dp[i + 1][j] = Math.max(dp[i + 1][j], left);
                dp[i + 1][j+1] = Math.max(dp[i + 1][j+1], right);

            }
        }

        int result = 0;
        for (Integer i : dp[n - 1]) {
            result = Math.max(result, i);
        }


        System.out.println(result);
    }
}