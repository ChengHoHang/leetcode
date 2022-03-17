package com.lc.dp;

/**
 * https://leetcode-cn.com/problems/trapping-rain-water/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by-w-8/
 * @author chh
 * @date 2022/3/14 23:19
 */
public class TrappingRainWater {

    public int trap(int[] height) {
        if (height.length < 3) {
            return 0;
        }

        int[] leftMaxHeight = new int[height.length];
        int[] rightMaxHeight = new int[height.length];


        leftMaxHeight[0] = height[0];
        for (int i = 1; i < height.length; i++) {
            leftMaxHeight[i] = Math.max(height[i], leftMaxHeight[i - 1]);
        }

        rightMaxHeight[height.length - 1] = height[height.length - 1];
        for (int i = height.length - 2; i > 0; i--) {
            rightMaxHeight[i] = Math.max(height[i], rightMaxHeight[i + 1]);
        }

        // height[k] 第k列能承接的雨水量取决于 height[k] > min(leftMaxHeight[k], rightMaxHeight[k])
        int result = 0;
        for (int i = 1; i < height.length - 1; i++) {
            int min = Math.min(leftMaxHeight[i], rightMaxHeight[i]);
            if (height[i] < min) {
                result = result + (min - height[i]);
            }
        }

        return result;
    }


    public static void main(String[] args) {
        TrappingRainWater trappingRainWater = new TrappingRainWater();
        System.out.println(trappingRainWater.trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
        System.out.println(trappingRainWater.trap(new int[]{4,2,0,3,2,5}));
    }
}
