class Solution {
    // public int solution(int n) {
    //     int n1 = 1, n2 = 0;
    //     for(int i = 2; i < n+1; i++){
    //         int tmp = n1;
    //         n1 = (int)(((long)n1 + n2) % 1234567);
    //         n2 = tmp;
    //     }
    //     return n1;
    // }
    
    static int[] dp;
    
    public int solution(int n) {
        dp = new int[n+1];
        dp[1] = 1;
            
        dp(n);
        
        return dp[n];
    }
    
    public static int dp(int n){
        if(dp[n] > 0){
            return dp[n];
        }
        else if(n == 0){
            return 0;
        }

        return dp[n] = (int)(((long)dp(n-1) + dp(n-2)) % 1234567);
    }
}