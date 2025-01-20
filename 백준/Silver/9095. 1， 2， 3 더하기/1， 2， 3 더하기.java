import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static Integer[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        dp = new Integer[12];

        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;

        StringBuilder sb = new StringBuilder();
        for (int t=0; t<T; t++){
            int N = Integer.parseInt(br.readLine());

            sb.append(nemo(N)).append("\n");

        }

        System.out.println(sb);
    }
    public static int nemo(int v){
        if (dp[v] == null) {
            for (int i = 4; i <= v; i++) {
                dp[i] = (dp[i - 1] + dp[i - 2] + dp[i - 3]);
            }
        }

        return dp[v];
    }
}
