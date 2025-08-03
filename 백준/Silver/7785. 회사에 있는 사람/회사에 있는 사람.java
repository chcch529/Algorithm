import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        HashSet<String> office = new HashSet<>();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            String name = st.nextToken();
            String inout = st.nextToken();

            if (inout.equals("enter")) {
                office.add(name);
            } else {
                office.remove(name);
            }
        }

        ArrayList<String> list = new ArrayList<>(office);

        Collections.sort(list, Collections.reverseOrder());

        StringBuilder sb = new StringBuilder();

        for (String s : list) {
            sb.append(s).append("\n");
        }
        System.out.println(sb);

    }

}