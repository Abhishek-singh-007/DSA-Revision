class Solution {
    public int solvememo(int[]coins, int x, int[]dp){
        // base case
        if(x==0)return 0;
        if(x<0)return Integer.MAX_VALUE;
        //step 3
        if(dp[x] != -1)return dp[x];
        int mini=Integer.MAX_VALUE;
        // step 2
        for(int i=0; i<coins.length; i++){
            int ans=solvememo(coins,x-coins[i],dp);
            if(ans != Integer.MAX_VALUE){
                mini=Math.min(mini,1+ans);
            }
            
        }
        dp[x]=mini;
        return dp[x];
    }
    public int coinChange(int[] coins, int amount) {
        // step 1
        int[] dp=new int[amount+1];
        Arrays.fill(dp,-1);
        int ans=solvememo(coins,amount,dp);
        if(ans == Integer.MAX_VALUE)return -1;
        return ans;
    }
}