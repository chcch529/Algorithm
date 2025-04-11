import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        String t = br.readLine();

        int sLen = s.length();
        int tLen = t.length();



        while (true) {
            if (t.equals(s)) {
                System.out.println(1);
                System.exit(0);
            }

            tLen = t.length();

            if (tLen <= sLen) {
                System.out.println(0);
                System.exit(0);
            }

            char pop = t.charAt(tLen - 1);
            if (pop == 'B') {
                t = t.substring(0, tLen - 1);
                t = new StringBuffer(t).reverse().toString();
            } else {
                t = t.substring(0, tLen - 1);
            }
        }

    }

}

