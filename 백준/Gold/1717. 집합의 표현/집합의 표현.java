import java.util.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    static int[] root;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        root = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            root[i] = i;
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int option = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (option == 0) {
                union(a, b);

            } else {
                if (find(a) == find(b)) {
                    sb.append("YES").append("\n");
                } else {

                    sb.append("NO").append("\n");
                }
            }
        }

        System.out.println(sb);
    }

    public static void union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);

        if (rootA != rootB) {
            root[rootB] = rootA;
        }
    }

    public static int find(int x) {
        if (root[x] != x) {
            root[x] = find(root[x]);
        }

        return root[x];
    }
}