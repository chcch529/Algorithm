import java.util.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        Stack<Integer> stack = new Stack<>();
        String option;
        int X = 0;

        StringBuilder sb = new StringBuilder();

        for (int i =0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            option = st.nextToken();
            if (st.hasMoreTokens()) X = Integer.parseInt(st.nextToken());
            if (option.equals("push")) stack.push(X);
            else if (option.equals("pop")) sb.append((stack.isEmpty() ? -1 : stack.pop())+"\n");
            else if (option.equals("size")) sb.append(stack.size()+"\n");
            else if (option.equals("empty")) sb.append((stack.isEmpty() ? 1 : 0) +"\n" );
            else if (option.equals("top")) sb.append((stack.isEmpty() ? -1 : stack.peek() )+ "\n");

        }

        System.out.print(sb);

    }
}