class Solution {
    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];

        int result = dp[0];
        for(int i = 1; i < nums.length; i++) {
            int prevSum = dp[i-1] + nums[i];
            int onlyCur = nums[i];
            // System.out.println(onlyPrev + ", " + onlyCur + ", " + sumPrevAndCur);

            if(prevSum > onlyCur) {
                dp[i] = prevSum;
            } else {
                dp[i] = onlyCur;
            }

            // if(onlyPrev > onlyCur && onlyPrev > sumPrevAndCur) {
            //     dp[i] = onlyPrev;
            // } else {
            //     if(onlyCur > onlyPrev && onlyCur > sumPrevAndCur) {
            //         dp[i] = onlyCur;
            //     } else {
            //         dp[i] = sumPrevAndCur;
            //     }
            //     lastIdx = i;
            // }

            result = Math.max(result, dp[i]);
        }

        return result;
    }
}