class Solution {
     private int solve(int idx, int buy, int limit, int[]arr, int[][][]dp){
        if(idx==arr.length || limit == 0)return 0;
        if(dp[idx][buy][limit] != -1)return dp[idx][buy][limit];
        int profit=0;
        if(buy == 1){
            int purchases=-arr[idx]+solve(idx+1, 0, limit, arr, dp);
            int skip=0+solve(idx+1,1,limit,arr,dp);
            profit=Math.max(purchases,skip);
        }else{
            int sell=arr[idx]+solve(idx+1,1,limit-1,arr,dp);
            int skip=0+solve(idx+1,0,limit,arr,dp);
            profit=Math.max(sell,skip);
        }
        return dp[idx][buy][limit]=profit;
    }
    public int maxProfit(int k, int[] arr) {
        int n = arr.length;

        int[][][] dp = new int[n+1][2][k+1];

        for (int[][] mat : dp) {
            for (int[] row : mat) {
                Arrays.fill(row, -1);
            }
        }

        return solve(0, 1, k, arr, dp);
    }
}