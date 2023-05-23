package P10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P10_1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        long[][] dp = new long[n + 1][n + 1];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j <= i; j++) {
                if(j == 0 || j == i){
                    dp[i][j] = 1;
                }
                else{
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                }
            }
        }

        int max2Cnt = n / 2;

        long rs = 0;
        for (int i = 0; i <= max2Cnt; i++) {
            int stepCnt = n;
            int orderCnt = i + stepCnt - 2 * i;

            rs += dp[orderCnt][i];
        }

        System.out.println(rs);

        br.close();
    }
}
