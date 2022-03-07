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

        ListNode start = head;
        ListNode newHead = new ListNode();
        newHead.next = start;
        ListNode lastEnd = newHead;

        while (true) {
            ListNode thisGroupEnd = start;
            ListNode groupEndNode = getGroupEndNode(start, k);
            if (groupEndNode == null) {
                break;
            }
            lastEnd.next = reverseList(start, k);
            lastEnd = start;
            start = thisGroupEnd.next;
        }

        return newHead.next;
    }

    /**
     * 获取组内最后的节点位置，若节点为null表示不需要翻转
     */
    public ListNode getGroupEndNode(ListNode head, int k) {
        ListNode p = head;
        for (int i = 0; i < k - 1 && p != null; i++) {
            p = p.next;
        }
        return p;
    }

    public ListNode reverseList(ListNode listNode, int k) {
        if (listNode == null) {
            return null;
        }
        ListNode head = new ListNode();
        ListNode p = listNode;
        for (int i = 0; i < k; i++) {
            ListNode q = p.next;
            p.next = head.next;
            head.next = p;
            p = q;
        }

        listNode.next = p;
        return head.next;
    }

    public static void main(String[] args) {
        ReverseKGroup reverseKGroup = new ReverseKGroup();
        System.out.println(reverseKGroup.reverseKGroup(ListNode.of(new int[]{1, 2, 3, 4, 5}), 3));
        System.out.println(reverseKGroup.reverseKGroup(ListNode.of(new int[]{1}), 1));
        System.out.println(reverseKGroup.reverseKGroup(ListNode.of(new int[]{1, 2}), 3));
    }
}
