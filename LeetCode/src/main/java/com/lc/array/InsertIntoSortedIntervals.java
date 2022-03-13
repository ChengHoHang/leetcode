package com.lc.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author chanhaoheng
 * @date 2022/3/11
 */
public class InsertIntoSortedIntervals {

    public int[][] insert(int[][] intervals, int[] newInterval) {
        if (intervals == null || intervals.length == 0) {
            return new int[][]{newInterval};
        }

        List<int[]> result = new ArrayList<>();

        int curIndex = 0;
        // 将不需要合并的先放result中，curIndex就是需要合并的interval
        for (; curIndex <= intervals.length; curIndex++) {
            if (curIndex == intervals.length) {
                result.add(newInterval);
                return result.toArray(new int[0][0]);
            }
            int[] curInterval = intervals[curIndex];
            if (curInterval[1] < newInterval[0]) {
                result.add(curInterval);
            } else {
                if (newInterval[1] >= curInterval[0]) {
                    // 插在这个internal里面，再将这个internal跟后面的合并
                    curInterval[0] = Math.min(curInterval[0], newInterval[0]);
                    curInterval[1] = Math.max(curInterval[1], newInterval[1]);
                } else {
                    result.add(newInterval);
                }
                result.add(curInterval);
                break;
            }
        }

        // lc56的解法，直接合并
        int lastIntervalIndex = curIndex;
        for (int i = curIndex + 1; i < intervals.length; i++) {
            int[] lastInterval = result.get(lastIntervalIndex);
            // 若上一个interval的有边界小于当前interval左边界，直接add
            if (lastInterval[1] < intervals[i][0]) {
                for (int j = i; j < intervals.length; j++) {
                    result.add(intervals[j]);
                }
                break;
            } else {
                lastInterval[1] = Math.max(lastInterval[1], intervals[i][1]);
            }
        }

        return result.toArray(new int[0][0]);
    }

    public static void main(String[] args) {
        InsertIntoSortedIntervals intervals = new InsertIntoSortedIntervals();
        int[][] intervals1 = {new int[]{1, 2}, new int[]{3, 5}, new int[]{6, 7}, new int[]{8, 10}, new int[]{12, 16}};
        System.out.println(Arrays.deepToString(intervals.insert(intervals1, new int[]{4, 8})));

        int[][] intervals2 = {new int[]{1, 5}};
        System.out.println(Arrays.deepToString(intervals.insert(intervals2, new int[]{6, 7})));

        int[][] intervals3 = {};
        System.out.println(Arrays.deepToString(intervals.insert(intervals3, new int[]{4, 8})));

        int[][] intervals4 = {new int[]{2, 5}, new int[]{6, 7}, new int[]{8, 9}};
        System.out.println(Arrays.deepToString(intervals.insert(intervals4, new int[]{0, 1})));
    }
}
