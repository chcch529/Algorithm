import java.util.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    static int l, c;
    static String[] chars;
    static boolean[] visited;
    static StringBuilder sb;

    static String[] ae = {"a", "e", "i", "o", "u"};

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        l = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        chars = new String[c];
        visited = new boolean[c];
        sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < c; i++) {
            chars[i] = st.nextToken();
        }

        Arrays.sort(chars);

        back(0,0);

        System.out.println(sb);
    }

    public static void back(int start, int cnt) {
        if (cnt == l) {
            pw();
            return;
        }

        for (int i = start; i < c; i++) {
            if (!visited[i]) {
                visited[i] = true;
                back(i + 1, cnt + 1);
                visited[i] = false;
            }
        }
    }

    public static void pw() {
        StringBuilder aeiou = new StringBuilder();
        boolean check = false;
        
        int cnt = 0;
        for (int i = 0; i < c; i++) {
            if (visited[i]) {
                boolean cntCheck = false;
                for (String s : ae) {
                    if (chars[i].equals(s)) {
                        check = true;
                        cntCheck = true;
                    }
                }

                if (!cntCheck) {
                    cnt++;
                }

                aeiou.append(chars[i]);
            }
        }
        if (check && cnt >=2) {
            sb.append(aeiou).append("\n");
        }

    }

}

