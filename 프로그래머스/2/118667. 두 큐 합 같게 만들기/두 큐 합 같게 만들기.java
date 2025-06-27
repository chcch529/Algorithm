import java.util.*;

class Solution {

    public long solution(int[] queue1, int[] queue2) {

        long sum1 = Arrays.stream(queue1).sum();
        long sum2 = Arrays.stream(queue2).sum();

        long sum = sum1+sum2;

        if (sum %2 == 1) return -1;

        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();

        for (int i= 0; i < queue1.length; i++){
            q1.add(queue1[i]);
            q2.add(queue2[i]);
        }

        long cnt = 0;

        while(!q1.isEmpty() && !q2.isEmpty()){
            int pop = 0;

            if (sum1 > sum2){
                pop = q1.poll();
                q2.add(pop);
                sum1 -= pop;
                sum2 += pop;
            } else if (sum1 < sum2){
                pop = q2.poll();
                q1.add(pop);

                sum2 -= pop;
                sum1 += pop;
            } else {
                return cnt;
            }

            cnt++;
            if (cnt >(long) queue1.length *3) return -1;
        }

        return -1;

    }
}