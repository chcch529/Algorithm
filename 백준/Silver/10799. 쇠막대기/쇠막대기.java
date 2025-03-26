import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = (br.readLine());
        int len = str.length();

        int mak = 0;
        int answer = 0;

        for (int i = 0; i < len; i++) {
            char c = str.charAt(i);

            if (c == '(') {
                mak++;
            } else {
                // ))
                if (str.charAt(i - 1) == c) {
                    answer++;
                    mak--;
                // ()
                } else {
                    mak--;
                    answer += mak;
                }

            }

        }


        System.out.println(answer);

    }


}