import java.util.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        Queue<Integer> q = new LinkedList<>();

        for (int i = 1; i <= n; i++) {
            q.add(i);

        }

        StringBuilder sb = new StringBuilder();
        sb.append("<");

        while(q.size() > 1) {

            for(int i = 0; i < k - 1; i++) {
                int temp = q.poll();
                q.offer(temp);
            }

            sb.append(q.poll()).append(", ");
        }

        sb.append(q.poll()).append(">");

        System.out.println(sb);

    }
}

