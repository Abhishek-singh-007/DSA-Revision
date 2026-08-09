class Solution {
        /*
        #########################################################################
        #                                                                       #
        #  =============================================                        #
        #                  SIDDARDHA CHILUVERU                                  #
        #  =============================================                        #
        #                                                                       #
        #  Author      : Siddardha Chiluveru                                    #
        #  Description : Solution / Code / Project                              #
        #  Date        : 2026-08-06                                             #
        #                                                                       #
        #########################################################################
        */
    int[][][] dp;
    public int stoneGameII(int[] piles) {
        int n = piles.length;
        dp = new int[2][n][n + 1]; // 2 players and array ;ength is n and the max m can be n / 2 and x can be n and starts from 1 so n + 1
        for (int[][] i : dp)
            for (int[] j : i)
                Arrays.fill(j, -1);
        int ans = func(1, 0, 1, piles);
        return ans;
    }
    int func(int player, int i, int M, int[] nums) {
        if (i == nums.length)
            return 0;
        if (dp[player][i][M] != -1)
            return dp[player][i][M];
        int res;
        int sum = 0;
        if (player == 1) 
            res = 0;
        else
            res = Integer.MAX_VALUE;
        for (int x = 1; x <= 2 * M; x++) {
            if (i + x - 1 >= nums.length)
                break;
            sum += nums[i + x - 1];
            if (player == 1)
                res = Math.max(res, sum + func(0, i + x, Math.max(M, x), nums));
            else
                res = Math.min(res, func(1, i + x, Math.max(M, x), nums));
        }
        dp[player][i][M] = res;
        return res;
    }
}