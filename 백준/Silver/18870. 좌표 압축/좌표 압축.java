import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        TreeSet<Integer> set = new TreeSet<>();
        HashMap<Integer, Integer> map = new HashMap<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());

            arr[i] = num;
            set.add(num);
        }

        Integer[] sorted = set.toArray(Integer[]::new);

        for (int i = 0; i < sorted.length; i++) {
            map.put(sorted[i], i);
        }

        StringBuilder sb = new StringBuilder();

        for (int i : arr) {
            sb.append(map.get(i)).append(" ");
        }

        System.out.println(sb);

    }

}

