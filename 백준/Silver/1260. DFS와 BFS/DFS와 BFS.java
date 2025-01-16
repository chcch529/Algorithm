import java.util.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static ArrayList<Integer> d_result = new ArrayList<>();
    static ArrayList<Integer> b_result = new ArrayList<>();

    static ArrayList<Integer>[] A;
    static boolean[] d_visited;
    static boolean[] b_visited;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());

        A = new ArrayList[N+1];
        for (int i =1; i<=N; i++){
            A[i] = new ArrayList<Integer>();
        }

        d_visited = new boolean[N+1];
        b_visited = new boolean[N+1];


        for (int i =1; i<=M; i++){
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            A[a].add(b);
            A[b].add(a);
        }

        for (int i =1; i<=N; i++){
            Collections.sort(A[i]);
        }


        DFS(V);
        BFS(V);

        StringBuilder sb = new StringBuilder();
        for (int i : d_result) {
            sb.append(i).append(" ");
        }
        sb.append("\n");
        for (int i : b_result) {
            sb.append(i).append(" ");
        }

        System.out.println(sb);

    }

    public static void DFS(int v){
        if(!d_visited[v]){
            d_visited[v] = true;
            d_result.add(v);
        }

        for(int i: A[v]){
            if(!d_visited[i]) DFS(i);
        }

    }

    public static void BFS(int v){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(v);
        b_visited[v] = true;
        b_result.add(v);

        while(!queue.isEmpty()){
            int cur = queue.poll();
            for(int i: A[cur]){
                if(!b_visited[i]){
                    queue.add(i);
                    b_visited[i] = true;
                    b_result.add(i);
                }
            }
        }

    }

}
