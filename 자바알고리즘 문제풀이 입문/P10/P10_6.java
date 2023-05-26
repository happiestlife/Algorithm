package P10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P10_6 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stk = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(stk.nextToken());
        int m = Integer.parseInt(stk.nextToken());

        // [0] : 점수, [1] : 시간
        int[][] problems = new int[n][2];
        for (int i = 0; i < problems.length; i++) {
            stk = new StringTokenizer(br.readLine());
            for (int j = 0; j < problems[i].length; j++) {
                problems[i][j] = Integer.parseInt(stk.nextToken());
            }
        }

        Arrays.sort(problems, (p1, p2) -> {
            double p1ScorePerTime = (double)p1[0] / p1[1];
            double p2ScorePerTime = (double)p2[0] / p2[1];
            double result = p2ScorePerTime - p1ScorePerTime;
            if(result < 0)
                return -1;
            else if(result > 0)
                return 1;
            else
                return p2[0] - p1[0];
        });

        // [][0] : 점수합, [][1] : 남은 시간
        int[][] dp = new int[problems.length][2];
        dp[0] = new int[]{problems[0][0], m - problems[0][1]};
        for (int i = 1; i < problems.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                // 이전 문제들에서 남은 시간이 현재 문제가 요구하는 시간보다 크다면
                if(dp[j][1] - problems[i][1] >= 0){
                    int curScore = dp[j][0] + problems[i][0];
                    if(curScore > dp[i][0]) {
                        dp[i][0] = curScore;
                        dp[i][1] = dp[j][1] - problems[i][1];
                    }
                }
            }
            if(dp[i][0] == 0){
                dp[i][0] = problems[i][0];
                dp[i][1] = m - problems[i][1];
            }
        }

        Arrays.sort(dp, (score1, score2) -> score2[0] - score1[0]);
        System.out.println(dp[0][0]);

        br.close();
    }
}

