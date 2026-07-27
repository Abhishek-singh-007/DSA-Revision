class Solution {
    private int solve(int i, int j, int[][]grid, int[][]dp){
        int rows = grid.length;
        int cols = grid[0].length;
        // base case 
        if(i>= rows || j>= cols)return Integer.MAX_VALUE;
        if(i==rows-1 && j==cols-1)return grid[i][j];
        if(dp[i][j] != -1)return dp[i][j];
        int op1=solve(i+1,j,grid,dp);
        int op2=solve(i,j+1,grid,dp);
        return dp[i][j]=grid[i][j]+Math.min(op1,op2);
    }
    public int minPathSum(int[][] grid) {
       int rows = grid.length;
        int cols = grid[0].length;
        int[][] dp = new int[rows][cols];
        for(int[] row : dp){
            Arrays.fill(row, -1);
        }
        return solve(0, 0, grid, dp);
    }
}