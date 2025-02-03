import java.util.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    static char[] arr;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;
        while ((str = br.readLine()) != null){
            int N = Integer.parseInt(str);

            arr = new char[(int) Math.pow(3,N)];
            Arrays.fill(arr, '-');

            dfs(0, arr.length);

            System.out.println(arr);
        }


    }

    public static void dfs(int start, int end){
        if (end - start == 1) return;

        int len = (end - start)/3;

        for (int i=start+len; i<start + len * 2; i++){
            arr[i] = ' ';
        }


        dfs(start, start+ len);
        dfs(start + len * 2, end);

    }
}