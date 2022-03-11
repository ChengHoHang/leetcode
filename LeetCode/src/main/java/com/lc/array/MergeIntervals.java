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
        
        // 数组排序后，可以枚举出两两数组的分布情况
        // 对于数组[a, b]和[m, n]
        // 若m > n   不合并，直接开一格
        // 其他情况，即便b > n或 b<= n  需要合并数组, 合并的数组的有边界都是取max(b, n)
        int[][] result = new int[intervals.length][2];

        // 每次合并都是针对result[lastIndex]合并, result最多intervals.length个
        int lastIndex = -1;

        for (int i = 0; i < intervals.length; i++) {
            if (i == 0 || intervals[i][0] > result[lastIndex][1]) {
                result[++lastIndex] = intervals[i];
            } else {
                result[lastIndex][1] = Math.max(result[lastIndex][1], intervals[i][1]);
            }
        }

        return Arrays.copyOf(result, lastIndex + 1);
    }


    public static void main(String[] args) {
        MergeIntervals mergeIntervals = new MergeIntervals();
        int[][] intervals = {new int[]{1, 3}, new int[]{2, 6},
                new int[]{8, 10}, new int[]{15, 18}};
        System.out.println(Arrays.deepToString(mergeIntervals.merge(intervals)));
    }
}
