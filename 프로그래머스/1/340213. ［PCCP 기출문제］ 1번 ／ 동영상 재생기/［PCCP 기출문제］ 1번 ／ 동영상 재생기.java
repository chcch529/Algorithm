import java.util.*;

class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        String answer = "";
        
        int current =0, end=0, op_s=0, op_e=0;
        

        current += Integer.parseInt(pos.split(":")[0])* 60;
        end += Integer.parseInt(video_len.split(":")[0])* 60;
        op_s += Integer.parseInt(op_start.split(":")[0])* 60;
        op_e += Integer.parseInt(op_end.split(":")[0])* 60;
        
        current += Integer.parseInt(pos.split(":")[1]);
        end += Integer.parseInt(video_len.split(":")[1]);
        op_s += Integer.parseInt(op_start.split(":")[1]);
        op_e += Integer.parseInt(op_end.split(":")[1]);

        
        if (current >= op_s && current <= op_e){
                current = op_e;
        }
        
        for (String c: commands){
            
            
            if (c.equals("next")){
                current += 10;
                    
                if (current > end){
                    current = end;
                }
                
            } else if (c.equals("prev")){
                current -= 10;
                

                if (current < 0){
                    current = 0;
                }
                
            }
            if (current >= op_s && current <= op_e){
                current = op_e;
            }
                    
        }
        if (current/ 60 < 10){
            answer += "0" + current/60 + ":";
        } else {
            answer +=  current/60 + ":";
        }
        if (current % 60 < 10){
            answer += "0" + current% 60;
        } else {
            answer += current% 60;
        }

        
        return answer;
    }
}