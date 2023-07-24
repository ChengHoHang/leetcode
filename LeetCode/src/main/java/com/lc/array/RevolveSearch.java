package com.lc.array;

/**
 * @author chanhaoheng
 * @date 2022/12/23
 */
public class RevolveSearch {

    public boolean search(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;

            if (nums[mid] == target) {
                return true;
            }

            if (nums[low] == nums[mid] && nums[mid] == nums[high]) {
                low++;
                high--;
                continue;
            }

            // 左半区有序
            if (nums[low] <= nums[mid]) {
                if (nums[low] <= target && target < nums[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else {
                if (nums[mid] < target && target <= nums[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }

        }
        return false;
    }

    public static void main(String[] args) {
        RevolveSearch revolveSearch = new RevolveSearch();
        revolveSearch.search(new int[]{2,5,6,0,0,1,2}, 3);
    }
}
