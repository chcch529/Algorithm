import java.util.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Map<String, Integer> map = new HashMap<>();
        List<String> answer = new ArrayList<>();

        for (int i = 0; i < n + m; i++) {
            String s = br.readLine();
            map.put(s, map.getOrDefault(s, 0) + 1);
            if (map.get(s) == 2) {
                answer.add(s);
            }
        }

        Collections.sort(answer);

        StringBuilder sb = new StringBuilder();
        sb.append(answer.size()).append("\n");

        for (String s : answer) {
            sb.append(s).append("\n");
        }
        System.out.println(sb);

    }


}