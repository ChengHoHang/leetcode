package com.lc;

import com.lc.base.ListNode;

/**
 * @author chh
 * @date 2022/3/2 22:15
 */
public class RemoveNthFromEnd {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || head.next == null) {
            return null;
        }

        // 使得slow指向倒数第n个
        ListNode fast = head, slow = head;
        for (int i = 0; i < n; i++) {
            fast = fast.next;
            if (fast == null) {
                return head.next;
            }
        }

        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }

        slow.next = slow.next.next;

        return head;
    }




    public static void main(String[] args) {
        RemoveNthFromEnd removeNthFromEnd = new RemoveNthFromEnd();
        System.out.println(removeNthFromEnd.removeNthFromEnd(ListNode.of(new int[]{1, 2, 3, 4, 5}), 1));
        System.out.println(removeNthFromEnd.removeNthFromEnd(ListNode.of(new int[]{1}), 1));
        System.out.println(removeNthFromEnd.removeNthFromEnd(ListNode.of(new int[]{1, 2}), 1));
    }
}
