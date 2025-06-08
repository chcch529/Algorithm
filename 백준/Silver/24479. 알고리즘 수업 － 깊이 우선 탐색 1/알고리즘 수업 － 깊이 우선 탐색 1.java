import java.util.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        ArrayList<Integer>[] A = new ArrayList[n+1];
        int[] visited = new int[n + 1];
        Arrays.fill(visited, 0);

        for (int i = 1; i <= n; i++) {
            A[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            A[u].add(v);
            A[v].add(u);
        }

        for (int i = 1; i <= n; i++) {
            Collections.sort(A[i]);
        }


        Stack<Integer> stack = new Stack<>();
        stack.add(r);
        int count = 1;

        while (!stack.isEmpty()) {
            int cur = stack.pop();


            if (visited[cur] == 0) visited[cur] = count++;

            A[cur].sort(Collections.reverseOrder());

            for (Integer i : A[cur]) {
                if (visited[i] == 0) {
                    stack.add(i);

                }
            }
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= n; i++) {
            sb.append(visited[i]).append("\n");
        }

        System.out.println(sb);
    }

}