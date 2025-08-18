import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static ArrayList<Integer> list;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());

            list.add(num);
        }

        int min = Integer.MAX_VALUE;


        for (int i=1; i<=1000; i++) {
            min = Math.min(min, cal(i));
        }

        System.out.println(min);

    }

    public static int cal(int n) {

        int sum = 0;

        for (Integer i : list) {
            if (i < n) {
                sum += (n - i) * (n - i);
            } else if (i > n + 17) {
                sum += (i - (n + 17)) * (i - (n + 17));
            }
        }

        return sum;

    }

}

