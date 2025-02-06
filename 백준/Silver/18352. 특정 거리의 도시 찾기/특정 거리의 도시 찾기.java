import java.util.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;



public class Main {
    static ArrayList<ArrayList<Node>> graph;
    static class Node{
        int cost;
        int idx;

        Node(int idx, int cost){
            this.cost = cost;
            this.idx = idx;

        }
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        int K = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());

        graph = new ArrayList<ArrayList<Node>>();

        int[] dist = new int[V+1];

        for (int i=0; i< V+1; i++){
            graph.add(new ArrayList<Node>());
        }

        for (int i=0; i<E; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            graph.get(s).add(new Node(e, 1));
        }

        for (int i=0; i<V+1; i++){
            dist[i] = Integer.MAX_VALUE;
        }

        PriorityQueue<Node> q = new PriorityQueue<Node>((o1, o2) ->
                Integer.compare(o1.cost, o2.cost));

        q.offer(new Node(S, 0));

        dist[S] = 0;

        StringBuilder sb = new StringBuilder();
        while(!q.isEmpty()){
            Node cur = q.poll();

            if (dist[cur.idx] > cur.cost){
                continue;
            }

            for (int i=0; i< graph.get(cur.idx).size(); i++){
                Node next = graph.get(cur.idx).get(i);

                if (dist[next.idx] > cur.cost + next.cost){
                    dist[next.idx] = cur.cost + next.cost;
                    q.offer(new Node(next.idx, dist[next.idx]));
                }
            }
        }

        boolean check = true;
        for (int i=1; i<=V; i++){
            if(dist[i] == K){
                sb.append(i).append("\n");
                check = false;
            }
        }

        System.out.println(check ? "-1" : sb);

    }


}
