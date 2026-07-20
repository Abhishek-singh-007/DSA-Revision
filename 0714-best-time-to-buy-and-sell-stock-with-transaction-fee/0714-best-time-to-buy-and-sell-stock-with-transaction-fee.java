class Solution {
    int solve(int idx, int buy, int[] prices,int fee, int[][]dp){
        // base case
        if(idx == prices.length) return 0;
        if(dp[idx][buy] != -1) return dp[idx][buy];
        int profit = 0;
        if(buy == 1){
            int buykaro = -prices[idx] + solve(idx+1,0,prices,fee,dp);
            int skip = 0 + solve(idx+1,1,prices,fee,dp);
            profit = Math.max(buykaro,skip);
        }else{
            int sell = prices[idx] - fee  + solve(idx+1,1,prices,fee,dp);
            int skip = 0 + solve(idx+1,0,prices,fee,dp);
            profit = Math.max(sell,skip);
        }
        return dp[idx][buy] = profit;
    }
    public int maxProfit(int[] prices,int fee) {
        int[][] dp = new int[prices.length][2];
        for (int[] arr : dp) {
            Arrays.fill(arr, -1);
        }
        return solve(0,1,prices,fee,dp);
    }
}