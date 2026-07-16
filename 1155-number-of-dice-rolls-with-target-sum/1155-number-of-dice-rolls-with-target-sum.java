class Solution {
    public static int helper(int n , int k , int target, int[][] dp){
        if(n==0 && target==0)
            return 1;
        if(target <= 0)
            return 0;
        if(n<=0)
            return 0;    
        if(dp[n][target]!=-1)
            return dp[n][target];
        int ans=0;
        for(int i =1; i<=k; i++)
        {
            ans+=(helper(n-1, k , target-i,dp)%1000000007);
            ans=ans%1000000007;
        }
        dp[n][target]= ans;
        return dp[n][target];
    }
    public int numRollsToTarget(int n, int k, int target) {
        int[][] dp = new int[n+1][1000];
        for(int i =0;i<n+1;i++)
        {
            Arrays.fill(dp[i],-1);
        }
       return helper(n,k,target,dp);
    }
    
}