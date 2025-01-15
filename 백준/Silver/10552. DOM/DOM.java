import java.util.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static boolean[] visited;
    static ArrayList<Integer>[] A;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        visited = new boolean[M+1];
        A = new ArrayList[M+1];

        for (int i =1; i<=M; i++){
            A[i] = new ArrayList<>();
        }

        for (int i=1; i<=N; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            A[b].add(a);
        }

        int answer = DFS(P);

        System.out.println(answer);

    }

    public static int DFS(int v){
        Stack<Integer> stack = new Stack<>();
        stack.push(v);
        visited[v] = true;

        int cnt = 0;

        while (!stack.isEmpty()){
            int cur = stack.pop();

            if (A[cur].isEmpty()) return cnt;
            int i = A[cur].get(0);
            if (!visited[i]){
                stack.push(i);
                visited[i] = true;
                cnt++;
            }

        }
        return -1;
    }

}