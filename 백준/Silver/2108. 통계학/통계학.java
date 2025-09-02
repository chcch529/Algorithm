import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int MAX_IDX = 4000 * 2 + 1;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[MAX_IDX];

        long sum = 0;
        int max_cnt = 0;

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());

            arr[num+4000]++;

            max_cnt = Math.max(max_cnt, arr[num + 4000]);
            sum += num;

            min = Math.min(min, num);
            max = Math.max(max, num);
        }

        StringBuilder sb = new StringBuilder();

        if (n == 1) {
            sb.append(min + "\n");
            sb.append(min + "\n");
            sb.append(min + "\n");
            sb.append(0);
            System.out.println(sb);
            return;
        }

        sb.append((int)Math.round((double) sum / n)).append("\n");

        int mid_idx = n / 2;

        int idx = 0;
        int mid = 0;
        int bin= 0;

        boolean flag = false;

        for (int i=0; i<MAX_IDX; i++) {
            idx += arr[i];
            if (idx > mid_idx) {
                mid = i - 4000;
                mid_idx = n;
            }

            if (arr[i] == max_cnt) {
                if (!flag) {
                    flag = true;
                    bin = i - 4000;
                } else {
                    bin = i - 4000;
                    max_cnt = -1;
                }
            }
        }

        sb.append(mid + "\n").append(bin + "\n");

        sb.append(Math.abs(max - min));

        System.out.println(sb);

    }

}
