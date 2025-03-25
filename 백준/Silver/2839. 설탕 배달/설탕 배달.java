import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    static int answer = 0;
    static boolean is = false;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        bae(n);

        System.out.println( !is ? answer : n%3 == 0 ? n/3 : -1);
    }

    public static void bae(int n) {

        if (n>= 5 && n % 5 == 0) {
            answer += n / 5;
        } else if (n < 0) {
            is = true;
        } else {
            answer += 1;
            bae(n-3);
        }


    }

}