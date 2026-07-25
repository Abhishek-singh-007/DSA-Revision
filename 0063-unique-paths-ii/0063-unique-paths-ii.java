class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        // If the destination is blocked, no path exists
        if (obstacleGrid[m - 1][n - 1] == 1) {
            return 0;
        }

        int[][] dp = new int[m][n];

        // Initialize the last column
        for (int i = m - 1; i >= 0; i--) {
            if (obstacleGrid[i][n - 1] == 0) {
                dp[i][n - 1] = 1;
            } else {
                for (int j = i; j >= 0; j--) {
                    dp[j][n - 1] = 0;
                }
                break;
            }
        }

        // Initialize the last row
        for (int i = n - 1; i >= 0; i--) {
            if (obstacleGrid[m - 1][i] == 0) {
                dp[m - 1][i] = 1;
            } else {
                for (int j = i; j >= 0; j--) {
                    dp[m - 1][j] = 0;
                }
                break;
            }
        }

        // Fill the remaining DP table
        for (int i = m - 2; i >= 0; i--) {
            for (int j = n - 2; j >= 0; j--) {
                if (obstacleGrid[i][j] == 1) {
                    // Obstacle cell
                    dp[i][j] = 0;
                } else {
                    // Sum of paths from the bottom and right cells
                    dp[i][j] = dp[i + 1][j] + dp[i][j + 1];
                }
            }
        }

        return dp[0][0];
    }
}