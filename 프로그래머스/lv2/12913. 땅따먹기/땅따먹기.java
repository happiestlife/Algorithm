import java.util.*;

class Solution {
    
    static int[][] dp;
    
    int solution(int[][] land) {
        dp = new int[land.length][4];
        // 땅이 0인 경우를 제외하기 위한 초기화
        for(int i = 0; i < dp.length; i++)
            Arrays.fill(dp[i], -1);
        
        for (int i = 0; i < land[0].length; i++) {
            dp(land, 0, i, i);
        }

        Arrays.sort(dp[0]);
        return dp[0][3]; 
    }
    
    public static int dp(int[][] land, int r, int c, int lastCol) {
        if(r == land.length - 1){
            return dp[r][c] = land[r][c];
        }

        int max = 0;
        for (int i = 0; i < land[r].length; i++) {
            if(i != lastCol){
                if(dp[r+1][i] != -1)
                    max = Math.max(dp[r+1][i], max);
                else 
                    max = Math.max(dp(land, r+1, i, i), max);
            }
        } 

        return dp[r][c] = land[r][c] + max;
    }
}