import java.util.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    static int n;
    static int m;
    static ArrayList<Long> card;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        card = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            Long a = Long.parseLong(st.nextToken());

            card.add(a);
        }

        for (int i = 0; i < m; i++) {
            small();
        }

        Long sum = card.stream().mapToLong(Long::longValue).sum();

        System.out.println(sum);
    }

    public static void small() {

        Collections.sort(card);

        Long first = card.get(0);
        Long second = card.get(1);

        card.set(0, first + second);
        card.set(1, first + second);

    }
}