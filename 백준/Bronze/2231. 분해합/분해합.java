import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int answer = N;

        for (int i = N; i>0; i--){
            String num = i + "";
            String[] nums = num.split("");

            int sum = i;
            for (String n: nums){
                sum += Integer.parseInt(n);
            }

            if (sum == N) answer = Math.min(i, answer);
        }

        if (answer == N) answer = 0;

        System.out.print(answer);


    }
}