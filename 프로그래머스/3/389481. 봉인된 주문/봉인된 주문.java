import java.util.*;

class Solution {
    public String solution(long n, String[] bans) {
        String answer = "";
        
        Arrays.sort(bans, (str1, str2) -> {
            if (str1.length() == str2.length()){
                return str1.compareTo(str2);
            }
            
            return Integer.compare(str1.length(), str2.length());
            
        });
        
        for (String ban: bans){
            int len = ban.length();
            
            long sum = 0;
            
            for (int i=0; i<len; i++){
                long ascii = ban.charAt(i) - 'a' + 1;
                sum += ascii * (long) Math.pow(26, len-i-1);
            }
            
            if (sum <= n){
                n++;
            } else {
                break;
            }

        }
        
        StringBuilder sb = new StringBuilder();
        
        while (n > 0) {
            long rem = n % 26;
            if (rem == 0) {
                rem = 26;
                n -= 26;
            }
            sb.append((char) ( rem + 'a' - 1 ));
            n /= 26;
        }
        
        
        return sb.reverse().toString();
    }
}