package com.lc.dp;

/**
 * @author chh
 * @date 2022/3/13 12:52
 */
public class MinPathSum {

    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        
        int m = grid.length;
        int n = grid[0].length;
        
        int[] dp = new int[n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    dp[j] = grid[i][j];
                } else if (i == 0) {
                    dp[j] = dp[j - 1] + grid[i][j];
                } else if (j == 0) {
                    dp[j] = dp[j] + grid[i][j];
                } else {
                    dp[j] = Math.min(dp[j], dp[j - 1]) + grid[i][j];
                }
            }
        }

        return dp[n - 1];
    }

    public static void main(String[] args) {
        MinPathSum minPathSum = new MinPathSum();
        System.out.println(minPathSum.minPathSum(new int[][]{new int[]{1, 3, 1}, new int[]{1, 5, 1}, new int[]{4, 2, 1}}));
    }
}
