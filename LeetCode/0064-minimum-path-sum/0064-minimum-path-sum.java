class Solution {
    public int minPathSum(int[][] grid) {
        int[][] dp = new int[grid.length][grid[0].length];

        int[] dx = { 0, -1};
        int[] dy = {-1,  0};

        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[i].length; j++) {
                int prevMin = -1;
                for(int k = 0; k < dx.length; k++) {
                    int fx = i + dx[k];
                    int fy = j + dy[k];

                    if(
                        (fx < 0 || fx >= grid.length) || 
                        (fy < 0 || fy >= grid[0].length)
                    ) continue;

                    if(prevMin == -1) prevMin = dp[fx][fy];
                    else prevMin = Math.min(prevMin, dp[fx][fy]);
                }

                if(prevMin == -1) dp[i][j] = grid[i][j];
                else {
                    dp[i][j] = grid[i][j] + prevMin;
                }
                // System.out.print(dp[i][j] + "(" + (grid[i][j] + "," + prevMin) + ") ");
            }
            // System.out.println();
        }

        return dp[grid.length-1][grid[0].length-1];
    }
}