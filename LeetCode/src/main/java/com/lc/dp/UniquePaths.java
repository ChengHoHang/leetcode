package com.lc.dp;

import java.util.Arrays;

/**
 * @author chh
 * @date 2022/3/11 21:26
 */
public class UniquePaths {

    public int uniquePaths(int m, int n) {
        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[j] = dp[j - 1] + dp[j];
            }
        }

        return dp[n - 1];
    }

    public static void main(String[] args) {
        UniquePaths uniquePaths = new UniquePaths();
        System.out.println(uniquePaths.uniquePaths(7, 3));
        System.out.println(uniquePaths.uniquePaths(2, 3));
    }
}
