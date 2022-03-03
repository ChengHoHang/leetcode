package com.lc.base;

/**
 * @author chanhaoheng
 * @date 2022/3/3
 */
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public static ListNode of(int[] ints) {
        ListNode head = new ListNode();
        ListNode target = head;
        for (int i : ints) {
            target.next = new ListNode(i);
            target = target.next;
        }
        return head.next;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        ListNode target = this;
        do {
            sb.append(target.val).append(", ");
            target = target.next;
        } while (target != null);
        return sb.toString();
    }
}
