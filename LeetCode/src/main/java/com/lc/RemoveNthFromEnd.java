package com.lc;

/**
 * @author chh
 * @date 2022/3/2 22:15
 */
public class RemoveNthFromEnd {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return null;
        }

        // 使得fast指向倒数第n + 1个
        ListNode fast = head, slow = head;
        for (int i = 0; i < n + 1 && slow.next != null; i++) {
            slow = slow.next;
        }

        if (slow == fast) {
            fast.next = null;
            return head;
        }

        while (slow.next != null) {
            fast = fast.next;
            slow = slow.next;
        }

        fast.next = fast.next.next;

        return head;
    }


    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
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

    public static void main(String[] args) {
        RemoveNthFromEnd removeNthFromEnd = new RemoveNthFromEnd();
        System.out.println(removeNthFromEnd.removeNthFromEnd(ListNode.of(new int[]{1, 2, 3, 4, 5}), 2));
        System.out.println(removeNthFromEnd.removeNthFromEnd(ListNode.of(new int[]{1}), 1));
        System.out.println(removeNthFromEnd.removeNthFromEnd(ListNode.of(new int[]{1, 2}), 1));
    }
}
