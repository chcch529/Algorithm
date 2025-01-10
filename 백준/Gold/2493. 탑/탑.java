import java.util.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());


        StringTokenizer st = new StringTokenizer(br.readLine());
        Stack<Integer> stack = new Stack<>();
        int[] tops = new int[N];
        int[] result = new int[N];

        for (int i = 0; i < N; i++){
            tops[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i<N; i++){
            while (!stack.isEmpty() && tops[stack.peek()] < tops[i]) stack.pop();

            if (!stack.isEmpty() && tops[stack.peek()] >= tops[i]) result[i] = stack.peek()+1;

            stack.push(i);
        }

        StringBuilder sb = new StringBuilder();
        for (int num: result){
            sb.append(num +" ");
        }

        System.out.print(sb);

    }
}