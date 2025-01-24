import java.util.*;

class Solution {
    static char[] num;
    static boolean[] visited;
    static Set<Integer> cnt;
    public int solution(String numbers) {
        int answer = 0;
        
        num = numbers.toCharArray();
        visited = new boolean[num.length];
        cnt = new HashSet<>();
        
        for (int i=1; i<=num.length; i++){
            DFS("", i);
            
        }

        return cnt.size();
    }
    
    public static void DFS(String now, int len){
        if (len == now.length()){
            int check = Integer.parseInt(now);
        
            if(isPrime(check)){
                cnt.add(check);
            }
        }
        
        for (int i=0; i<num.length; i++){
            if (!visited[i]){
                visited[i] = true;
                DFS(now + num[i], len);
                visited[i] = false;
            }

        }
        
    }
    
    public static boolean isPrime(int v) {
        if (v < 2) {
            return false;
        }
        
        for (int i = 2; i * i <= v; i++) {
            if (v % i == 0) {
                return false;
            }
        }
        return true;
    }
}