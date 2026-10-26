class Solution {
    public int[] countBits(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        if(n > 0) dp[1] = 1;
        for(int i = 2; i <= n; i++) {
            int lastDightNum = getLastDightNum(i);
            dp[i] = dp[i - lastDightNum] + 1;
        }

        return dp;
    }

    private int getLastDightNum(int num) {
        int index = 0;
        while(true) {
            int curNum = (int)Math.pow(2, index);
            if(curNum > num) break;
            index++;
        }

        return (int)Math.pow(2, index-1);
    }
}