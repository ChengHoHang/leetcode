package com.lc;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/two-sum/
 * @author chh
 * @date 2022/2/27 16:23
 */
public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        if (nums.length == 2) {
            return new int[]{0, 1};
        }

        // nums值 ——> index
        Map<Integer, Integer> value2IndexMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int otherValue = target - nums[i];
            if (value2IndexMap.containsKey(otherValue)) {
                return new int[]{i, value2IndexMap.get(otherValue)};
            }
            value2IndexMap.put(nums[i], i);
        }

        return null;
    }
}
