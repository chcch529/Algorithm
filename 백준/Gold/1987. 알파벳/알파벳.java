import java.util.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {

    static char[][] board;
    static boolean[] alpha = new boolean[26];
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static int max = 0;
    static int r, c;
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        ArrayList<Character> route = new ArrayList<>();
        board = new char[r][c];

        for (int i = 0; i < r; i++) {
            String str = br.readLine();
            for (int j = 0; j < c; j++) {
                board[i][j] = str.charAt(j);
            }
        }

        alpha[board[0][0] - 'A'] = true;

        dfs(0,0, 1);

        System.out.println(max);
    }

    static void dfs(int x, int y, int cnt) {
        max = Math.max(max, cnt);

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && nx < r && ny >= 0 && ny < c) {
                int next = board[nx][ny] - 'A';
                if (!alpha[next]) {
                    alpha[next] = true;
                    dfs(nx, ny, cnt + 1);
                    alpha[next] = false;
                }
            }
        }



    }

}

