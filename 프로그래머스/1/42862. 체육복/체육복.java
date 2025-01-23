import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        
        int[] stu = new int[n];
        
        // lost: -1 reserve: 1 (나머지랑 있었는데 도난: 0)
        for (int i: lost){
            stu[i-1] -= 1;
        }
        for (int i: reserve){
            stu[i-1] += 1;
        }
        
        for (int i: stu){ // 걍 있는애들
            if (i == 0){
                answer++;
            }
        }
        
        for (int i = 0 ; i<n; i++){
            if (stu[i] == 1){
                if (i >= 1 && stu[i-1] == -1){ // 노나줌 -> +2 
                    stu[i] = 0;
                    stu[i-1] = 0;
                    answer += 2; 
                } else if (i < n-1 && stu[i+1] == -1){ // 노나줌 -> +2 
                    stu[i] = 0;
                    stu[i+1] = 0;
                    answer += 2;
                } else{ // 있는데 못줌 -> +1
                    answer++;
                }
            }
        }
        
        
        return answer;
    }
}
