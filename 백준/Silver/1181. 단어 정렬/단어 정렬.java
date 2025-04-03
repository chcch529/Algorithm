import java.util.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Set<String> set = new HashSet<>();

        for (int i = 0; i < n; i++) {
            set.add(br.readLine());
        }

        List<String> arr = new ArrayList<>(set);

        Collections.sort(arr, (str1, str2) -> {
            int len1 = str1.length();
            int len2 = str2.length();
            if (len1 == len2) {
                return str1.compareTo(str2);
            }
            return len1 - len2;
        });

        StringBuilder sb = new StringBuilder();


        for (String s : arr) {
            sb.append(s).append("\n");
        }

        System.out.println(sb);

    }
}

