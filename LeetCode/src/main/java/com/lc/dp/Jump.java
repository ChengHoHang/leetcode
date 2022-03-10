package com.lc.dp;

/**
 * https://leetcode-cn.com/problems/jump-game/
 * @author chh
 * @date 2022/3/10 20:51
 */
public class Jump {

    public boolean canJump(int[] nums) {
        // maxJumpLength 表示第i位置所能跳跃到的最大的位置
        int maxJumpLength = 0;
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            if (i <= maxJumpLength) {
                maxJumpLength = Math.max(maxJumpLength, i + nums[i]);
                if (maxJumpLength >= length - 1) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Jump jump = new Jump();
        System.out.println(jump.canJump(new int[]{3, 2, 1, 0, 4}));
    }
}
