import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[][] grid = new char[5][15];

        for(int i = 0 ; i<5; i++){
            String str = br.readLine();
            for(int j = 0; j<str.length(); j++){
                grid[i][j] = str.charAt(j);

            }
        }
        br.close();
        StringBuilder sb = new StringBuilder();

        for(int i = 0 ; i<15; i++){
            for(int j = 0; j<5; j++){
                if (grid[j][i] != 0) sb.append(grid[j][i] );
            }
        }

        System.out.println(sb);

    }
}
