import java.util.*;

class Solution {

    public int solution(int[] people, int limit) {
        int answer = 0;
        boolean[] visited = new boolean[people.length];
        
        
        Arrays.sort(people);
        
        int l=0, r=people.length -1;
        
        while (l < r){
            if (people[l] + people[r] > limit){
                answer++;
                visited[r--] = true;
            } else {
                answer++;
                visited[l++] = true;
                visited[r--] = true;
            }
        }
        
        for (boolean rest: visited){
            if (!rest){
                answer++;
            }
        }
        
        
        
        return answer;
    }
    
}