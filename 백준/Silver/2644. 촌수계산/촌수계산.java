import java.util.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static ArrayList<Integer>[] A;
    static int[] visited;
    static int cnt = 0, p1, p2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 사람 수
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        // 계산해야 하는 애들
        p1 = Integer.parseInt(st.nextToken());
        p2 = Integer.parseInt(st.nextToken());
        // 부모 자식 관계 수
        int m = Integer.parseInt(br.readLine());

        A = new ArrayList[n+1];
        visited = new int[n+1];

        for (int i = 1; i<=n; i++){
            A[i] = new ArrayList<>();
            visited[i] = 0;
        }

        for (int i = 1; i<=m; i++){
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            A[a].add(b);
            A[b].add(a);
        }

        BFS(p1);

        System.out.println(visited[p2]);
    }

    public static void BFS(int v){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(v);

        while(!queue.isEmpty()){
            int cur = queue.poll();

            for (int i: A[cur]){
                if(visited[i] == 0){
                    queue.add(i);
                    visited[i] = visited[cur]+1;
                    if (i == p2) {
                        return;
                    }
                }
            }

        }

        visited[p2] = -1;


    }

}