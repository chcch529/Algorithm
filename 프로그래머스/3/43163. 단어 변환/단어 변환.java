import java.util.*;

class Word{
    int depth;
    String word;
    
    Word(int depth, String word){
        this.depth = depth;
        this.word = word;
    }
}

class Solution {
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        
        int len = words.length;
        boolean[] visited = new boolean[len];
        Queue<Word> q = new LinkedList<>();
        q.add(new Word(0, begin));
        
        while (!q.isEmpty()){
            Word cur = q.poll();
            
            for (int i=0; i<len; i++){
                if(cur.word.equals(target)) return cur.depth;
                if(!visited[i] && checkWord(cur.word, words[i])){
                    visited[i] = true;
                    q.add(new Word(cur.depth+1, words[i]));
                }
            }
        }
        
        return 0;
    
    }
    
    public boolean checkWord(String str1, String str2){
        
        int cnt = 0;
        int len = str1.length();
        
        for (int i=0; i<len; i++){
            if( str1.charAt(i) == str2.charAt(i)) cnt++;
        }
        
        if (cnt == len-1) return true;
        
        return false;
        
    }
}