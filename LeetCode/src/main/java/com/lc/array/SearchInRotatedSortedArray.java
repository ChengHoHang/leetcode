package com.lc.array;

/**
 * https://leetcode-cn.com/problems/search-in-rotated-sorted-array/
 * @author chanhaoheng
 * @date 2022/3/9
 */
public class SearchInRotatedSortedArray {

    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                return mid;
            }

            // 左半区有序或者右半区有序
            if (nums[left] <= nums[mid]) {
                // 对有序一边进行二分查找，另一边继续迭代
                if (target >= nums[left] && target <= nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if (target >= nums[mid] && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        SearchInRotatedSortedArray search = new SearchInRotatedSortedArray();
        int[] ints = {5, 6, 7, 1, 2, 3, 4};
        System.out.println(search.search(ints, 3));
        System.out.println(search.search(ints, 2));
    }
}
