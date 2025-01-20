import java.util.*;

class Solution {
    public ArrayList<int[]> solution(int[][] data, String ext, int val_ext, String sort_by) {
        
        Map<String, Integer> map = new HashMap<>();
        map.put("code", 0); map.put("date", 1);
        map.put("maximum", 2); map.put("remain", 3);
        
        int n = map.get(ext);
        
        ArrayList<int[]> temp = new ArrayList<>();
        
        for (int i = 0; i < data.length; i++) {
            if (data[i][n] < val_ext) {
                temp.add(data[i]);
            }
        }
        
        int s = map.get(sort_by);
        
        temp.sort((o1, o2) -> {
            return o1[s]-o2[s];
        });
        
        return temp;
    }
}