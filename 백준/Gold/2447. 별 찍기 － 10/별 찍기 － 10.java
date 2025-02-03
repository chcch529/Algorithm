import java.util.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    static char[][] arr;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        arr = new char[N][N];
        for (int i=0; i<N; i++){
            Arrays.fill(arr[i], '*');
        }

        dfs(0, 0, N);

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<N;i++){
            for (int j=0; j<N; j++){
                sb.append(arr[i][j]);
            }
            sb.append("\n");
        }

        System.out.println(sb);

    }

    public static void dfs(int x, int y, int size){
        if(size == 1){
            return;
        }
        int star = size/3;

        for (int i=x + star; i<x + star*2; i++){
            for (int j= y + star; j<y + star*2; j++){
                arr[i][j] = ' ';
            }
        }

        for (int i=0; i<3; i++){
            for (int j=0; j<3; j++){
                if (i == 1 && j == 1) continue;
                dfs(x + star*i, y + star*j, star);

            }
        }


    }
}