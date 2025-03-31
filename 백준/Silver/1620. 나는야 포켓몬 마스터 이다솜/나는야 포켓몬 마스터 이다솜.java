import java.util.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {


    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Map<String, Integer> dogam = new HashMap<>();
        Map<Integer, String> gamdo = new HashMap<>();

        for (int i = 1; i <= n; i++) {
            String name = br.readLine();
            dogam.put(name, i);
            gamdo.put(i, name);
        }

        for (int i = 0; i < m; i++) {
            String op = br.readLine();
            if (49 <= op.charAt(0) && 57 >= op.charAt(0)) {
                sb.append(gamdo.get(Integer.parseInt(op)));
            } else {
                sb.append(dogam.get(op));
            }
            sb.append("\n");
        }

        System.out.print(sb);

    }

}