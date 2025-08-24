class Solution {

    public int solve(char[][] mat, int i, int j, int maxi, int[][] dp){
 
        if(i >=  mat.length || j >= mat[0].length){
            return 0;
        }
        if(dp[i][j] != -1) return dp[i][j];
        int right = solve(mat, i,  j+1, maxi, dp);
        int diag = solve(mat, i+1, j+1, maxi, dp);
        int left = solve(mat, i+1,  j, maxi, dp);

        if(mat[i][j]=='1'){
            dp[i][j] = 1 + Math.min(right, Math.min(diag,left));
            maxi = Math.max(maxi, dp[i][j]);
            return dp[i][j];
        }else{
            return dp[i][j] = 0;
        }
    }
    public int maximalSquare(char[][] mat) {
        int maxi = 0;
        int[][] dp = new int[mat.length][mat[0].length];
        for(int i=0; i<dp.length; i++){
            for(int j=0; j<dp[0].length; j++){
                dp[i][j] = -1;
            }
        }

       for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                maxi = Math.max(maxi, solve(mat, i, j,maxi, dp));
            }
        }

        return maxi * maxi; 
    }
}