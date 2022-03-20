package com.lc.linklist;

import com.lc.base.ListNode;

/**
 * @author chh
 * @date 2022/3/20 17:37
 */
public class HasCycle {

    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return true;
        }

        ListNode fast = head, slow = head;

        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            if (slow == fast) {
                return true;
            }
        }

        return false;
    }
}
