import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        String[] str = br.readLine().split("");

        int sum = 0;
        for (String n: str){
            sum += Integer.parseInt(n);
        }

        System.out.println(sum);
        br.close();

    }
}
