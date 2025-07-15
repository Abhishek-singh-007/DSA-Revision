class Solution {
    int solve(String s, String reversed, int i, int j){
        if(i == s.length() || j == reversed.length()) return 0;

        int ans = 0;
        if(s.charAt(i) == reversed.charAt(j)){
            ans = 1 + solve(s,reversed,i+1,j+1);
        }else{
            ans = 0 + Math.max(solve(s,reversed,i+1,j), solve(s, reversed, i, j+1));
        }
        return ans;
    }
    int solveMemo(String s, String reversed, int i, int j, int[][] dp) {
        // Base case
        if (i == s.length()) return 0;
        if (j == reversed.length()) return 0;

        if (dp[i][j] != -1) return dp[i][j];
        
        int ans = 0;
        if (s.charAt(i) == reversed.charAt(j)) {
            ans = 1 + solveMemo(s, reversed, i + 1, j + 1, dp);
        } else {
            ans = Math.max(solveMemo(s, reversed, i + 1, j, dp), solveMemo(s, reversed, i, j + 1, dp));
        }
        return dp[i][j] = ans;
    }

    public int longestPalindromeSubseq(String s) {
        String reversed = new StringBuilder(s).reverse().toString();
        //return solve(s,reversed,0,0);
        int[][] dp = new int[s.length() + 1][reversed.length() + 1];
        for (int i = 0; i < s.length() + 1; i++) {
            for (int j = 0; j < reversed.length() + 1; j++) {
                dp[i][j] = -1;
            }
        }
        return solveMemo(s, reversed, 0, 0, dp);
    }
}