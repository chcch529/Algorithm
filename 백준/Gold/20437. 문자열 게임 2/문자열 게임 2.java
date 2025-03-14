import java.util.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int t = 0; t < T; t++) {
            String w = br.readLine();
            int k = Integer.parseInt(br.readLine());
            
            if (k == 1) {
                sb.append("1 1\n");
                continue;
            }
            
            
            Map<Character, ArrayList<Integer>> map = new HashMap<>();

            int len = w.length();
            int result1 = len + 1;
            int result2 = -1;

            for (int i = 0; i < len; i++) {
                char c = w.charAt(i);

                if (map.containsKey(c)) {
                    ArrayList<Integer> current = map.get(c);
                    current.add(i);

                    if (current.size() == k) {
                        int temp = current.get(k - 1) - current.get(0) + 1;
                        result1 = Math.min(temp, result1);
                        current.remove(0);

                        result2 = Math.max(temp, result2);
                    }
                    map.put(c, current);

                } else {
                    ArrayList<Integer> current = new ArrayList<>();
                    current.add(i);
                    
                    map.put(c, current);
                }
            }



            if (result1 != len + 1 && result2 != -1) {
                sb.append(result1).append(" ").append(result2);
            } else {
                sb.append(-1);
            }
            sb.append("\n");
        }

        System.out.println(sb);

    }


}