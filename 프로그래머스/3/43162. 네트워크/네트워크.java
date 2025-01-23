import java.util.*;

class Solution {
    static ArrayList<Integer>[] A;
    static boolean[] visited;
    
    public int solution(int n, int[][] computers) {
        int answer = 0;
        
        A = new ArrayList[n];
        visited = new boolean[n];
        
        for (int i=0; i<n; i++){
            A[i] = new ArrayList<>();
        }
        
        for (int i=0; i<n; i++){
            for (int j=0; j<n; j++){
                if (computers[i][j] ==1){
                    A[i].add(j);
                    A[j].add(i);
                }
                
            }
        }
        
        for (int i=0; i<n; i++){
            if (!visited[i]){
                BFS(i);
                answer++;
            }
        }
        
        return answer;
    }
    
    public static void BFS(int v){
        Queue<Integer> queue = new LinkedList<>();
        visited[v] = true;
        queue.add(v);
        
        while (!queue.isEmpty()){
            int cur = queue.poll();
            for (int i: A[cur]){
                if (!visited[i]){
                    queue.add(i);
                    visited[i] = true;
                    
                }
            }
        }
        
    }
}