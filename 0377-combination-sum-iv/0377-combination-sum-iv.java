class Solution {
    public int solve(int[]nums, int target, int []dp){
        if(target==0)return 1;
        if(dp[target] != -1)return dp[target];
        int cnt=0;
        for(int i=0; i<nums.length; i++){
            if(target-nums[i]>=0)
            cnt += solve(nums,target-nums[i],dp);
        }
        return dp[target]=cnt;
    }
    public int combinationSum4(int[] nums, int target) {
        int[] dp=new int[target+1];
        Arrays.fill(dp,-1);
        return solve(nums,target,dp);
    }
}