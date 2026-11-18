class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int curPos = 0;
        int[] dp = new int[cost.length+2];
        Arrays.fill(dp, -1);
        dp[0] = dp[1] = 0;
        for(int i = 0; i < cost.length; i++) {
            int curMoveCost = dp[i] + cost[i];
            if(dp[i+1] == -1) dp[i+1] = curMoveCost;
            else dp[i+1] = Math.min(dp[i+1], curMoveCost);

            if(dp[i+2] == -1) dp[i+2] = curMoveCost;
            else dp[i+2] = Math.min(dp[i+2], curMoveCost);
        }

        return Math.min(dp[cost.length], dp[cost.length+1]);
        
    }
}