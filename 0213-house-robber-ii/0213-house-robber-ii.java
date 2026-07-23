class Solution {
    public int solve(int i, int end, int[] nums, int[] dp) {
        if (i > end) return 0;
        if (dp[i] != -1) return dp[i];
        int pick = nums[i] + solve(i + 2, end, nums, dp);
        int notPick = solve(i + 1, end, nums, dp);
        return dp[i] = Math.max(pick, notPick);
    }
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];
        // Case 1 : Last house exclude
        int[] dp1 = new int[n];
        Arrays.fill(dp1, -1);
        int case1 = solve(0, n - 2, nums, dp1);
        // Case 2 : First house exclude
        int[] dp2 = new int[n];
        Arrays.fill(dp2, -1);
        int case2 = solve(1, n - 1, nums, dp2);
        return Math.max(case1, case2);
    }
}