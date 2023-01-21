class Solution {
    
   static long dp[][] = new long[2001][2001];
    
    static final int DIVIDE = 1234567;
    
    public long solution(int n) {
        long rs = 0;
        int max2Len = n / 2;
        for (int twoNum = 0; twoNum <= max2Len; twoNum++) {
            int oneNum = n - twoNum * 2;

            // 총 길이 파악 (어떤 위치에 2를 넣을 지 정하기 위함)
            int totalLen = oneNum + twoNum;

            //총가지수 C 2의 개수로 조합 연산 시작
            long totalCase = dp(totalLen, twoNum);

            if (twoNum == totalLen || oneNum == totalLen) {
                rs++;
            } else {
                rs += totalCase;
            }
            rs %= DIVIDE;
        }

        return rs;
    }
    
    public static long dp(int n, int m) {
        if(dp[n][m] > 0){
            return dp[n][m];
        }

        if(m == 0 || m == n)
            return dp[n][m] = 1;

        return dp[n][m] = (dp(n - 1, m - 1) + dp(n - 1, m)) % DIVIDE;
    }
}