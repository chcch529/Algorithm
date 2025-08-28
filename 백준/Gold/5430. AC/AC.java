import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static ArrayDeque<String> nums;
    static boolean flag;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < T; t++) {
            String p = br.readLine();
            int n = Integer.parseInt(br.readLine());
            String str = br.readLine();

            nums = new ArrayDeque<>();

            String substr = str.substring(1, str.length() - 1);
            if (!substr.isEmpty()) {
                String[] split = substr.split(",");
                for (String s : split) {
                    nums.addLast(s);
                }
            }

            flag = true;
            boolean error = false;

            for (int i = 0; i < p.length(); i++) {
                char op = p.charAt(i);

                if (op == 'R') {
                    flag = !flag;
                } else {
                    error = del();
                }
            }

            if (error) {
                sb.append("error").append("\n");
                continue;
            }

            sb.append("[");

            if (nums.isEmpty()) {
                sb.append("]\n");
                continue;
            }

            if (flag) {
                for (String s : nums) {
                    sb.append(s).append(",");
                }
            } else {
                while (!nums.isEmpty()) {
                    String s = nums.pollLast();
                    sb.append(s).append(",");
                }
            }

            sb.deleteCharAt(sb.length() - 1).append("]\n");

        }

        System.out.println(sb);

    }

    public static boolean del() {

        if (nums.isEmpty()) return true;

        if (flag) { // 앞에서부터 제거
            nums.removeFirst();
        } else { // 뒤에서 부터 제거
            nums.removeLast();
        }

        return false;
    }

}
