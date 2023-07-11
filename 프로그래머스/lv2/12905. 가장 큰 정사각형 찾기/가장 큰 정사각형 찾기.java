class Solution
{
    public int solution(int [][]board){
        int max = 0;
        int[][] dp = new int[board.length][board[0].length];
        
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[i].length; j++){
                int n = board[i][j];
                if(n == 1){
                    int left = 0, up = 0, leftUp = 0;
                    if(j - 1 >= 0){
                        left = dp[i][j - 1];
                    }
                    if(i - 1 >= 0){
                        up = dp[i - 1][j];
                    }
                    if(i - 1 >= 0 && j - 1 >= 0){
                        leftUp = dp[i-1][j-1];
                    }
                    
                    int min = Math.min(leftUp, Math.min(left, up));
                    dp[i][j] = min + 1;
                    if(i == 0 || j == 0){
                        dp[i][j] = board[i][j];
                    }
                    max = Math.max(max, dp[i][j]);
                }  
            }
        }        
        
        // for(int[] row : dp){
        //     for(int col : row){
        //         System.out.print(col + " " );
        //     }
        //     System.out.println();
        // }

        return max * max;
    }
}