import java.util.*;

class Solution {
    public List<Integer> getRow(int rowIndex) {
        int[][] dp = new int[rowIndex+1][rowIndex+1];
        for(int i = 0; i < dp.length; i++) {

            dp[i][0] = 1;
            dp[i][i] = 1;
        }

        for(int i = 2; i <= rowIndex; i++) {
            for(int j = 1; j < i; j++) {
                dp[i][j] = dp[i-1][j-1] + dp[i-1][j];                
            }
        }

        return Arrays.stream(dp[rowIndex])
                    .boxed()
                    .collect(Collectors.toList());
    }
}