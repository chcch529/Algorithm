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
        int[] sum = new int[len+1];
        int[] cnt = new int[len];

        StringBuilder sb= new StringBuilder();

        for (int q = 0; q<Q; q++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            String a = st.nextToken();
            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());

            for (int i = 0; i<len; i++){
                if (str.charAt(i) == a.charAt(0)){
                    cnt[i] = 1;
                }
                sum[i+1] = sum[i] + cnt[i];
            }

            int answer = sum[r +1] - sum[l];

            sb.append(answer).append("\n");

            cnt = new int[len];

        }


        System.out.println(sb);
    }


}
