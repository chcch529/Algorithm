import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    static int n;
    static int cnt;
    static boolean[] col;
    static boolean[] rightDown;
    static boolean[] leftDown;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        col = new boolean[n];
        rightDown = new boolean[2 * n - 1]; // (row + col)
        leftDown = new boolean[2 * n - 1]; // (row - col + n - 1)

        queen(0);

        System.out.println(cnt);

    }

    public static void queen(int row) {

        if (row == n) {
            cnt++;
            return;
        }

        for (int i = 0; i < n; i++) {
            if (col[i] || rightDown[row + i] || leftDown[row - i + n - 1]) {
                continue;
            }

            col[i] = true;
            rightDown[row + i] = true;
            leftDown[row - i + n - 1] = true;

            queen(row + 1);

            col[i] = false;
            rightDown[row + i] = false;
            leftDown[row - i + n - 1] = false;

        }

    }

}