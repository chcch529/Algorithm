import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        
        
        List<String> nums = new ArrayList<>();
        
        for (int num: numbers){
            nums.add(String.valueOf(num));
        }
        
        
        Comparator<String> comparator = new Comparator<String>() {
            @Override
            public int compare(String a, String b){
                String ab = a+b;
                String ba = b+a;
                return ba.compareTo(ab);
            }
        };
        
        nums.sort(comparator);
        
        if (nums.get(0).equals("0")) return "0";
        
        StringBuilder sb = new StringBuilder();
        
        for (String s: nums){
            sb.append(s);
        }
        
        return sb.toString();
    }
}