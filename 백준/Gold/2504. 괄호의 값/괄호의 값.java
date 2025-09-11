import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        int len = str.length();

        Stack<Character> stack = new Stack<>();

        int tmp = 1;
        int ans = 0;

        for (int i = 0; i < len; i++) {
            char c = str.charAt(i);

            if (c == '(') {
                stack.add(c);
                tmp *= 2;

            } else if ( c == '[') {
                stack.add(c);
                tmp *= 3;

            } else {
                if (c == ')') {
                    if (stack.isEmpty() || stack.peek() != '(') {
                        System.out.println(0);
                        return;

                    } else if (str.charAt(i - 1) == '(') {
                        ans += tmp;

                    }
                    stack.pop();
                    tmp /= 2;
                } else if (c == ']') {
                    if (stack.isEmpty() || stack.peek() != '[') {
                        System.out.println(0);
                        return;

                    } else if (str.charAt(i - 1) == '[') {
                        ans += tmp;

                    }
                    stack.pop();
                    tmp /= 3;
                }

            }
        }

        System.out.println((!stack.isEmpty()) ? 0 : ans);
    }

}
