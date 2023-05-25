package P10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P10_4 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        // [0] : 밑면의 넓이, [1] : 높이, [2] : 무게
        int[][] bricks = new int[n][3];
        StringTokenizer stk;
        for (int i = 0; i < bricks.length; i++) {
            stk = new StringTokenizer(br.readLine());
            for (int j = 0; j < bricks[i].length; j++) {
                bricks[i][j] = Integer.parseInt(stk.nextToken());
            }

        }

        Arrays.sort(bricks, (b1, b2) -> b2[0] - b1[0]);
        int[] dp = new int[n];
        dp[0] = bricks[0][1];
        for (int i = 1; i < bricks.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if ( bricks[i][0] < bricks[j][0] &&
                        bricks[i][2] < bricks[j][2] &&
                        dp[i] < dp[j] + bricks[i][1]) {
                    dp[i] = dp[j] + bricks[i][1];
                }
            }
            if(dp[i] == 0){
                dp[i] = bricks[i][1];
            }
        }

        Arrays.sort(dp);
        System.out.println(dp[dp.length - 1]);

        br.close();
    }
}
