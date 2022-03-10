package com.lc.dp;

/**
 * @author chanhaoheng
 * @date 2022/3/10
 */
public class MaxSubArray {

    public int maxSubArray(int[] nums) {
        if (nums == null) {
            return 0;
        }

        int sum = Integer.MIN_VALUE;
        int preSum = 0;
        for (int num : nums) {
            preSum = Math.max(num, preSum + num);
            sum = Math.max(sum, preSum);
        }

        return sum;
    }

    public static void main(String[] args) {
        MaxSubArray maxSubArray = new MaxSubArray();
        System.out.println(maxSubArray.maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
        System.out.println(maxSubArray.maxSubArray(new int[]{5,4,-1,7,8}));
        System.out.println(maxSubArray.maxSubArray(new int[]{1}));
    }
}
