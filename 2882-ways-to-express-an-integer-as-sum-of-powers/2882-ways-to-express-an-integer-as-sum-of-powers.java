class Solution {
    private int solve(int idx, int target, int[] powers, int[][] dp, int MOD) {
        if (target == 0) return 1;
        if (idx >= powers.length || target < 0) return 0;
        if (dp[idx][target] != -1) return dp[idx][target];

        long take = 0;
        if (powers[idx] <= target)
            take = solve(idx + 1, target - powers[idx], powers, dp, MOD);

        long notTake = solve(idx + 1, target, powers, dp, MOD);

        return dp[idx][target] = (int)((take + notTake) % MOD);
    }

    public int numberOfWays(int n, int x) {
        int MOD = 1_000_000_007;

        List<Integer> list = new ArrayList<>();
        for (int i = 1;; i++) {
            long val = (long)Math.pow(i, x);
            if (val > n) break;
            list.add((int)val);
        }

        int[] powers = list.stream().mapToInt(i -> i).toArray();
        int[][] dp = new int[powers.length][n + 1];
        for (int[] row : dp) Arrays.fill(row, -1);

        return solve(0, n, powers, dp, MOD);
    }
}