import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 0;
    
        Map<String, ArrayList<String>> map = new HashMap<>();
        
        for (int i =0; i< clothes.length; i++){
            ArrayList<String> list = map.getOrDefault(clothes[i][1], new ArrayList<String>());
            
            list.add(clothes[i][0]);
            
            map.put(clothes[i][1], list);
        }
        
        int temp = 1;
        for (String key: map.keySet()){
            temp = temp* (map.get(key).size() +1);

        }
        
        answer += temp -1;

        
        System.out.println(map);
        
        return answer;
    }
}