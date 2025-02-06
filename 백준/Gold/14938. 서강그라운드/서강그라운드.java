import java.util.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;



public class Main {
    static class Node{
        int idx, cost;

        Node(int idx, int cost){
            this.idx = idx;
            this.cost = cost;
        }
    }

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        int[] item = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            item[i] = Integer.parseInt(st.nextToken());
        }

        ArrayList<ArrayList<Node>> graph = new ArrayList<>();
        for (int i = 0; i < n + 1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            graph.get(s).add(new Node(e, c));
            graph.get(e).add(new Node(s, c));
        }
        int max = 0;
        for (int j = 1; j<=n; j++){

            int[] dist = new int[n + 1];
            Arrays.fill(dist, Integer.MAX_VALUE);
            dist[j] = 0;

            PriorityQueue<Node> q = new PriorityQueue<>((o1, o2) ->
                    Integer.compare(o1.cost, o2.cost));
            q.offer(new Node(j, 0));

            while (!q.isEmpty()) {
                Node cur = q.poll();

                if (cur.cost > dist[cur.idx]) {
                    continue;
                }

                for (int i = 0; i < graph.get(cur.idx).size(); i++) {
                    Node next = graph.get(cur.idx).get(i);

                    if (dist[next.idx] > next.cost + cur.cost) {
                        dist[next.idx] = next.cost + cur.cost;

                        q.add(new Node(next.idx, dist[next.idx]));
                    }
                }
            }

            int sum = 0;

            for (int i = 1; i < dist.length; i++) {
                if (dist[i] <= m) {
                    sum += item[i - 1];
                }
            }
            max = Math.max(sum, max);
        }

        System.out.println(max);

    }



}
