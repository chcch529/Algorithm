import java.util.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String S = br.readLine();

        HashMap<String, Integer> map = new HashMap<>();
        String[] str = "abcdefghijklmnopqrstuvwxyz".split("");

        for (String a: str) {
            map.put(a, -1);
        }

        String[] N = S.split("");

        for(int i = 0; i<N.length; i++){
            if (map.get(N[i]) == -1) map.put(N[i], i);
        }

        for (int i: map.values()){
            System.out.print(i + " ");
        }
        br.close();

    }
}
