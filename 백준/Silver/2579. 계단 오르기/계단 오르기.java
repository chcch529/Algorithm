import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    static int[] steps;
    static int[] dp;
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        steps = new int[n +1];
        dp = new int[n+1];

        for (int i = 1; i <= n; i++) {
            steps[i] = Integer.parseInt(br.readLine());
        }

        if (n == 1) {
            System.out.println(steps[1]);
            return;
        }
        
        dp[1] = steps[1];
        dp[2] = steps[1] + steps[2];

        for (int i=3; i<=n; i++) {
            dp[i] = Math.max(dp[i -2], dp[i-3] + steps[i-1] ) + steps[i];
        }

        System.out.println(dp[n]);
    }


}