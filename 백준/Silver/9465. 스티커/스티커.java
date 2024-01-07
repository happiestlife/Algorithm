import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());

           int[][] stickers = new int[2][n + 1];
            for (int i = 0; i < stickers.length; i++) {
                StringTokenizer stk = new StringTokenizer(br.readLine());
                for (int j = 1; j < stickers[i].length; j++) {
                    stickers[i][j] = Integer.parseInt(stk.nextToken());
                }
            }

            int[][] dp = new int[2][n + 1];
            dp[0][1] = stickers[0][1];
            dp[1][1] = stickers[1][1];
            for (int i = 2; i <= n; i++) {
                // x + 1, y - 1 / y - 2밖에 없는 이유 {(x - 2, y)가 생략된 이유}
                // x - 2, y인 경우, 현재 지점에서 x + 1, y + 1 부분이 생략되기 때문 ✨ 아주 주요 ✨ 
                dp[0][i] = Math.max(dp[1][i - 1], dp[1][i - 2]) + stickers[0][i];
                dp[1][i] = Math.max(dp[0][i - 1], dp[0][i - 2]) + stickers[1][i];
            }
            sb.append(Math.max(dp[0][n], dp[1][n]) + "\n");
        }

        System.out.println(sb.toString());

        br.close();
    }
}