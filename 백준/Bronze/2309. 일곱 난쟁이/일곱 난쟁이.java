import java.util.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] nanjang = new int[9];

        int sum = 0;
        for (int i =0; i<9; i++){
            nanjang[i] = Integer.parseInt(br.readLine());
            sum += nanjang[i];
        }

        boolean done = false;
        for (int i=0; i<8; i++){
            for (int j=i+1; j<9; j++){
                if (sum - nanjang[i] - nanjang[j] == 100){
                    nanjang[i] = 0;
                    nanjang[j] = 0;
                    done = true;
                }
                if (done) break;
            }
            if (done) break;
        }

        Arrays.sort(nanjang);

        StringBuilder sb = new StringBuilder();

        for (int i: nanjang){
            if( i != 0){
                sb.append(i).append("\n");
            }
        }

        System.out.println(sb);

    }


}
