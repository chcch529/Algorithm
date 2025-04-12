import java.util.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {

    static ArrayList<int[]> A;
    static ArrayList<Integer>[] beer;

    static boolean[] visited;

    static int penta;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();


        for (int T = 0; T < t; T++) {
            int n = Integer.parseInt(br.readLine());
            int[] temp = new int[2];
            A = new ArrayList<>();
            beer = new ArrayList[n + 2];

            // 집, 편의점, 펜타
            for (int i = 0; i < n + 2; i++) {
                st = new StringTokenizer(br.readLine());
                temp = new int[2];
                temp[0] = Integer.parseInt(st.nextToken());
                temp[1] = Integer.parseInt(st.nextToken());

                A.add(temp);
                beer[i] = new ArrayList<>();

            }
            visited = new boolean[n + 2];
            penta = n+1;



            for (int i = 0; i < n + 1; i++) {
                int x = A.get(i)[0];
                int y = A.get(i)[1];
                for (int j = i + 1; j < n + 2; j++) {
                    int nx = A.get(j)[0];
                    int ny = A.get(j)[1];

                    if (1000 >= (Math.abs(x - nx) + Math.abs(y - ny))) {
                        beer[i].add(j);
                        beer[j].add(i);
                    }
                }
            }

            sb.append(bfs() ? "happy" : "sad").append("\n");

        }

        System.out.println(sb);

    }

    public static boolean bfs() {
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        visited[0] = true;

        while (!q.isEmpty()) {
            int cur = q.poll();

            if (cur == penta) {
                return true;
            }

            for (Integer i : beer[cur]) {
                if (!visited[i]) {
                    q.add(i);
                    visited[i] = true;
                }
            }
        }

        return false;
    }



}

