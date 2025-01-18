import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int cnt = 666;
        String jong = "";
        int check = 0;
        while (true){
            jong = String.valueOf(cnt);
            if (jong.contains("666")) {
                check++;
                if (check == N) break;
            }
            cnt++;
        }

        System.out.println(jong);

    }


}
