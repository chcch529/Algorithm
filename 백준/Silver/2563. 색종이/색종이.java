import java.util.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        boolean[][] paper = new boolean[100][100];
        int total = 0;

        for(int i = 0 ; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int X = Integer.parseInt(st.nextToken());
            int Y = Integer.parseInt(st.nextToken());
            for(int j = 0; j<10; j++){
                for (int k =0; k<10; k++){
                    if (!paper[X+j][Y+k]) {
                        paper[X + j][Y + k] = true;
                        total++;
                    }
                }
            }
        }
        br.close();
        

        System.out.println(total);

    }
}
