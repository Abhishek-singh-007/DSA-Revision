class Solution {
    public int solve(int n, int[] nums, int[] dp){
        if(n>nums.length-1) return 0;
        if(dp[n]!= -1) return dp[n];
        int pick=solve(n+2,nums,dp)+nums[n];
        int notpick=solve(n+1,nums,dp);
        return dp[n]=Math.max(pick,notpick);
    }
    public int rob(int[] nums) {
        int n=nums.length;
       // if(n==0) return 0;
        int[] dp=new int[n+1];
        Arrays.fill(dp,-1);
        return solve(0,nums,dp);
    }
}