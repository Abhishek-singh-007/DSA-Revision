class Solution {
    int solve(int idx, int[] nums, int diff,HashMap<Integer, Integer>[] dp){
        // base case
        if(idx < 0) return 0;
        if (dp[idx].containsKey(diff)) return dp[idx].get(diff);
        // cases
        int ans = 0;
        for(int j=idx-1; j>=0; j--){
            if(nums[idx] - nums[j] == diff){
                 ans = Math.max(ans, 1 + solve(j, nums, diff,dp));
            }
        }
        dp[idx].put(diff, ans);
        return ans;
    }
    public int longestArithSeqLength(int[] nums) {
        int n = nums.length;
        HashMap<Integer, Integer>[] dp = new HashMap[n];
        for (int i = 0; i < n; i++) {
            dp[i] = new HashMap<>();
        }
        int ans = 0;
        for(int i=0; i<n; i++){
            for(int j=i+1; j<n; j++){
                ans = Math.max(ans, 2 + solve(i,nums,nums[j] - nums[i],dp));
            }
        }
        return ans;
    }
}