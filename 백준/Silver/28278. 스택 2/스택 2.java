import java.util.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        Stack<Integer> stack = new Stack<>();

        StringBuilder sb = new StringBuilder();

        for (int i =0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int op = Integer.parseInt(st.nextToken());

            if (op == 1) stack.push(Integer.parseInt(st.nextToken()));
            else if (op == 2) {
                sb.append(stack.isEmpty() ? "-1\n" :
                        stack.pop()+"\n");
            } else if (op ==3) {
                sb.append(stack.size()+"\n");
            } else if (op == 4) {
                sb.append(stack.isEmpty() ? "1\n" : "0\n");
            } else {
                sb.append(stack.isEmpty() ? "-1\n" : stack.peek()+"\n");
            }

        }

        System.out.print(sb);


    }
}