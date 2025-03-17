import java.util.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    static int N, Q;

    static class Node {
        int idx;
        int cost;

        public Node(int idx, int cost) {
            this.idx = idx;
            this.cost = cost;
        }
    }

    static ArrayList<ArrayList<Node>> A;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());

        A = new ArrayList<>();

        for (int i = 0; i <= N; i++) {
            A.add(new ArrayList<>());
        }

        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());

            A.get(a).add(new Node(b, r));
            A.get(b).add(new Node(a, r));
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            sb.append(bfs(v, k)).append("\n");

        }
        System.out.println(sb);

    }

    private static int bfs(int v, int k) {
        boolean[] visited = new boolean[N+1];
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(v, Integer.MAX_VALUE));
        visited[v] = true;

        int cnt = 0;

        while (!q.isEmpty()) {
            Node current = q.poll();

            for (Node node : A.get(current.idx)) {
                if (!visited[node.idx] && node.cost >= k) {
                    visited[node.idx] = true;
                    q.offer(new Node(node.idx, node.cost));
                    cnt++;
                }
            }
        }
        return cnt;
    }


}