package com.lc.linklist;

import com.lc.base.ListNode;

/**
 * @author chanhaoheng
 * @date 2022/3/3
 */
public class SwapPairs {

    public ListNode swapPairs(ListNode head) {
        // 长度小于2 直接返回
        if (head == null || head.next == null) {
            return head;
        }

        ListNode nullHead = new ListNode();
        nullHead.next = head;

        ListNode p = nullHead;
        while (p.next != null && p.next.next != null) {
            ListNode q = p.next;
            p.next = q.next;
            ListNode nextGroupNode = p.next.next;

            p.next.next = q;
            q.next = nextGroupNode;

            p = q;
        }

        return nullHead.next;
    }

    public static void main(String[] args) {
        SwapPairs swapPairs = new SwapPairs();
        System.out.println(swapPairs.swapPairs(ListNode.of(new int[]{1, 2, 3, 4, 5})));
        System.out.println(swapPairs.swapPairs(ListNode.of(new int[]{1, 2})));
        System.out.println(swapPairs.swapPairs(ListNode.of(new int[]{1, 2, 3})));
    }
}
