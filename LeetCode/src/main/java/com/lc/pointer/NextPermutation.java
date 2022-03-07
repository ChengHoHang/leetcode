package com.lc.pointer;

import java.util.Arrays;

/**
 * 字典序后一个数
 * https://leetcode-cn.com/problems/next-permutation/solution/
 * @author chh
 * @date 2022/3/7 20:47
 */
public class NextPermutation {

    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length == 1) {
            return;
        }

        // 从后往前找，直到找到 a[i] < a[i + 1]，[i + 1, n]必然为降序序列
        int i = nums.length - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }

        // 从[i + 1, n]从后往前找，直到找到 a[i] < a[j]   此时交换 a[i]和a[j]  可证[i + 1, n]仍是降序序列
        // 有可能nums已经是最大值，i指针为-1
        if (i >= 0) {
            int j = nums.length - 1;
            while (j > i && nums[j] <= nums[i]) {
                j--;
            }
            swapNums(nums, i, j);
        }
        
        // 将[i + 1, n]改为升序序列，翻转
        reverseNums(nums, i + 1, nums.length - 1);
    }

    private void reverseNums(int[] nums, int left, int right) {
        while (left < right) {
            swapNums(nums, left, right);
            left++;
            right--;
        }
    }

    private void swapNums(int[] nums, int i, int j) {
        int temp = nums[j];
        nums[j] = nums[i];
        nums[i] = temp;
    }

    public static void main(String[] args) {
        NextPermutation nextPermutation = new NextPermutation();
        int[] nums = {1, 5, 1};
        nextPermutation.nextPermutation(nums);
        System.out.println(Arrays.toString(nums));

        int[] nums1 = {2, 1, 3};
        nextPermutation.nextPermutation(nums1);
        System.out.println(Arrays.toString(nums1));

        int[] nums2 = {3, 2, 1};
        nextPermutation.nextPermutation(nums2);
        System.out.println(Arrays.toString(nums2));
    }
}
