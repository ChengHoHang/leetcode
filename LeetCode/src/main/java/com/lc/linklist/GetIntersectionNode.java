package com.lc.linklist;

import com.lc.base.ListNode;

/**
 * @author chh
 * @date 2022/3/24 21:16
 */
public class GetIntersectionNode {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // 双指针 a + b + c(公共长度)
        ListNode p = headA, q = headB;
        
        // 若 headA 与 headB 相交， 由于 a + b + c = b + a + c  必定有相交点
        // 若 headA 与 headB 不相交，由于 a + b + c = b + a + c  最后相交于另一端的null
        while (p != q) {
            p = p == null ? headB : p.next;
            q = q == null ? headA : q.next;
        }

        return p;
    }
}
