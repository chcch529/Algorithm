import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for (int sc: scoville){
            pq.offer(sc);
        }
        
        while (true){
            int shake = pq.poll();
            
            if (shake >= K) break;
            
            if (!pq.isEmpty()){
                shake += pq.poll()*2;    
                answer++;
            } else {
                return -1;
            }
            
            pq.offer(shake);

        }

        
        return answer;
    }
}