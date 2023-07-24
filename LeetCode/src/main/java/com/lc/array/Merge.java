package com.lc.array;

import java.util.Arrays;

/**
 * #88
 * @author chanhaoheng
 * @date 2022/12/21
 */
public class Merge {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        m--;
        n--;
        int i = nums1.length - 1;

        while (n >= 0 && m >= 0) {
            if (nums1[m] > nums2[n]) {
                nums1[i] = nums1[m];
                m--;
            } else {
                nums1[i] = nums2[n];
                n--;
            }
            i--;
        }

        while (n >= 0) {
            nums1[i] = nums2[n];
            i--;
            n--;
        }
    }


    public static void main(String[] args) {
        Merge merge = new Merge();
        int[] nums1 = {4,5,6,0,0,0};
        merge.merge(nums1, 3, new int[]{1,2,3}, 3);
        System.out.println(Arrays.toString(nums1));
    }
}
