package com.lc.dp;

/**
 * //输入：[1,2,3,1]
 * //输出：4
 * //解释：偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
 * //     偷窃到的最高金额 = 1 + 3 = 4 。
 * //
 * // 示例 2：
 * //
 * //
 * //输入：[2,7,9,3,1]
 * //输出：12
 * //解释：偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。
 * //     偷窃到的最高金额 = 2 + 9 + 1 = 12 。
 * @author chanhaoheng
 * @date 2022/3/25
 */
public class Rob {

    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }

        int first = nums[0], second = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            int temp = second;
            second = Math.max(first + nums[i], second);
            first = temp;
        }

        return second;
    }


    public int rob1(int[] nums) {
        // dp[i] 表示 打劫前i间所能获取的最大利润
        // dp[0] = nums[0]
        // dp[1] = max(dp[0], nums[1])
        // dp[2] = max(dp[0] + nums[2], dp[1])
        // dp[3] = max(dp[1] + nums[3], dp[2])
        // dp[i] = max(dp[i - 2] + nums[i], dp[i - 1])   滚动数组优化
        if (nums == null || nums.length == 0) {
            return 0;
        }

        if (nums.length == 1) {
            return nums[0];
        }

        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }
        return dp[nums.length - 1];
    }

    public static void main(String[] args) {
        Rob rob = new Rob();
        System.out.println(rob.rob(new int[]{2,7,9,3,1}));
    }
}
