import java.util.*;
import java.io.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        Queue<int []> queue = new LinkedList<>();
        PriorityQueue<Integer> pri = new PriorityQueue<>(Collections.reverseOrder());

        int max = 0;
        for (int j =0; j<priorities.length; j++) {
            queue.offer(new int[] {j, priorities[j]});
            pri.offer(priorities[j]);
        }

        while (!queue.isEmpty()){

            int[] now = queue.remove();

            if (now[1] == pri.peek()) {
                pri.poll();
                answer++;

                if (now[0] == location) break;
            } else {
                queue.offer(now);
            }


        }
        
        return answer;
    }
}