package P8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P8_7 {

    private static long[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stk = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(stk.nextToken());
        int r = Integer.parseInt(stk.nextToken());

        dp = new long[n+1][n+1];
        System.out.println(dp(n, r));

        br.close();
    }

    private static long dp(int n, int r) {
        if (n == r || r == 0) {
            return dp[n][r] = 1;
        }
        else if (dp[n][r] != 0) {
            return dp[n][r];
        }

        return dp[n][r] = dp(n - 1, r - 1) + dp(n - 1, r);
    }
}
