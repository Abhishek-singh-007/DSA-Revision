class Solution {
    private int solve(int[] nums, int target,int[]dp){
        if(target == 0)return 1;
        if(dp[target] != -1) return dp[target];
        int count=0;
        for(int i=0; i<nums.length; i++){
            if(target-nums[i]>=0){
                count += solve(nums,target-nums[i],dp);
            }
        }
        return dp[target]=count;
    }
    public int combinationSum4(int[] nums, int target) {
        int n=nums.length;
        int[] dp=new int[target+1];
        Arrays.fill(dp,-1);
        return solve(nums,target,dp);
    }
}