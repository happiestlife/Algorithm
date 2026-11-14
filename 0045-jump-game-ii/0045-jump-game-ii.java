class Solution {
    public int jump(int[] nums) {
        int[] dp = new int[nums.length+1];
        for(int i = 0; i < nums.length; i++) {
            int curMaxJumpCnt = nums[i];
            for(int j = 1; j <= curMaxJumpCnt; j++) {
                int jumpTarget = i + j;
                if(jumpTarget >= nums.length) break;
                else if(dp[jumpTarget] > 0) continue;

                dp[jumpTarget] = dp[i] + 1;
            }

            // System.out.println(Arrays.toString(dp));
        }
        // System.out.println(Arrays.toString(dp));

        return dp[nums.length-1];
    }
}