package com.lc.linklist;

import com.lc.base.ListNode;

/**
 * @author chh
 * @date 2022/3/6 21:51
 */
public class ReverseKGroup {

    public ListNode reverseKGroup(ListNode head, int k) {
        if (k == 1 || head == null) {
            return head;
        }
        
        
    }

    public boolean checkEnableReverse(ListNode head, int k) {
        ListNode p = head;
        for (int i = 0; i < k && p != null; i++) {
            p = p.next;
        }
        return p != null;
    }

    public ListNode reverseList(ListNode listNode, int k) {
        if (listNode == null) {
            return null;
        }
        ListNode p = listNode;
        
    }
}
