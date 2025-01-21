import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String board = br.readLine();

        String[] array = board.split("\\.+");

        String[] ab = new String[array.length];

        for (int i =0 ; i< array.length; i++){
            if (array[i].length() % 2 != 0){
                System.out.println(-1);
                return;
            } else {
                ab[i] = "";
                while (array[i].length() >= 4){
                    ab[i] += "AAAA";

                    array[i] = array[i].replaceFirst("XXXX", "");
                }

                if (array[i].length() == 2){
                    ab[i] += "BB";
                }

            }
        }

        for (String s: ab){
            int n = s.length();
            String x = "X".repeat(n);

            board = board.replaceFirst(x, s);
        }

        System.out.println(board);

    }
}