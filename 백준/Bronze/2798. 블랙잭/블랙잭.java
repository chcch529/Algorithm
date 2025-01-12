import java.util.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        ArrayList<Integer> cards = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        while (st.hasMoreTokens()){
            cards.add(Integer.parseInt(st.nextToken()));
        }

        int max=0;
        for (int i =0; i<N -2;i++){
            for (int j=i+1; j<N-1; j++){
                for (int k=j+1; k<N; k++){
                    int sum = cards.get(i) + cards.get(j) + cards.get(k);
                    if (sum <= M) max = Math.max(sum, max);
                }
            }

        }

        System.out.print(max);


    }
}