package com.lc.array;

import java.util.HashSet;
import java.util.Set;

/**
 * @author chh
 * @date 2022/3/20 16:01
 */
public class LongestConsecutive {

    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int maxLength = 1;
        
        Set<Integer> numsSet = new HashSet<>();
        for (int num : nums) {
            numsSet.add(num);
        }

        for (int num : nums) {
            // 从头遍历
            if (numsSet.contains(num - 1)) {
                continue;
            }

            int nextNum = num + 1;
            int length = 1;
            while (numsSet.contains(nextNum)) {
                nextNum++;
                length++;
            }

            maxLength = Math.max(maxLength, length);
        }

        return maxLength;
    }


    public static void main(String[] args) {
        LongestConsecutive longestConsecutive = new LongestConsecutive();
        System.out.println(longestConsecutive.longestConsecutive(new int[]{100, 4, 200, 1, 3, 2}));
        System.out.println(longestConsecutive.longestConsecutive(new int[]{0, 3, 7, 2, 5, 8, 4, 6, 0, 1}));
        System.out.println(longestConsecutive.longestConsecutive(new int[]{9, 1}));
    }
}
