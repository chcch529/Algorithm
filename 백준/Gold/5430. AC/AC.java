import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int front_del;
    static int back_del;
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

            ArrayList<String> nums = new ArrayList<>();

            StringBuilder num = new StringBuilder();
            for (int i = 1; i < str.length(); i++) {
                char ch = str.charAt(i);
                if (ch >= '0' && ch <= '9') {
                    num.append(ch);
                } else {
                    nums.add(num.toString());
                    num = new StringBuilder();
                }
            }

            int cnt = 0;
            front_del = 0;
            back_del = 0;

            for (int i = 0; i < p.length(); i++) {
                char op = p.charAt(i);

                if (op == 'R') {
                    cnt++;
                } else {
                    del(cnt);
                }
            }

            for (int i = n-1; i > n-1 -back_del; i--) {
                nums.remove(i);
            }

            for (int i = 0; i < front_del; i++) {
                nums.remove(0);
            }

            sb.append("[");

            if (nums.isEmpty()) {
                sb.append("]\n");
                continue;
            }

            if (cnt % 2 == 0) {
                for (String s : nums) {
                    sb.append(s).append(",");
                }
            } else {
                for (int i = nums.size() - 1; i >= 0; i--) {
                    sb.append(nums.get(i)).append(",");
                }
            }

            sb.deleteCharAt(sb.length() - 1).append("]\n");



        }

        System.out.println(sb);

    }

    public static void del(int cnt) {
        if (cnt % 2 == 0) { // 앞에서부터 제거
            front_del++;
        } else { // 뒤에서 부터 제거
            back_del++;
        }
    }

}
