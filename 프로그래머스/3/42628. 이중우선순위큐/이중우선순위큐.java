import java.util.*;

class Solution {
    TreeMap<Integer, Integer> map;
    public int[] solution(String[] operations) {
        int[] answer = {};
        
        map = new TreeMap<>();
        
        for(String oper : operations){
            String[] str = oper.split(" ");
            
            int n = Integer.parseInt(str[1]);
            
            if(str[0].equals("I")){
                insert(n);
            } else {
                if (!map.isEmpty()){
                    del(n);
                }
            }
        }
        
        if(map.isEmpty()) return new int[]{0,0};
        
        int min = map.firstKey();
        int max = map.lastKey();
        
        return new int[]{max,min};
    }
    
    public void insert(int n){
        
        if (map.containsKey(n)){
            map.put(n, map.get(n) + 1);
            
            return;
        }
        
        map.put(n, 1);
    }
    
    public void del(int n){
        
        if(n < 0){
    
            int min = map.firstKey();

            if (map.get(min) > 1){
                map.put(min, map.get(min) - 1);

                return;
            }

            map.pollFirstEntry();
            return;
        } 
        
        int max = map.lastKey();
        
        if (map.get(max) > 1){
            map.put(max, map.get(max) - 1);
            
            return;
        }
        
        map.pollLastEntry();
        
    }

}