package com.lc.dp;

/**
 * @author chh
 * @date 2022/3/13 13:18
 */
public class UniquePathsWithObstacles {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid == null || obstacleGrid.length == 0 || obstacleGrid[0][0] == 1) {
            return 0;
        }
        
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        int[] dp = new int[n];

        dp[0] = 1;
        
        for (int j = 1; j < n; j++) {
            dp[j] = obstacleGrid[0][j] == 1 ? 0 : dp[j - 1];
        }
        
        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (obstacleGrid[i][j] == 1) {
                    dp[j] = 0;
                } else {
                    dp[j] = j > 0 ? dp[j] + dp[j - 1] : dp[j];
                } 
            }
        }

        return dp[n - 1];
    }

    public static void main(String[] args) {
        UniquePathsWithObstacles obstacles = new UniquePathsWithObstacles();
        int[][] obstacleGrid1 = {new int[]{0, 0, 0}, new int[]{0, 1, 0}, new int[]{0, 0, 0}};
        System.out.println(obstacles.uniquePathsWithObstacles(obstacleGrid1));

        int[][] obstacleGrid2 = {new int[]{0, 1, 0}, new int[]{0, 0, 0}};
        System.out.println(obstacles.uniquePathsWithObstacles(obstacleGrid2));

    }
}
