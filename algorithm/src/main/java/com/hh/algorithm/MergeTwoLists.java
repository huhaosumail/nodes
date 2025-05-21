package com.hh.algorithm;

import com.hh.algorithm.ReverseKGroup.ListNode;

/**
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 *
 * 提示：
 *
 * 两个链表的节点数目范围是 [0, 50]
 * -100 <= Node.val <= 100
 * l1 和 l2 均按 非递减顺序 排列
 */
public class MergeTwoLists {


    public static ListNode mergeTwoLists(ListNode listNode1, ListNode listNode2){


    }


    public static void main(String[] args) {

        ListNode node5 = new ListNode(5,null);
        ListNode node4 = new ListNode(4,node5);
        ListNode node3 = new ListNode(3,node4);
        ListNode node2 = new ListNode(2,node3);
        ListNode node1 = new ListNode(1,node2);

        ListNode node10 = new ListNode(10,null);
        ListNode node9 = new ListNode(9,node10);
        ListNode node8 = new ListNode(8,node9);
        ListNode node7 = new ListNode(7,node8);
        ListNode node6 = new ListNode(6,node7);

        ListNode result  = mergeTwoLists(node1,node6);
        while(result != null){
            System.out.println(result.val);
            result = result.next;
        }
    }
}
