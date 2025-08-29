import java.util.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) ->{
            return o1 - o2;
        });


        if (n == 1) {
            System.out.println(0);
            return;
        }

        for (int i = 0; i < n; i++) {
            pq.add(Integer.parseInt(br.readLine()));
        }

        int sum = 0;

        while (true) {
            int a = pq.poll();
            int b = pq.poll();
            sum += a+b;
            if (pq.isEmpty()) {
                System.out.println(sum);
                return;
            }

            pq.add(a+b);

        }


    }

}