class Solution {
    public long solution(int m, int n, int[][] puddles) {
        boolean[][] isWater = new boolean[n][m];
        for (int i = 0; i < puddles.length; i++) {
            isWater[puddles[i][1]-1][puddles[i][0]-1] = true;
        }

        long[][] dp = new long[n][m];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                if(isWater[i][j])
                    continue;

                // left 처리
                if(j - 1 >= 0 && !isWater[i][j - 1]) {
                    dp[i][j] += dp[i][j - 1];
                }

                // up 처리
                if(i - 1 >= 0 && !isWater[i-1][j]) {
                    dp[i][j] += dp[i - 1][j];
                }

                dp[i][j] = dp[i][j] % 1000000007;
                if(i == 0 && j == 0)
                    dp[i][j] = 1;
            }
        }
        
        return dp[n-1][m-1];
    }
}