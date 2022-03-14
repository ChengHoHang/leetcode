package com.lc.pointer;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/sort-colors/solution/yan-se-fen-lei-by-leetcode-solution/
 * @author chh
 * @date 2022/3/13 15:40
 */
public class SortColors {

    public void sortColors(int[] nums) {
        // 循环不变量 zero、one分别表示0、1的右侧边界
        int zero = 0, one = 0;
        for (int i = 0; i < nums.length; i++) {
            int temp = nums[i];
            // 先填上2，之后再根据temp操作右边界
            nums[i] = 2;

            // temp <= 1 one的右边界都要挪一格
            if (temp <= 1) {
                nums[one] = 1;
                one++;
            }
            
            if (temp == 0) {
                nums[zero] = 0;
                zero++;
            } 
        }
    }

    public static void main(String[] args) {
        SortColors sortColors = new SortColors();
        int[] nums = {2, 0, 2, 1, 1, 0};
        sortColors.sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }
}
