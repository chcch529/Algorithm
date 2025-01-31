import java.util.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] str = br.readLine().toCharArray();
        char[] bomb = br.readLine().toCharArray();

        Stack<Character> stack = new Stack<>();

        int bLen = bomb.length;
        int sLen = str.length;

        for (int i=0; i<sLen; i++){
            stack.push(str[i]);

            if (stack.size() >= bLen){
                boolean check = false;
                for (int j= stack.size() - bLen; j< stack.size(); j++){

                    if (stack.get(j) != bomb[j - (stack.size() - bLen)]){
                        check = true;
                        break;
                    }
                }

                if (!check){
                    for (int j=0; j<bLen; j++){
                        stack.pop();
                    }
                }

            }
        }

        StringBuilder sb = new StringBuilder();

        if (stack.isEmpty()){
            sb.append("FRULA");
        } else {
            for (int i=0; i<stack.size(); i++){
                sb.append(stack.get(i));
            }
        }


        System.out.println(sb);

    }
}