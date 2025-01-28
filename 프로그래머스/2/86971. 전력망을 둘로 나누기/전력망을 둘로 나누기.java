import java.util.*;

class Solution {
    static ArrayList<Integer>[] A;

    public int solution(int n, int[][] wires) {
        A = new ArrayList[n+1];
        
        for (int i=0; i<=n; i++){
            A[i] = new ArrayList<>();
        }
        
        for (int i=0; i<wires.length; i++){
            A[wires[i][0]].add(wires[i][1]);
            A[wires[i][1]].add(wires[i][0]);
        }
        
        int answer = n;
        for (int i=0; i<wires.length; i++){
            A[wires[i][0]].remove(Integer.valueOf(wires[i][1]));
            A[wires[i][1]].remove(Integer.valueOf(wires[i][0]));
            
            answer = Math.min(Math.abs(n - cut(n-1-i)*2), answer);
            
            A[wires[i][0]].add(Integer.valueOf(wires[i][1]));
            A[wires[i][1]].add(Integer.valueOf(wires[i][0]));
        }
        
        
        return answer;
    }
    
    public static int cut(int v){
        int cnt = 1;
        boolean[] visited = new boolean[A.length];
        Stack<Integer> stack = new Stack<>();
        stack.push(v);
        visited[v] = true;
        
        while(!stack.isEmpty()){
            int start = stack.pop();
            
            if (A[start].size() != 0){
                for (int i: A[start]){
                    if (!visited[i]){
                        visited[i] = true;
                        stack.push(i);
                        cnt++;
                    }
                }
            }
        }
        return cnt;
        
    }
}