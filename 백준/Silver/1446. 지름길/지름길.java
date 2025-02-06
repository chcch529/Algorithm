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

        int N = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());

        ArrayList<ArrayList<Node>> graph = new ArrayList<ArrayList<Node>>();

        for (int i=0; i<D+1; i++){
            graph.add(new ArrayList<>());
        }

        int[] dist = new int[D+1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        for (int i=0; i<D; i++){
            graph.get(i).add(new Node(i+1 ,1));
        }

        for (int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());

            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if (e <= D) {
                graph.get(s).add(new Node(e, c));
            }
        }

        dist[0] = 0;

        PriorityQueue<Node> q = new PriorityQueue<>((o1, o2) ->
                Integer.compare(o1.cost, o2.cost));

        q.offer(new Node(0, 0));

        while (!q.isEmpty()){
            Node cur = q.poll();

            if (cur.cost > dist[cur.idx]){
                continue;
            }

            for (int i=0; i<graph.get(cur.idx).size(); i++){
                Node next = graph.get(cur.idx).get(i);

                if (dist[next.idx] > next.cost + cur.cost){
                    dist[next.idx] = next.cost + cur.cost;

                    q.add(new Node(next.idx, dist[next.idx]));
                }
            }
        }


        System.out.println(dist[D]);

    }


}
