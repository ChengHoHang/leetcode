package com.lc.linklist;

import com.lc.base.ListNode;

/**
 * https://leetcode-cn.com/problems/add-two-numbers/
 *
 * @author chh
 * @date 2022/2/27 16:30
 */
public class AddTwoNumber {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode root = new ListNode(0);
        ListNode cursor = root;
        
        // l1 l2都是逆序的，直接进位相加
        int carry = 0;
        
        while (l1 != null && l2 != null) {
            int bitSum = carry + l1.val + l2.val;
            carry = bitSum / 10;
            cursor.next = new ListNode(bitSum % 10);
            cursor = cursor.next;

            l1 = l1.next;
            l2 = l2.next;
        }

        while (l1 != null) {
            int bitSum = carry + l1.val;
            carry = bitSum / 10;
            cursor.next = new ListNode(bitSum % 10);
            cursor = cursor.next;
            l1 = l1.next;
        }

        while (l2 != null) {
            int bitSum = carry + l2.val;
            carry = bitSum / 10;
            cursor.next = new ListNode(bitSum % 10);
            cursor = cursor.next;
            l2 = l2.next;
        }

        if (carry != 0) {
            cursor.next = new ListNode(carry);
        }

        return root.next;
    }

    
    
    public static void main(String[] args) {
        
    }
}
