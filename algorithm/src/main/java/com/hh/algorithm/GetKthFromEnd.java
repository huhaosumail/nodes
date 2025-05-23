package com.hh.algorithm;

/**
 * 输入一个链表，输出该链表中倒数第k个节点。为了符合大多数人的习惯，本题从1开始计数，即链表的尾节点是倒数第1个节点。
 *
 * 例如，一个链表有 6 个节点，从头节点开始，它们的值依次是 1、2、3、4、5、6。这个链表的倒数第 3 个节点是值为 4 的节点。
 */
public class GetKthFromEnd {

    public static ReverseKGroup.ListNode getKthFromEnd(ReverseKGroup.ListNode head,int k){

        // 先定义firstNode向右遍历k个节点
        ReverseKGroup.ListNode firstNode = head;
        while (k-- > 0 && firstNode != null) {
            firstNode = firstNode.next;
        }

        // 然后定义secondNode从头开始遍历
        // firstNode继续向右遍历，直到firstNode遍历到空节点为止
        ReverseKGroup.ListNode secondNode = head;
        while (firstNode != null) {
            // firstNode和secondNode一起向右遍历
            firstNode = firstNode.next;
            secondNode = secondNode.next;
        }

        // secondNode节点就是倒数第k个节点
        return secondNode;

    }
    public static void main(String[] args) {


        ReverseKGroup.ListNode node5 = new ReverseKGroup.ListNode(5,null);
        ReverseKGroup.ListNode node4 = new ReverseKGroup.ListNode(4,node5);
        ReverseKGroup.ListNode node3 = new ReverseKGroup.ListNode(3,node4);
        ReverseKGroup.ListNode node2 = new ReverseKGroup.ListNode(2,node3);
        ReverseKGroup.ListNode node1 = new ReverseKGroup.ListNode(1,node2);

       ReverseKGroup.ListNode result = getKthFromEnd(node1,2);
       System.out.println(result.val);


    }
}
