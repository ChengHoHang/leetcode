package com.lc.linklist.mergeklists;

import com.lc.base.ListNode;

/**
 * #mergeKlist
 * https://leetcode-cn.com/problems/merge-k-sorted-lists/solution/4-chong-fang-fa-xiang-jie-bi-xu-miao-dong-by-sweet/
 * @author chh
 * @date 2022/3/3 23:41
 */
public class KPointerSolution {

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        if (lists.length == 1) {
            return lists[0];
        }


        ListNode nullHead = new ListNode();
        ListNode p = nullHead;
        int k = lists.length;

        while (true) {
            ListNode minNode = null;
            int minIndex = -1;
            for (int i = 0; i < k; i++) {
                if (lists[i] == null) {
                    continue;
                }

                if (minNode == null || lists[i].val < minNode.val) {
                    minNode = lists[i];
                    minIndex = i;
                }
            }

            // 若遍历了k个链表都是空的，直接返回
            if (minIndex == -1) {
                break;
            }

            p.next = minNode;
            p = p.next;
            lists[minIndex] = minNode.next;
        }

        return nullHead.next;
    }


    public static void main(String[] args) {
        KPointerSolution kPointerSolution = new KPointerSolution();
        ListNode list1 = ListNode.of(new int[]{1, 4, 5});
        ListNode list2 = ListNode.of(new int[]{1, 3, 4});
        ListNode list3 = ListNode.of(new int[]{2, 6});
        ListNode list4 = ListNode.of(new int[]{2});
        ListNode list5 = ListNode.of(new int[]{2});
        ListNode[] listNodes = new ListNode[]{list1, list2, list3};
        ListNode[] listNodes1 = new ListNode[]{list4, list5};
        System.out.println(kPointerSolution.mergeKLists(listNodes));
        System.out.println(kPointerSolution.mergeKLists(listNodes1));
        System.out.println(kPointerSolution.mergeKLists(new ListNode[]{}));
    }
}
