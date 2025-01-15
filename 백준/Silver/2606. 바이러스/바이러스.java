import java.util.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static boolean[] visited;
    static ArrayList<Integer>[] A;
    static ArrayList<Integer> procedure;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        visited = new boolean[N+1];
        A = new ArrayList[N+1];
        procedure = new ArrayList<>();

        for(int i=1; i<=N; i++){
            A[i] = new ArrayList<>();
        }
        for (int i=0; i<M; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            A[a].add(b);
            A[b].add(a);
        }

        DFS_s(1);

        Set<Integer> set = new HashSet<>(procedure);

        System.out.println(procedure.size()-1);
    }

    public static void DFS_s(int v){
        Stack<Integer> stack = new Stack<>();

        stack.push(v);
        visited[v] = true;
        procedure.add(v);

        while(!stack.isEmpty()){
            int cur = stack.pop();

            for(int i: A[cur]){
                if (!visited[i]){
                    visited[i] = true;
                    procedure.add(i);
                    stack.push(i);
                }
            }
        }

    }


}