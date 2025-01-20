import java.util.*;

class Solution {
    public String solution(String new_id) {
        String answer = "";
        
        // 1단계
        new_id = new_id.toLowerCase();
        
        // 2단계
        StringBuilder step2 = new StringBuilder();
        for (int i=0; i< new_id.length(); i++){
            char n = new_id.charAt(i);
            if ((n >= 'a' && n <= 'z') || (n >= '0' && n <= '9')
                || n == '-' || n == '_' || n == '.'){
                step2.append(n);
            }
        }
        
        // 3
        String step3 = step2.toString();
        while(step3.contains("..")){
            step3 = step3.replace("..",".");
        }

        
        //4
        if (step3.startsWith(".")){
            step3 = step3.substring(1);
        }
        if (step3.endsWith(".")){
            step3 = step3.substring(0,step3.length()-1);
        }
        
        //5
        if (step3.isEmpty()){
            step3 = "a";
        }
        
        //6
        if (step3.length() >= 16){
            step3 = step3.substring(0,15); 
        }
        if (step3.endsWith(".")){
            step3 = step3.substring(0,step3.length()-1);
        }
        
        //7
        while(step3.length() < 3){
            step3 += step3.charAt(step3.length()-1);
        }
        
        
        return step3;
    }
}