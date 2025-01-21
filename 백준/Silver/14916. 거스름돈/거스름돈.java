import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        if (N == 1 || N == 3){
            System.out.println(-1);
            return;
        }

        int cnt = 0;

        if (N% 5 == 0){
            cnt = N / 5;
        } else if ((N%5) % 2 == 0){
            cnt = (N / 5) + (N % 5) / 2;
        } else {
            int temp = (N / 5) -1;
            N -= temp*5;
            cnt = (temp) + N/2;
        }


        System.out.println(cnt);

    }
}