import java.util.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        int Q = Integer.parseInt(br.readLine());

        int len = str.length();

        StringBuilder sb= new StringBuilder();


        int[][] all = new int[len +1][26];

        for (int i=0; i<len; i++){
            int c = str.charAt(i) - 'a';

            for (int j=0; j<26; j++){
                all[i +1][j] = all[i][j];
            }

            all[i+1][c]++;

        }

        for (int q = 0; q<Q; q++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            String a = st.nextToken();
            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());

            int c = a.charAt(0) - 'a';

            int answer = all[r +1][c] - all[l][c];

            sb.append(answer).append("\n");
        }


        System.out.println(sb);
    }


}
