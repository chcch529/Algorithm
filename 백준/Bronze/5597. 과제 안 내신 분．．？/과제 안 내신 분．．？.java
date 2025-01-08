import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        ArrayList<Integer> arr = new ArrayList<>();


        for (int i = 1; i<31;i++){
            arr.add(i);
        }

        int temp = 0;

        for (int a =0; a<28; a++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken());

            arr.remove((Integer) i);

        }

        Collections.sort(arr);

        for(Integer i: arr){
            System.out.println(i);
        }

    }
}
