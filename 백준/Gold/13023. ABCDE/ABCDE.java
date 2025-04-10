import java.util.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    static int n, m;
    static ArrayList<Integer>[] A;
    static boolean[] visited;

    static boolean check= false;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        A = new ArrayList[n];
        visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            A[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            A[a].add(b);
            A[b].add(a);
        }

        for (int i = 0; i < n; i++) {
            visited[i] = true;
            dfs(1,i);
            visited[i] = false;
            if (check) {
                System.out.println(1);
                System.exit(0);
            }
        }


        System.out.println(0);

    }

    static void dfs(int depth, int idx) {
        if (depth == 5) {
            check = true;
            return;
        }



        for (int i : A[idx]) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(depth +1, i);
                visited[i] = false;
            }
        }
    }

}

