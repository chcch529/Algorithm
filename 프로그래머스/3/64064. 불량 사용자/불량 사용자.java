import java.util.*;

class Solution {
    ArrayList<ArrayList<Integer>> ban;
    boolean[] visited;
    Set<Set<Integer>> set;
    public int solution(String[] user_id, String[] banned_id) {
        int answer = 0;
        
        int ban_len = banned_id.length;
        int user_len = user_id.length;
        
        ban = new ArrayList<>();
        visited = new boolean[user_len];
        set = new HashSet<>();
        
        for (int i=0; i<ban_len; i++){
            ban.add(new ArrayList<>());
        }
        
        for (int i=0; i<ban_len; i++){
            for (int j=0; j<user_len; j++){
                if (checkWord(banned_id[i], user_id[j])) ban.get(i).add(j);
            }
        }
        
        dfs(0);
        

        return set.size();
    }
    
    public void dfs(int idx){
        
        if (idx == ban.size()){
            Set<Integer> com = new HashSet<>();
            for (int i=0; i<visited.length; i++){
                if(visited[i]) com.add(i);
            }
            set.add(com);
            return;
        }
        
        
        for (int i: ban.get(idx)){
            if(!visited[i]){
                visited[i] = true;
                dfs(idx +1);
                visited[i] = false;
            }
        }
    }
    
    public boolean checkWord(String ban, String name){
        int len = ban.length();
        
        if (len != name.length()) return false;
        
        
        for (int i=0; i<len; i++){
            if (ban.charAt(i) != '*' && ban.charAt(i) != name.charAt(i)) return false;
        }
        
        return true;
    }
}

