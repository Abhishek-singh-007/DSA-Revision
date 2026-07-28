class Solution {
    Boolean[][] dp;
    private boolean solve(int i, int j, String s1, String s2, String s3){
        if(i==s1.length() && j==s2.length())return true;
        if(dp[i][j] != null)return dp[i][j];
        boolean ans=false;
        int k = i+j;
        if(i<s1.length() && s1.charAt(i) == s3.charAt(k)){
            ans |= solve(i+1, j, s1, s2, s3);
        }
        if(j<s2.length() && s2.charAt(j) == s3.charAt(k)){
            ans |= solve(i, j+1, s1, s2, s3);
        }
        return dp[i][j]=ans;
    }
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length())
            return false;

        dp = new Boolean[s1.length() + 1][s2.length() + 1];

        return solve(0, 0, s1, s2, s3);
    }
}