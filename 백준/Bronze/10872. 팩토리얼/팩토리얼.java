import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        if (n == 0) {
            System.out.println(1);
            System.exit(0);
        }
        int total = 1;
        for (int i = 1; i <= n; i++) {
            total *= i;

        }

        System.out.print(total);

    }
}

