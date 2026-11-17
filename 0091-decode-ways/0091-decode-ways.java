class Solution {
    public int numDecodings(String s) {
        if(s.charAt(0) == '0') return 0;

        int[] dp = new int[s.length()+1];
        dp[0] = dp[1] = 1;
        for(int i = 2; i < dp.length; i++) {
            char cur = s.charAt(i-1);
            char prev = s.charAt(i-2);

            int prevCurNum = (prev-'0') * 10 + (cur-'0');
            // 불가능 케이스 (00, 30, 40, ...)
            if(
                // 00 케이스
                prevCurNum == 0 ||
                // 30, 40, ... 케이스
                (prevCurNum % 10 == 0 && prevCurNum / 10 > 2)
            ) {
                return 0;
            }

            if(cur == '0') {
                dp[i] = dp[i-2];
            } else if(prev != '0' && prevCurNum <= 26) {
                dp[i] = dp[i-1] + dp[i-2];
            } else {
                dp[i] = dp[i-1];
            }
            System.out.println(dp[i]);
        }

        return dp[dp.length-1];
    }
}