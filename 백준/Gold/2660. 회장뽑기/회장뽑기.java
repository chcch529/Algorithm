import java.util.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    static int n;
    static int[][] graph;

    static final int INF = 999_999_999;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        graph = new int[n+1][n+1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == j) {
                    graph[i][j] = 0;
                } else {
                    graph[i][j] = INF;
                }
            }
        }


        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (a == -1 && b == -1) {
                break;
            }

            graph[a][b] = 1;
            graph[b][a] = 1;
        }

        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    graph[i][j] = Math.min(graph[i][j], graph[i][k] + graph[k][j]);
                }
            }
        }

        ArrayList<Integer> find = new ArrayList<>();

        int min = 1_000_000_000;

        for (int i=1; i<=n; i++) {
            int cur = Arrays.stream(graph[i]).max().getAsInt();
            if (min > cur) {
                min = cur;
                find.clear();
                find.add(i);
            } else if (min == cur) {
                find.add(i);
            }
        }

        Collections.sort(find);

        StringBuilder sb = new StringBuilder();
        sb.append(min).append(" ").append(find.size()).append("\n");

        for (Integer i : find) {
            sb.append(i).append(" ");
        }

        System.out.println(sb);

    }

}