class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int buy = prices[0];
        int profit = 0;
        for(int i=1; i<n; i++){
            int sell = prices[i]-buy;
            profit = Math.max(profit,sell);
            buy = Math.min(prices[i],buy);
        }
        return profit;
    }
}

