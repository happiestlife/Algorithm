class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;

        int minValue = Integer.MAX_VALUE;
        for(int i = 0; i < prices.length; i++) {
            int curPrice = prices[i];
            if(curPrice < minValue) {
                minValue = curPrice;
            } else {
                maxProfit = Math.max(maxProfit, curPrice - minValue);
            }
        }

        return maxProfit;
    }
}