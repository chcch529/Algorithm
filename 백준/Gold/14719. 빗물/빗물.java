import java.util.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    static int[][] board;
    static boolean[][] visited;

    static int h, w, total;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        h = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());

        board = new int[h][w];
        visited = new boolean[h][w];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < w; i++) {
            int n = Integer.parseInt(st.nextToken());
            for (int j = 0; j < n; j++) {
                board[j][i] = 1;
            }
        }

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (!visited[i][j] && board[i][j] == 1) {
                    dfs(i, j);
                }
            }
        }

        System.out.println(total);
    }

    private static void dfs(int x, int y) {
        visited[x][y] = true;
        int cnt = 0;
        int ny = y;

        while (true) {
            ny += 1;


            if (ny < w) {
                if (board[x][ny] == 0) {
                    visited[x][ny] = true;
                    cnt++;
                } else {
                    total += cnt;
                    break;
                }
            } else {
                break;
            }
        }
    }

}