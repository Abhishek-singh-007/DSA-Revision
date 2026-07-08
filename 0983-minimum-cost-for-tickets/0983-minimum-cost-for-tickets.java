class Solution {
    private int solve(int n, int idx, int[] days, int[] costs, int[] dp) {
        if(idx >= n)return 0;
        if(dp[idx] != -1)return dp[idx];
        int a = costs[0]+solve(n,idx+1,days,costs,dp);
        int i;
        for(i=idx; i<n && days[i]<days[idx]+7; i++);
            int b = solve(n,i,days,costs,dp)+costs[1];
        
        
        for(i=idx; i<n && days[i]<days[idx]+30; i++);
            int c = solve(n,i,days,costs,dp)+costs[2];
        
        dp[idx] = Math.min(a,Math.min(b,c));
        return dp[idx];
    }
    public int mincostTickets(int[] days, int[] costs) {
        int n=days.length;
        int[] dp=new int[n+1];
        Arrays.fill(dp,-1);
        return solve(n,0,days,costs,dp);
    }
}