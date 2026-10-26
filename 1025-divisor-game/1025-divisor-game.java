import java.util.*;

class Solution {
    public boolean divisorGame(int n) {
        boolean[] dp = new boolean[n+1];
        dp[1] = false;

        for(int curNum = 2; curNum <= n; curNum++) {
            List<Integer> dividers = getDividers(curNum);

            boolean result = false;
            for(int divider : dividers) {
                result = result || !dp[curNum - divider];
            }

            dp[curNum] = result;
        }

        return dp[n];
    }

    private List<Integer> getDividers(int num) {
        Set<Integer> dividers = new HashSet<>();
        for(int i = 1; i <= (int)Math.sqrt(num); i++) {
            if(num % i == 0) {
                dividers.add(i);
                dividers.add(num / i);
            }
        }
        dividers.remove(num);

        return new ArrayList<>(dividers);
    }
    
}