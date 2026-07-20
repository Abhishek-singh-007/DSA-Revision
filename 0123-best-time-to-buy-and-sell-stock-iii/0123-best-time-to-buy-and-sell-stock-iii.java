class Solution {

    private int solve(int idx, int buy, int cap, int[] arr, int[][][] dp) {

        // Base Case
        if (idx == arr.length || cap == 0) {
            return 0;
        }

        // Memoization
        if (dp[idx][buy][cap] != -1) {
            return dp[idx][buy][cap];
        }

        int profit = 0;

        // Can Buy
        if (buy == 1) {

            int purchase = -arr[idx] + solve(idx + 1, 0, cap, arr, dp);

            int skip = solve(idx + 1, 1, cap, arr, dp);

            profit = Math.max(purchase, skip);

        }
        // Can Sell
        else {

            int sell = arr[idx] + solve(idx + 1, 1, cap - 1, arr, dp);

            int skip = solve(idx + 1, 0, cap, arr, dp);

            profit = Math.max(sell, skip);
        }

        return dp[idx][buy][cap] = profit;
    }

    public int maxProfit(int[] arr) {

        int n = arr.length;

        int[][][] dp = new int[n][2][3];

        for (int[][] mat : dp) {
            for (int[] row : mat) {
                Arrays.fill(row, -1);
            }
        }

        return solve(0, 1, 2, arr, dp);
    }
}