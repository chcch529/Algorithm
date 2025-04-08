import java.util.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {


    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            int Q = Integer.parseInt(br.readLine());
            TreeMap<Long, Integer> treemap = new TreeMap<>();

            for (int q = 0; q < Q; q++) {
                st = new StringTokenizer(br.readLine());
                char op = st.nextToken().charAt(0);
                long n = Integer.parseInt(st.nextToken());

                if (op == 'I') {
                    treemap.put(n, treemap.getOrDefault(n, 0) + 1);
                } else {
                    if (!treemap.isEmpty()) {
                        if (n == -1) {
                            int tmp = treemap.firstEntry().getValue();
                            if (tmp >= 2) {
                                treemap.put(treemap.firstKey(), tmp - 1);
                            } else {

                                treemap.pollFirstEntry();
                            }
                        } else {
                            int tmp = treemap.lastEntry().getValue();
                            if (tmp >= 2) {
                                treemap.put(treemap.lastKey(), tmp - 1);
                            } else {

                                treemap.pollLastEntry();
                            }


                        }
                    }
                }

            }


            if (treemap.isEmpty()) {
                sb.append("EMPTY");
            } else {
                sb.append(treemap.lastKey()).append(" ").append(treemap.firstKey());
            }
            sb.append("\n");

        }

        System.out.println(sb);

    }

}

