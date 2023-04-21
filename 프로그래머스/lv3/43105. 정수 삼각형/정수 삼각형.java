import java.util.*;

class Solution {
    
    static int[][] dp;
    
//     public int solution(int[][] triangle) {
//         dp = new int[triangle.length][triangle[triangle.length-1].length];
//         return dp(triangle, 0, 0);
//     }
    
//     public static int dp(int[][] triangle, int x, int y) {
//         if(x == triangle.length - 1){
//             return dp[x][y] = triangle[x][y];
//         }
//         else if(dp[x][y] != 0){
//             return dp[x][y];
//         }

//         return dp[x][y] = triangle[x][y] + Math.max(dp(triangle, x + 1, y), dp(triangle, x + 1, y + 1));
//     }
    
    public int solution(int[][] triangle) {
        dp = new int[triangle.length][triangle[triangle.length-1].length];
        dp[0][0] = triangle[0][0];
        for (int i = 1; i < triangle.length; i++) {
            for (int j = 0; j < triangle[i].length; j++) {
                int max = 0;
                // 왼쪽 끝
                if (j == 0) {
                    max = dp[i - 1][j];
                }
                // 오른쪽 끝
                else if(j == triangle[i].length - 1){
                    max = dp[i - 1][j - 1];
                }
                // 가운데
                else{
                    max = Math.max(dp[i - 1][j], dp[i - 1][j - 1]);
                }

                dp[i][j] = triangle[i][j] + max;
            }
        }

        Arrays.sort(dp[dp.length - 1]);
        return dp[dp.length - 1][dp[dp.length - 1].length - 1];
    }
}