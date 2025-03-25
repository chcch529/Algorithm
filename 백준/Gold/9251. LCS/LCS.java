import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str1 = br.readLine();
        String str2 = br.readLine();


        System.out.println(dp(str1, str2));
    }

    public static int dp(String str1, String str2) {
        int len1 = str1.length();
        int len2 = str2.length();
        int[][] opt = new int[len1+ 1][len2 +1];

        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if (str1.charAt(i-1) == str2.charAt(j-1)) {
                    opt[i][j] = opt[i - 1][j - 1] + 1;
                } else {
                    opt[i][j] = Math.max(opt[i-1][j], opt[i][j-1]);
                }
            }
        }
        return opt[len1][len2];

    }
}