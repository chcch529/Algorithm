import java.util.*;

class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        
        int ga = 0;
        int se = 0;
        
        
        for (int i=0; i<sizes.length; i++){
            int temp = 0;
            if (sizes[i][0] < sizes[i][1]) {
                temp = sizes[i][0];
                sizes[i][0] = sizes[i][1];
                sizes[i][1] = temp;
            }
        }
        
        for (int i=0; i<sizes.length; i++){
            for (int j=0; j<2; j++){
                ga = ga < sizes[i][0] ? sizes[i][0] : ga;
                se = se < sizes[i][1] ? sizes[i][1] : se;
            }
        }
        
        return ga*se;
    }
}