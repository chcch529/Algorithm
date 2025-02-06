import java.util.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;



public class Main {

    static class Node{
        int cost, idx;

        Node(int idx, int cost){
            this.idx = idx;
            this.cost = cost;
        }
    }


    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(br.readLine());

        ArrayList<ArrayList<Node>> graph = new ArrayList<>();

        for (int i=0; i<V+1; i++){
            graph.add(new ArrayList<>());
        }

        for (int i=0; i<E; i++){
            st = new StringTokenizer(br.readLine());

            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            graph.get(s).add(new Node(e, c));
        }

        int[] dist = new int[V+1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        PriorityQueue<Node> q = new PriorityQueue<>((o1, o2) ->
                Integer.compare(o1.cost, o2.cost));
        q.offer(new Node(K, 0));

        while (!q.isEmpty()){
            Node cur = q.poll();

            if (cur.cost > dist[cur.idx]){
                continue;
            }

            for (int i =0; i< graph.get(cur.idx).size(); i++){
                Node next = graph.get(cur.idx).get(i);

                if (dist[next.idx] > next.cost + cur.cost){
                    dist[next.idx] = next.cost + cur.cost;

                    q.add(new Node(next.idx, dist[next.idx]));
                }
            }
        }

        StringBuilder sb= new StringBuilder();
        for (int i=1; i<dist.length; i++){
            if (i ==K){
                sb.append(0);
            } else if (dist[i] == Integer.MAX_VALUE){
                sb.append("INF");
            }else  {
                sb.append(dist[i]);
            }
            sb.append("\n");
        }

        System.out.println(sb);

    }



}
