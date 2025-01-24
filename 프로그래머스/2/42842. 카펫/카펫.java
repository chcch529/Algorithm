class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        
        int area = brown+yellow;
        
        // 가로먼저 찾
        for (int w=(brown/2); w>= 3; w--){
            for (int h=3; h<=w; h++){
                int ga = (brown - 2 * (h-2)) / 2;
                if (( (ga-2) * (h-2)) == yellow && w*h == area){
                    answer[0] = w;
                    answer[1] = h;
                }
                    
            }
        }
        
        return answer;
    }
}