import java.util.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {


    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int m = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        Set<Integer> set = new HashSet<>();
        int n = 0;

        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String option = st.nextToken();
            if (st.hasMoreTokens()) {
                n = Integer.parseInt(st.nextToken());
            }

            switch (option) {
                case "add":
                    set.add(n);
                    break;
                case "check":
                    sb.append(set.contains(n) ? 1 : 0).append("\n");
                    break;
                case "remove":
                    set.remove(n);
                    break;
                case "toggle":
                    if (set.contains(n)) {
                        set.remove(n);
                    } else {
                        set.add(n);
                    }
                    break;
                case "all":
                    for (int j = 1; j <= 20; j++) {
                        set.add(j);
                    }
                    break;
                case "empty":
                    set = new HashSet<>();
                    break;
            }
        }
        System.out.print(sb);

    }

}

