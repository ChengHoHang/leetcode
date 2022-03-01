package com.lc;

/**
 * https://leetcode-cn.com/problems/container-with-most-water/
 * @author chh
 * @date 2022/3/1 22:53
 */
public class WaterContainer {

    public int maxArea(int[] height) {
        int maxArea = 0;
        int left = 0, right = height.length - 1;

        while (left < right) {
            int area = Math.min(height[left], height[right]) * (right - left);
            maxArea = Math.max(maxArea, area);

            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            } 
        }

        return maxArea;
    }

    public static void main(String[] args) {
        WaterContainer waterContainer = new WaterContainer();
        System.out.println(waterContainer.maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
    }
}
