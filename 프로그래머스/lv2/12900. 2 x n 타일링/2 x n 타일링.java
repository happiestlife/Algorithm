class Solution {
    public long solution(int n) {
        long[] dp = new long[n+1];
        dp[0] = dp[1] = 1;
        for (int i = 2; i < dp.length; i++) {
            dp[i] = (dp[i - 2] + dp[i - 1]) % 1000000007;
        }

        return dp[dp.length - 1];
    }
}