import java.util.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int total = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String N = br.readLine();

        char[] arr = N.toCharArray();

        ArrayList<Integer> idx = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == '-') {
                idx.add(i);
            }
        }
        if (!idx.isEmpty()) {

            int minus = 0;
            for (int i = 0; i < idx.size(); i++) {
                int last;
                if (i + 1 >= idx.size()) {
                    last = arr.length;
                } else {
                    last = idx.get(i + 1);
                }

                String r = N.substring(idx.get(i) + 1, last);

                minus = sum(r);

            }


            String start = N.substring(0, idx.get(0));
            total = 0;
            System.out.println(sum(start) - minus);
        } else {
            System.out.println(sum(N));
        }

    }

    public static int sum(String str) {

        StringBuilder sb = new StringBuilder();
        for (char c: str.toCharArray()){
            if (c >= '0' && c <= '9'){
                sb.append(c);
            } else {
                total += Integer.parseInt(sb.toString());
                sb = new StringBuilder();
            }
        }

        total += Integer.parseInt(sb.toString());

        return total;
    }
}