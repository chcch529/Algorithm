import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] arr = new int[9];

        int max = 0;
        int index = 9;

        for (int i =0; i<9; i++){
            arr[i] = Integer.parseInt(br.readLine());
            if (arr[i] > max){
                max = arr[i];
                index = i;
            }
        }

        System.out.printf(
                "%d%n%d",
                max, index+1
        );

    }
}
