class Solution {
    private int solve(int[]arr, int curr, int prev, int[][] dp){
        if(curr == arr.length) return 0;
        if(dp[curr][prev+1] != -1) return dp[curr][prev+1];
        int exc=0+solve(arr,curr+1,prev,dp);
        int inc=0;
        if(prev == -1 || arr[curr] > arr[prev]){
            inc=1+solve(arr,curr+1,curr,dp);
        }
        return dp[curr][prev+1] = Math.max(inc,exc);
    }
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n+1][n+1];
        for(int[] row : dp){
            Arrays.fill(row,-1);
        }
        return solve(nums,0,-1,dp);
    }
}