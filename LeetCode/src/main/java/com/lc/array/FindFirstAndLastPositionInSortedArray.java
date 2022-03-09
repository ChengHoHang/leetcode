package com.lc.array;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array/
 * @author chanhaoheng
 * @date 2022/3/9
 */
public class FindFirstAndLastPositionInSortedArray {

    public int[] searchRange(int[] nums, int target) {
        int firstPosition = binarySearchLowest(nums, target);
        int lastPosition = binarySearchHighest(nums, target);
        return new int[]{firstPosition, lastPosition};
    }

    /**
     * 左闭右开
     */
    public int binarySearchLowest(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (target <= nums[mid]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return nums[left] == target ? left : -1;
    }

    /**
     * 左开右闭
     */
    public int binarySearchHighest(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int left = 0, right = nums.length - 1;
        while (left < right) {
            // 向上取整，使得mid偏右
            int mid = (left + right) / 2 + 1;
            if (target >= nums[mid]) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        return nums[right] == target ? right : -1;
    }

    public static void main(String[] args) {
        FindFirstAndLastPositionInSortedArray sortedArray = new FindFirstAndLastPositionInSortedArray();
        System.out.println(Arrays.toString(sortedArray.searchRange(new int[]{1, 2, 2, 2, 2, 5, 6, 7}, 2)));
        System.out.println(Arrays.toString(sortedArray.searchRange(new int[]{}, 2)));
        System.out.println(Arrays.toString(sortedArray.searchRange(new int[]{-1, 1}, 2)));
    }
}
