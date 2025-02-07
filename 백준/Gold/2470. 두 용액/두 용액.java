import java.util.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;



public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] A = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i=0; i<N; i++){
            A[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(A);

        int left = 0;
        int right = N -1;

        int num1 = 0, num2 = 0;
        int sum = Integer.MAX_VALUE;

        int temp = 0;
        while (left<right){
            temp = A[left] + A[right];

            if (Math.abs(A[left] + A[right]) < Math.abs(sum)){
                num1 = A[left];
                num2 = A[right];

                sum = A[left] + A[right];
                temp = sum;
            }

            if (temp > 0){
                right--;
            } else if (temp < 0) {
                left++;
            } else {
                break;
            }
        }


        System.out.println(num1 +" " + num2);
    }


}
