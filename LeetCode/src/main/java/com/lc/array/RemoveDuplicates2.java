package com.lc.array;

import java.util.Arrays;

/**
 * @author chanhaoheng
 * @date 2022/12/20
 */
public class RemoveDuplicates2 {

    public int removeDuplicates(int[] nums) {
        if (nums.length < 3) {
            return nums.length;
        }

        int slow = 2, fast = 2;
        while (fast < nums.length) {
            if (nums[fast] != nums[slow - 2]) {
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }

        return slow;
    }

    public static void main(String[] args) {
        RemoveDuplicates2 removeDuplicates = new RemoveDuplicates2();
        int[] nums = {1, 1, 2, 2, 2, 3, 3, 4};
        System.out.println(removeDuplicates.removeDuplicates(nums));
        System.out.println(Arrays.toString(Arrays.stream(nums).toArray()));
    }
}
