import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = 1;
        while (true){
            int a = Integer.parseInt(br.readLine());

            if (a == 0) break;

            String holjack = ((3*a) % 2 ==0) ?"even" : "odd";

            int no2 = 0;

            if (holjack == "even") {
                no2 = (3*a) / 2;
            } else {
                no2 = (3*a+1) / 2;
            }

            int no3_4 = (no2*3) / 9;
            System.out.printf(
                    "%d. %s %d%n",
                    count, holjack, no3_4
            );
            count++;
        }
    }
}
