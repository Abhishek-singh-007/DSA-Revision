class Solution {
    private int solve(String s1, String s2, int i, int j, int[][]dp){
        if(i==s1.length())return 0;
        if(j==s2.length())return 0;
        if(dp[i][j] != -1)return dp[i][j];
        int ans=0;
        if(s1.charAt(i)==s2.charAt(j)){
            ans=1+solve(s1,s2,i+1,j+1,dp);
        }else{
            ans=Math.max(solve(s1,s2,i+1,j,dp),solve(s1,s2,i,j+1,dp));
        }
        return dp[i][j]=ans;
    }
    public int longestCommonSubsequence(String s1, String s2) {
        int n=s1.length();
        int m=s2.length();
        int[][]dp=new int[n+1][m+1];
        for(int i=0;i<n; i++){
            for(int j=0; j<m; j++){
                dp[i][j]=-1;
            }
        }
        return solve(s1,s2,0,0,dp);
    }
}