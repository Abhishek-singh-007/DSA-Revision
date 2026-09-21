class Solution {
    public long[] resultArray(int[] nums, int k) {
        int n = nums.length;
        long[] res = new long[k];
        long[] dp = new long[k];

        for (int j = 0; j < n; j++) {
            int aj = nums[j] % k;
            long[] new_dp = new long[k];
            new_dp[aj] += 1;

            for (int r = 0; r < k; r++) {
                if (dp[r] > 0) {
                    int x = (int)((1L * r * aj) % k);
                    new_dp[x] += dp[r];
                }
            }

            for (int x = 0; x < k; x++) {
                res[x] += new_dp[x];
            }

            dp = new_dp;
        }

        return res;
    }
}