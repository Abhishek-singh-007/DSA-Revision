class Solution {
    private int solve(int idx, int buy, int[]arr, int[][]dp){
        if(idx==arr.length)return 0;
        if(dp[idx][buy] != -1)return dp[idx][buy];
        int profit=0;
        if(buy ==1){
            int purchases=-arr[idx]+solve(idx+1,0,arr,dp);
            int skip=0+solve(idx+1,1,arr,dp);
            profit=Math.max(purchases,skip);
        }else{
            int sell=arr[idx]+solve(idx+1,1,arr,dp);
            int skip=0+solve(idx+1,0,arr,dp);
            profit=Math.max(sell,skip);
        }
        return dp[idx][buy]=profit;
    }
    public int maxProfit(int[] arr) {
        int n = arr.length;
        int[][]dp=new int[n][2];
        for(int[]row:dp){
            Arrays.fill(row,-1);
        }
        return solve(0,1,arr,dp);
    }
}