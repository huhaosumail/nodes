package com.hh.algorithm;

import java.util.HashSet;
import java.util.Set;

/**
 * 给你两个单链表的头节点 headA 和 headB ，请你找出并返回两个单链表相交的起始节点。如果两个链表不存在相交节点，返回 null 。
 * <p>
 * 图示两个链表在节点 c1 开始相交：
 * <p>
 * img
 * <p>
 * 题目数据 保证 整个链式结构中不存在环。
 * <p>
 * 注意，函数返回结果后，链表必须 保持其原始结构 。
 * <p>
 * 自定义评测：
 * <p>
 * 评测系统 的输入如下（你设计的程序 不适用 此输入）：
 * <p>
 * intersectVal - 相交的起始节点的值。如果不存在相交节点，这一值为 0 listA - 第一个链表 listB - 第二个链表 skipA - 在 listA 中（从头节点开始）跳到交叉节点的节点数 skipB - 在 listB 中（从头节点开始）跳到交叉节点的节点数 评测系统将根据这些输入创建链式数据结构，并将两个头节点 headA 和 headB 传递给你的程序。如果程序能够正确返回相交节点，那么你的解决方案将被 视作正确答案 。
 * <p>
 * 提示：
 * <p>
 * listA 中节点数目为 m listB 中节点数目为 n 1 <= m, n <= 3 * 104 1 <= Node.val <= 105 0 <= skipA <= m 0 <= skipB <= n 如果 listA 和 listB 没有交点，intersectVal 为 0 如果 listA 和 listB 有交点，intersectVal == listA[skipA] == listB[skipB]
 */
public class GetIntersectionNode {

    public static ReverseKGroup.ListNode getIntersectionNode(ReverseKGroup.ListNode headA, ReverseKGroup.ListNode headB) {
        // 如果headA或者headB其中一个为null
        // 那么它们必然不会相交，所以直接返回null
        if (headA == null || headB == null) {
            return null;
        }

        // 利用Set集合保存headA链表的所有节点
        Set<ReverseKGroup.ListNode> set = new HashSet<>();
        ReverseKGroup.ListNode node = headA;
        // 遍历headA将节点放入set集合中
        while (node != null) {
            set.add(node);

            node = node.next;
        }

        node = headB;
        // 再遍历headB
        // 并判断headB中是否有和set中相同的节点
        while (node != null) {
            // 如果有相同的节点
            if (set.contains(node)) {
                // 那么第一个相同的节点就是相交节点
                // 直接返回
                return node;
            }

            // 跳到下一个节点
            node = node.next;
        }

        return null;

    }

    public static void main(String[] args) {

        ReverseKGroup.ListNode node5 = new ReverseKGroup.ListNode(5, null);
        ReverseKGroup.ListNode node4 = new ReverseKGroup.ListNode(4, node5);
        ReverseKGroup.ListNode node3 = new ReverseKGroup.ListNode(3, node4);
        ReverseKGroup.ListNode node2 = new ReverseKGroup.ListNode(2, node3);
        ReverseKGroup.ListNode node1 = new ReverseKGroup.ListNode(1, node2);

        ReverseKGroup.ListNode node10 = new ReverseKGroup.ListNode(10, null);
        ReverseKGroup.ListNode node9 = new ReverseKGroup.ListNode(9, node10);
        ReverseKGroup.ListNode node8 = new ReverseKGroup.ListNode(8, node9);
        ReverseKGroup.ListNode node7 = new ReverseKGroup.ListNode(7, node8);
        ReverseKGroup.ListNode node6 = new ReverseKGroup.ListNode(6, node7);

        ReverseKGroup.ListNode result = getIntersectionNode(node1, node6);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }
}
