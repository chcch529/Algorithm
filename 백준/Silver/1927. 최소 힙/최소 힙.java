import java.util.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        PriorityQueue<Integer> p = new PriorityQueue<>(((o1, o2) -> {
            return o1 - o2;
        }));

        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());
            if (num == 0) {
                if (p.isEmpty()) {
                    sb.append(0);
                } else {
                    sb.append(p.poll());
                }
                sb.append("\n");
                continue;
            }
            p.add(num);

        }

        System.out.println(sb);
    }



}

