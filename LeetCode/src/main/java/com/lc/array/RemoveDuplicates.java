package com.lc.array;

import java.util.Arrays;

/**
 * <a href="https://leetcode.cn/problems/remove-duplicates-from-sorted-array/">...</a>
 * @author chanhaoheng
 * @date 2022/12/20
 */
public class RemoveDuplicates {

    public int removeDuplicates(int[] nums) {
        if (nums.length == 1) {
            return 1;
        }

        int fast = 1, slow = 1;

        while (fast < nums.length) {
            if (nums[fast] != nums[slow - 1]) {
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }

        return slow;
    }

    public static void main(String[] args) {
        RemoveDuplicates removeDuplicates = new RemoveDuplicates();
        int[] nums = {1, 1, 2, 2, 2, 3, 3, 4};
        System.out.println(removeDuplicates.removeDuplicates(nums));
        System.out.println(Arrays.toString(Arrays.stream(nums).toArray()));
    }
}
