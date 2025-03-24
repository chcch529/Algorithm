import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int i: tangerine){
            map.put(i, map.getOrDefault(i, 0)+1);
        }
        
        ArrayList<Integer> list = new ArrayList<>(map.values());
        list.sort(Comparator.reverseOrder());
        
        int sum = 0;
        
        for (int i: list){
            sum += i;
            answer++;
            if (sum >= k){
                break;
            }
        }
        
        
        
        return answer;
    }
}