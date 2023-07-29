package com.lc.stack;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * https://leetcode.cn/problems/daily-temperatures/
 * @author chanhaoheng
 * @date 2023/7/29
 */
public class DailyTemperatures {

    public int[] dailyTemperatures(int[] temperatures) {
        Deque<Integer> indexStack = new LinkedList<>();
        int[] result = new int[temperatures.length];

        for (int i = 0; i < temperatures.length; i++) {
            int curTemperature = temperatures[i];
            while (indexStack.size() > 0 && curTemperature > temperatures[indexStack.getFirst()]) {
                Integer index = indexStack.removeFirst();
                result[index] = i - index;
            }
            
            indexStack.addFirst(i);
        }
        return result;
    }

    public static void main(String[] args) {
        DailyTemperatures dailyTemperatures = new DailyTemperatures();
        System.out.println(Arrays.toString(dailyTemperatures.dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73})));
    }
}
