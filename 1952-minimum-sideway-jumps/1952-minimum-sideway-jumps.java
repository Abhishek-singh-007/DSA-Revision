class Solution {
    int solvemem(int[]obs, int currlane, int currpos,int[][]dp){
        int n = obs.length-1;
        // base case 
        if(currpos == n) return 0;
        if(dp[currlane][currpos] != -1) return dp[currlane][currpos];
        // case 1 if not obs in same lane
        if(obs[currpos+1] != currlane){
            return solvemem(obs,currlane,currpos+1,dp);
        }else{
            int ans = Integer.MAX_VALUE;
            //side ways jump
            for(int i=1; i<=3; i++){
                if(currlane != i && obs[currpos] != i){
                    ans = Math.min(ans,1+solvemem(obs,i,currpos,dp));
                }
            }
            dp[currlane][currpos] = ans;
            return dp[currlane][currpos];
        }
    }
    public int minSideJumps(int[] obs) {
        //return solve(obs,2,0);
        int[][] dp = new int[4][obs.length];
        for(int i=0; i<4; i++){
            for(int j=0; j<obs.length; j++){
                dp[i][j] = -1;
            }
        }
        return solvemem(obs,2,0,dp);
    }
}