import java.util.*;

class Solution {
    public ArrayList<Integer> solution(int[] numbers) {
        int[] answer = {};
        
        Set<Integer> set = new HashSet<>();
        
        int len = numbers.length;
        
        for (int i=0; i<len -1; i++){
            for (int j=i+1; j<len; j++){
                set.add(numbers[i]+numbers[j]);
            }
        }
        
        ArrayList<Integer> re = new ArrayList<>(set);
        Collections.sort(re);
        
        return re;
    }
}