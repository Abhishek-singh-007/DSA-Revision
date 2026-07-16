class Solution {
    private boolean solvememo(int[] nums, int idx, int target, int[][] dp){
        // base case
        if(target == 0) return true;
        if(idx >= nums.length || target < 0) return false;
        if (dp[idx][target] != -1) return dp[idx][target] == 1;
        // exc
        boolean exc = solvememo(nums,idx+1,target,dp);
        // inc
        boolean inc = solvememo(nums,idx+1,target-nums[idx],dp);

        // store
        dp[idx][target] = (inc || exc) ? 1 : 0;
        return inc || exc;
    }
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for(int i=0; i<n; i++){
            sum+= nums[i];
        }
        if(sum % 2 != 0) return false;
        int target = sum/2;
        int[][] dp = new int[n][target+1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return solvememo(nums,0,target,dp);
    }
}