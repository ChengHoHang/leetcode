package com.lc.array;

/**
 * @author chanhaoheng
 * @date 2022/3/9
 */
public class SearchInsert {

    public int searchInsert(int[] nums, int target) {
        if (nums.length == 0) {
            return 0;
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
        return target <= nums[left] ? left : left + 1;
    }
}
