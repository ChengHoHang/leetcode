package com.lc.base;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author chanhaoheng
 * @date 2022/3/24
 */
class MinStack {

    private LinkedList<Integer> nums;
    private List<Integer> minSortNums;

    public MinStack() {
        this.nums = new LinkedList<>();
        this.minSortNums = new ArrayList<>();
    }

    public void push(int val) {
        nums.addLast(val);
        int index = getInsertIndex(minSortNums, val);
        minSortNums.add(index, val);
    }

    public void pop() {
        int value = nums.removeLast();
        int index = getValueIndex(minSortNums, value);
        minSortNums.remove(index);
    }

    public int top() {
        return nums.getLast();
    }

    public int getMin() {
        return minSortNums.get(0);
    }


    public int getInsertIndex(List<Integer> nums, int val) {
        if (nums.size() == 0) {
            return 0;
        }

        // 左闭右开 寻找插入位置
        int left = 0, right = nums.size() - 1;
        while (left < right) {
            int min = (left + right) / 2;
            if (val <= nums.get(min)) {
                right = min;
            } else {
                left = min + 1;
            }
        }

        return val <= nums.get(left) ? left : left + 1;
    }


    public int getValueIndex(List<Integer> nums, int val) {
        int left = 0, right = nums.size() - 1;
        while (left <= right) {
            int min = (left + right) / 2;
            if (val == nums.get(min)) {
                return min;
            }else if (val < nums.get(min)) {
                right = min - 1;
            } else {
                left = min + 1;
            }
        }

        throw new RuntimeException("unknown");
    }


    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.top());
        System.out.println(minStack.getMin());
    }
}
