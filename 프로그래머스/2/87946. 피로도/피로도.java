import java.util.*;

class Solution {
    static int[][] dungeons;
    static boolean[] visited;
    static int answer;
    public int solution(int k, int[][] dungeons) {
        
        Solution.dungeons = dungeons;
        visited = new boolean[dungeons.length];
        
        answer = 0;

        DFS(k, 0);

        
        return answer;
    }
    
    public static void DFS(int k, int cnt){
        answer = Math.max(answer, cnt);
        
        for (int i=0; i<dungeons.length; i++){
            if(!visited[i] && dungeons[i][0] <= k){
                visited[i] = true;
                DFS(k - dungeons[i][1], cnt +1);
                visited[i] = false;
            } 
        }
        
    }
}