import java.util.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        Queue<Integer> q = new PriorityQueue<>(((o1, o2) -> {
            int a = Math.abs(o1);
            int b = Math.abs(o2);

            if (a == b) {
                return o1 - o2;
            }
            return a - b;
        }));

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());
            if (num != 0) {
                q.add(num);
            } else {
                if (q.isEmpty()) {
                    sb.append(0);
                } else {
                    sb.append(q.poll());
                }
                sb.append("\n");
            }
            
        }

        System.out.println(sb);

    }


}