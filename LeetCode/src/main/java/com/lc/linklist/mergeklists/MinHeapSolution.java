package com.lc.linklist.mergeklists;

import com.lc.base.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * #mergeKlist
 * @author chanhaoheng
 * @date 2022/3/4
 */
public class MinHeapSolution {

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }

        if (lists.length == 1) {
            return lists[0];
        }

        // PriorityQueue是根据小顶堆实现的
        Queue<ListNode> queue = new PriorityQueue<>(Comparator.comparingInt(node -> node.val));

        // 将lists的所有节点都放在优先级队列中
        for (ListNode listNode : lists) {
            if (listNode != null) {
                queue.offer(listNode);
            }
        }

        ListNode nullHead = new ListNode();
        ListNode p = nullHead;
        
        while (!queue.isEmpty()) {
            // 堆的插入删除时间复杂度都是logN
            ListNode minListNode = queue.poll();
            p.next = minListNode;
            p = p.next;

            if (minListNode.next != null) {
                queue.offer(minListNode.next);
            }
        }
        
        return nullHead.next;
    }

    public static void main(String[] args) {
        MinHeapSolution minHeapSolution = new MinHeapSolution();
        ListNode list1 = ListNode.of(new int[]{1, 4, 5});
        ListNode list2 = ListNode.of(new int[]{1, 3, 4});
        ListNode list3 = ListNode.of(new int[]{2, 6});
        ListNode list4 = ListNode.of(new int[]{2});
        ListNode list5 = ListNode.of(new int[]{2});
        ListNode[] listNodes = new ListNode[]{list1, list2, list3};
        ListNode[] listNodes1 = new ListNode[]{list4, list5};
        System.out.println(minHeapSolution.mergeKLists(listNodes));
        System.out.println(minHeapSolution.mergeKLists(listNodes1));
        System.out.println(minHeapSolution.mergeKLists(new ListNode[]{}));
    }
}
