import java.util.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        long totalPeople = 0;
        TreeMap<Long, Long> map = new TreeMap<>();
        TreeMap<Long, Long> people = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            long x = Integer.parseInt(st.nextToken());
            long a = Integer.parseInt(st.nextToken());

            map.put(x, a);

            totalPeople += a;

        }



        long mid = (totalPeople + 1) / 2;

        long sum = 0;
        for (Long l : map.keySet()) {
            sum += map.get(l);

            if (sum >= mid) {
                System.out.println(l);
                return;
            }
        }
    }

}

