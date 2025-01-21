import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static Integer[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        dp = new Integer[N+2];
        dp[1] = 1;
        dp[2] = 2;

        int answer = nemo(N);

        System.out.println(answer);
    }
    public static int nemo(int v){
        if (dp[v] == null) {
            for (int i = 3; i <= v; i++) {
                dp[i] = (dp[i - 1] + dp[i - 2]) % 10007;
            }
        }

        return dp[v];
    }
}
