package com.hh.algorithm;

import com.hh.algorithm.ReverseKGroup.ListNode;

/**
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 * <p>
 * 提示：
 * <p>
 * 两个链表的节点数目范围是 [0, 50]
 * -100 <= Node.val <= 100
 * l1 和 l2 均按 非递减顺序 排列
 */
public class MergeTwoLists {

    /**
     *  代码逻辑错误原因
     *  代码问题分析
     * 返回值错误：
     * 1.你返回的是 head，而 head 在循环结束时指向链表尾部，正确的做法应该返回合并后的头节点。
     * 头节点处理不当：
     * 2.你创建了一个 head 节点，但没有保存其初始位置，导致无法返回正确的头节点。
     * 链表断裂：
     * 3.每次直接将整个剩余链表赋值给 head.next（如 head.next = list1），而非逐个节点连接，导致链表结构被破坏。
     * 正确解法：迭代法（双指针）
     * 思路：
     * 1.创建一个 ** 哑节点（dummy node）** 作为合并后链表的头节点，用于简化边界处理。
     * 2.使用一个指针 current 指向当前合并位置，初始时指向 dummy。
     * 3.比较 list1 和 list2 的当前节点值，将较小值的节点连接到 current 之后，并移动对应指针。
     * 4.处理剩余节点，直接将剩余链表连接到 current 之后。
     * 5.返回 dummy.next 作为合并后的头节点。
     * 修复后的代码：
     * java
     * public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
     *     // 创建哑节点，保存头节点位置
     *     ListNode dummy = new ListNode();
     *     ListNode current = dummy;
     *
     *     // 同时遍历两个链表，直到其中一个为空
     *     while (list1 != null && list2 != null) {
     *         if (list1.val < list2.val) {
     *             current.next = list1;
     *             list1 = list1.next;  // 移动 list1 指针
     *         } else {
     *             current.next = list2;
     *             list2 = list2.next;  // 移动 list2 指针
     *         }
     *         current = current.next;  // 移动 current 指针
     *     }
     *
     *     // 处理剩余节点（如果有）
     *     if (list1 != null) {
     *         current.next = list1;
     *     } else {
     *         current.next = list2;
     *     }
     *
     *     return dummy.next;  // 返回哑节点的下一个节点，即真正的头节点
     * }
     * @param list1
     * @param list2
     * @return
     */
//    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
//
//        if (list1 == null && list2 == null) {
//            return null;
//        }
//        ListNode head = new ListNode();
//        while (list1 != null || list2 != null) {
//            if (list1 == null) {
//                head.next = list2;
//                break;
//            } else if (list2 == null) {
//                head.next = list1;
//                break;
//            } else if (list1.val < list2.val) {
//                head.next = list1;
//                list1 = list1.next;
//            } else{
//                head.next = list2;
//                list2 = list2.next;
//            }
//
//            head = head.next;
//
//        }
//
//        return head;
//    }
    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        if (list1 == null && list2 == null) {
            return null;
        }
        ListNode head = new ListNode();
        ListNode node = head;
        while (list1 != null || list2 != null) {
            if (list1 == null) {
                node.next = list2;
                break;
            } else if (list2 == null) {
                node.next = list1;
                break;
            } else if (list1.val < list2.val) {
                node.next = list1;
                list1 = list1.next;
            } else{
                node.next = list2;
                list2 = list2.next;
            }

            node = node.next;

        }

        return head.next;
    }



    public static void main(String[] args) {

        ListNode node5 = new ListNode(5, null);
        ListNode node4 = new ListNode(4, node5);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode node1 = new ListNode(1, node2);

        ListNode node10 = new ListNode(10, null);
        ListNode node9 = new ListNode(9, node10);
        ListNode node8 = new ListNode(8, node9);
        ListNode node7 = new ListNode(7, node8);
        ListNode node6 = new ListNode(6, node7);

        ListNode result = mergeTwoLists(node1, node6);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }
}
