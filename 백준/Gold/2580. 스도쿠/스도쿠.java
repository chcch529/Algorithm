import java.util.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    static int[][] grid = new int[9][9];

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        for (int i=0; i<9; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j=0; j<9; j++){
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        solve(0,0);

        StringBuilder sb= new StringBuilder();

        for (int i = 0; i<9; i++){
            for (int j = 0; j< 9; j++){
                sb.append(grid[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);

    }

    public static boolean solve(int row, int col){
        if (col == 9){
            return solve(row +1, 0);
        }
        if (row == 9){
            // 스도쿠 해결
            return true;
        }

        if (grid[row][col] != 0){
            return solve(row, col+1);
        }

        for (int num =1; num <= 9; num++){
            if (isValid(row, col, num)){
                // 중복 없으면 일단 넣고
                grid[row][col] = num;

                // 진행 ㄱㄱ
                // 끝까지 완성되면 true 반환되어 종료될 거고
                if (solve(row, col+1)){
                    return true;
                }
                // false가 왔으면 해당 num 답 아니니까 다시 0
                grid[row][col] = 0;
            }

        }
        return false;
    }

    public static boolean isValid(int x, int y, int num){
        for (int i = 0; i<9; i++){
            // 중복 체크
            if (grid[x][i] == num || grid[i][y] == num){
                return false;
            }
        }

        int startX = (x / 3) * 3;
        int startY = (y / 3) * 3;

        for (int i = startX; i < startX+3; i++){
            for (int j = startY; j < startY+3; j++){
                if (grid[i][j] == num){
                    return false;
                }
            }
        }

        return true;
    }



}
