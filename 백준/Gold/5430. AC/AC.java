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

            int del_cnt = 0;
            for (int i = 0; i < p.length(); i++) {
                if (p.charAt(i) == 'D') del_cnt++;
            }

            if (del_cnt > n) {
                sb.append("error").append("\n");
                continue;
            }

            nums = new ArrayDeque<>();

            StringBuilder num = new StringBuilder();
            for (int i = 1; i < str.length(); i++) {
                char ch = str.charAt(i);
                if (ch >= '0' && ch <= '9') {
                    num.append(ch);
                } else {
                    nums.addLast(num.toString());
                    num = new StringBuilder();
                }
            }

            flag = true;

            for (int i = 0; i < p.length(); i++) {
                char op = p.charAt(i);

                if (op == 'R') {
                    flag = !flag;
                } else {
                    del();
                }
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

    public static void del() {
        if (flag) { // 앞에서부터 제거
            nums.removeFirst();
        } else { // 뒤에서 부터 제거
            nums.removeLast();
        }
    }

}
