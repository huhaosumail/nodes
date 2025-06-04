package com.hh.algorithm;

/**
 * 给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
 * <p>
 * k 是一个正整数，它的值小于或等于链表的长度。
 * <p>
 * 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 * <p>
 * 进阶：
 * <p>
 * 你可以设计一个只使用常数额外空间的算法来解决此问题吗？ 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
 * <p>
 * 提示：
 * <p>
 * 列表中节点的数量在范围 sz 内
 * 1 <= sz <= 5000
 * 0 <= Node.val <= 1000
 * 1 <= k <= sz
 */
public class ReverseKGroup {

    public static class ListNode {
        public int val;
        public ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        ListNode node = head;
        int i = 0;
        while (node != null && ++i < k) {
            node = node.next;
        }
        if (i < k) {
            return head;
        }
        //先保存后续临时节点 同时下一步进行断琏
        ListNode next = node.next;
        node.next = null;

        //反转前k个链表
        ListNode newHead = reverseListNode(head);
        //将临时节点带入后续再进行反转 head.next是精髓 串联k个节点组用的
        head.next = reverseKGroup(next, k);
        return newHead;
    }

    private static ListNode reverseListNode(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode prev = null;
        ListNode curr = head;
        ListNode next;
        while (curr != null) {
//              //临时节点，暂存当前节点的下一节点，用于后移
//              //因为接下来curr.next进行赋值后将会断链 这里最主要的是断琏 并保存
//              next = curr.next;
//              //将当前节点指向它前面的节点
//              curr.next = prev;
//              //前指针后移
//              prev = curr;
//              //当前指针后移
//              curr = next;
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;

        }
        return prev;
    }


    public static void main(String[] args) {
        ListNode node5 = new ListNode(5, null);
        ListNode node4 = new ListNode(4, node5);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode node1 = new ListNode(1, node2);

        ListNode result = reverseKGroup(node1, 3);

        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }


}
