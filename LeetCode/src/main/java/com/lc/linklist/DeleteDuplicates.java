package com.lc.linklist;

import com.lc.base.ListNode;

/**
 * @author chanhaoheng
 * @date 2022/12/23
 */
public class DeleteDuplicates {


    public ListNode deleteDuplicates1(ListNode head) {
        ListNode dummy = new ListNode(0, head);
        ListNode cur = dummy;

        while (cur.next != null && cur.next.next != null) {
            if (cur.next.val != cur.next.next.val) {
                cur = cur.next;
            } else {
                ListNode pre = cur;
                int val = cur.next.val;
                while (cur.next != null && val == cur.next.val) {
                    cur = cur.next;
                }
                pre.next = cur.next;
                cur = pre;
            }
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        DeleteDuplicates deleteDuplicates = new DeleteDuplicates();
//        System.out.println(deleteDuplicates.deleteDuplicates1(ListNode.of(new int[]{1, 1, 2, 2, 3, 3, 3, 5})));
        System.out.println(deleteDuplicates.deleteDuplicates1(ListNode.of(new int[]{1,2,3,3,4,4,5})));
    }
}
