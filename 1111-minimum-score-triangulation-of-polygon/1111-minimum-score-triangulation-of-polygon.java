class Solution {
    public int solve(int[] arr, int i, int j, int[][]dp){
        if(i+1==j)return 0;
        if(dp[i][j] != -1) return dp[i][j];
        int ans=Integer.MAX_VALUE;
        for(int k=i+1; k<j; k++){
            ans=Math.min(ans,arr[i]*arr[j]*arr[k]+solve(arr,i,k,dp)+solve(arr,k,j,dp));
        }
        return dp[i][j]=ans;
    }
    public int minScoreTriangulation(int[] values) {
        int n=values.length;
        int[][] dp=new int[n][n];
        for(int i=0; i<values.length; i++){
            for(int j=0; j<dp[0].length; j++){
                dp[i][j]=-1;
            }
        }
        return solve(values,0,values.length-1,dp);
    }
}