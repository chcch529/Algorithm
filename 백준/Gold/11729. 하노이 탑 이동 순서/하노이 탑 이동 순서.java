import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    static StringBuilder sb= new StringBuilder();

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());



        int cnt = ((int) Math.pow(2,N))-1;
        sb.append(cnt).append("\n");
        hanoi(N, 1, 2, 3);

        System.out.println(sb);

    }

    public static void hanoi(int n, int start, int mid, int end){
        if (n == 1){
            sb.append(start +" "+ end).append("\n");
            return;
        }

        hanoi(n-1, start,end,mid);

        sb.append(start + " " + end).append("\n");

        hanoi(n-1, mid, start, end);

    }

}