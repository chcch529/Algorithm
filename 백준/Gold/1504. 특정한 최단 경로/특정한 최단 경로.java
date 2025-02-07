import java.util.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;



public class Main {
    static class Node {
        int idx, cost;

        Node(int idx, int cost){
            this.cost = cost;
            this.idx = idx;
        }
    }
    static ArrayList<ArrayList<Node>> graph;
    static final int INF = 200000*1000;


    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>();

        for (int i=0; i<N+1; i++){
            graph.add(new ArrayList<>());
        }


        for (int i=0; i<E; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            graph.get(s).add(new Node(e, c));
            graph.get(e).add(new Node(s, c));
        }

        st = new StringTokenizer(br.readLine());
        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());

        int route1 = dik(1, v1) +dik(v1, v2) + dik(v2, N);

        int route2 = dik(1, v2) + dik(v2, v1) + dik(v1, N);


        int min = (route1 >= INF && route2 >= INF) ? -1: Math.min(route1, route2);

        System.out.println(min);



    }

    public static int dik(int start, int end){
        int[] dist = new int[graph.size() +1];
        Arrays.fill(dist, INF);
        dist[start] = 0;

        PriorityQueue<Node> q = new PriorityQueue<>((o1, o2) ->
                Integer.compare(o1.cost, o2.cost));

        q.offer(new Node(start, 0));

        while(!q.isEmpty()){
            Node cur = q.poll();

            if (cur.cost > dist[cur.idx]){
                continue;
            }

            for (int i=0; i<graph.get(cur.idx).size(); i++){
                Node next = graph.get(cur.idx).get(i);

                if (dist[next.idx] > next.cost + cur.cost){
                    dist[next.idx] = next.cost + cur.cost;

                    q.offer(new Node(next.idx, dist[next.idx]));
                }
            }
        }

        return dist[end];
    }



}
