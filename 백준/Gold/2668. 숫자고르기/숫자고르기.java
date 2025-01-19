import java.util.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static ArrayList<Integer> answer = new ArrayList<>();
    static int[] A;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        A = new int[N+1];
        visited = new boolean[N+1];

        for (int i=1; i<=N; i++){
            A[i] = Integer.parseInt(br.readLine());
        }

        for (int i=1; i<=N; i++){
            DFS(i);
            visited = new boolean[N+1];
        }

        Collections.sort(answer);

        StringBuilder sb = new StringBuilder();
        sb.append(answer.size()).append("\n");

        for(int i: answer){
            sb.append(i).append("\n");
        }

        System.out.println(sb);
    }

    public static void DFS(int v){
        Stack<Integer> stack = new Stack<>();

        visited[v] = true;
        stack.push(v);

        while(!stack.isEmpty()){
            int cur = stack.pop();
            int next = A[cur];
            if (!visited[next]){
                visited[next] = true;
                stack.push(next);
            } else if (v == next){
                answer.add(next);
                break;
            }
        }



    }
}
