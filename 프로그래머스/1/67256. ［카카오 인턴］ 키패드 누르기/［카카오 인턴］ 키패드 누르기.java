import java.awt.*;
import java.util.*;

class Solution {
    public StringBuilder solution(int[] numbers, String hand) {
        StringBuilder sb = new StringBuilder();
        
        Point l = new Point(3,0);
        Point r = new Point(3,2);
        
        int[][] grid = {{1,2,3},{4,5,6},{7,8,9},{0,0,0}};
        Map<Integer, Integer> map = new HashMap<>();
        map.put(1,0); map.put(2,0); map.put(3,0);
        map.put(4,1); map.put(5,1); map.put(6,1);
        map.put(7,2); map.put(8,2); map.put(9,2);
        map.put(0,3);
        
        for (int i=0; i<numbers.length; i++){
            switch (numbers[i]){
                case 1,4,7:
                    sb.append("L");

                    l.x = map.get(numbers[i]);
                    l.y = 0;
                    break;
                case 3,6,9:
                    sb.append("R");
                    
                    r.x = map.get(numbers[i]);
                    r.y = 2;
                    break;
                default:
                    Point n = new Point(map.get(numbers[i]), 1);
                    
                    int leftD = Math.abs(n.x - l.x) + Math.abs(n.y - l.y);
                    int rightD = Math.abs(n.x - r.x) + Math.abs(n.y - r.y);
                    
                    if (leftD > rightD) {
                        sb.append("R");
                        r = n;
                    } else if (leftD < rightD) {
                        sb.append("L");
                        l = n;
                    } else {
                        if (hand.equals("right")){
                            sb.append("R");
                            r = n;
                        } else{
                            sb.append("L");
                            l = n;
                        }
                    }
                    break;
            }
        }
        
        return sb;
    }
}