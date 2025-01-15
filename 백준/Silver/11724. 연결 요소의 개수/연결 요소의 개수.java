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

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        visited = new boolean[N+1];
        A = new ArrayList[N+1];
        procedure = new ArrayList<>();

        for(int i =1;i<=N; i++){
            A[i] = new ArrayList<>();
        }

        for (int i =1; i<=M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            A[a].add(b);
            A[b].add(a);
        }

        int cnt = 0;

        for (int i =1; i<=N; i++){
            if (!visited[i]){
                DFS(i);
                cnt++;
            }
        }

        System.out.println(cnt);
    }

    public static void DFS(int v){
        Stack<Integer> stack = new Stack<>();
        stack.push(v);
        visited[v] = true;
        procedure.add(v);

        while (!stack.isEmpty()){
            int cur = stack.pop();
            for(int i : A[cur]){
                if(!visited[i]){
                    stack.push(i);
                    visited[i] = true;
                    procedure.add(i);

                }
            }
        }

    }

}