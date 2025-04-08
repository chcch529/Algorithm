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
        TreeMap<Integer, TreeSet<Integer>> treemap = new TreeMap<>();
        TreeMap<Integer, Integer> solved = new TreeMap<>();

        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            int P = Integer.parseInt(st.nextToken());
            int L = Integer.parseInt(st.nextToken());

            treemap.computeIfAbsent(L, k -> new TreeSet<>()).add(P);
            solved.put(P, L);
        }

        int Q = Integer.parseInt(br.readLine());
        for (int q = 0; q < Q; q++) {
            st = new StringTokenizer(br.readLine());
            String op = st.nextToken();
            int P = Integer.parseInt(st.nextToken());
            if (op.equals("add")) {
                int L =Integer.parseInt(st.nextToken());

                treemap.computeIfAbsent(L, k -> new TreeSet<>()).add(P);
                solved.put(P, L);
                continue;

            }

            if (op.equals("solved")) {
                int solvedL = solved.get(P);

                TreeSet<Integer> integerTreeSet = treemap.get(solvedL);
                integerTreeSet.remove(P);
                if (integerTreeSet.isEmpty()) {
                    treemap.remove(solvedL);
                } else {

                    treemap.put(solvedL, integerTreeSet);
                }
            } else {
                if (P == -1) {
                    TreeSet<Integer> value = treemap.firstEntry().getValue();
                    sb.append(value.first());

                } else {
                    TreeSet<Integer> value = treemap.lastEntry().getValue();
                    sb.append(value.last());

                }
                sb.append("\n");
            }

        }

        System.out.println(sb);

    }

}

