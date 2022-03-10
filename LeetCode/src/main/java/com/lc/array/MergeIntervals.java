package com.lc.array;

import java.util.Arrays;
import java.util.Comparator;

/**
 * https://leetcode-cn.com/problems/merge-intervals/solution/chi-jing-ran-yi-yan-miao-dong-by-sweetiee/
 * @author chh
 * @date 2022/3/10 21:13
 */
public class MergeIntervals {

    public int[][] merge(int[][] intervals) {
        // 先对数组排序
        Arrays.sort(intervals, Comparator.comparingInt(interval -> interval[0]));
        
        // 数组排序后
        int[][] result = new int[intervals.length][2];
        
        return result;
    }
}
