package com.lc.linklist.mergeklists;

import com.lc.base.ListNode;

/**
 * #mergeKlist
 *
 * @author chh
 * @date 2022/3/6 21:00
 */
public class MergeSolution {

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }

        if (lists.length == 1) {
            return lists[0];
        }

        return merge(lists, 0, lists.length - 1);
    }

    /**
     * 合并 list[left....right] 为一条链表
     */
    private ListNode merge(ListNode[] lists, int left, int right) {
        if (left == right) {
            return lists[left];
        }

        int mid = (left + right) / 2;
        ListNode leftList = merge(lists, left, mid);
        ListNode rightList = merge(lists, mid + 1, right);
        return mergeTwoList(leftList, rightList);
    }

    private ListNode mergeTwoList(ListNode leftList, ListNode rightList) {
        if (leftList == null) {
            return rightList;
        }
        if (rightList == null) {
            return leftList;
        }

        if (leftList.val < rightList.val) {
            leftList.next = mergeTwoList(leftList.next, rightList);
            return leftList;
        } else {
            rightList.next = mergeTwoList(leftList, rightList.next);
            return rightList;
        } 
    }
    

    public static void main(String[] args) {
        MergeSolution mergeSolution = new MergeSolution();
        ListNode list1 = ListNode.of(new int[]{1, 4, 5});
        ListNode list2 = ListNode.of(new int[]{1, 3, 4});
        ListNode list3 = ListNode.of(new int[]{2, 6});
        ListNode list4 = ListNode.of(new int[]{2});
        ListNode list5 = ListNode.of(new int[]{2});
        ListNode[] listNodes = new ListNode[]{list1, list2, list3};
        ListNode[] listNodes1 = new ListNode[]{list4, list5};
        System.out.println(mergeSolution.mergeKLists(listNodes));
        System.out.println(mergeSolution.mergeKLists(listNodes1));
        System.out.println(mergeSolution.mergeKLists(new ListNode[]{}));
    }
}
