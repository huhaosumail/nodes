package com.hh.algorithm;

import java.util.HashSet;

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
        if (headA == null || headB == null) {
            return null;
        }
        HashSet<ReverseKGroup.ListNode> set = new HashSet<>();

        while (headA != null) {
            set.add(headA);
            headA = headA.next;
        }

        while (headB != null) {
            //相交判定：必须基于节点引用，而非节点值。
            if(set.contains(headB)){
                return headB;
            }
            headB = headB.next;
        }
        return null;
    }

    /**
     * 使用两个指针 pA 和 pB 分别从链表 A 和 B 的头节点出发。
     * 当一个指针到达链表末尾时，将其重定向到另一个链表的头节点。若两链表相交，则指针最终会在相交节点相遇；若不相交，则会同时到达 null。
     * @param headA
     * @param headB
     * @return
     */
    public ReverseKGroup.ListNode getAnotherIntersectionNode(ReverseKGroup.ListNode headA, ReverseKGroup.ListNode headB) {
        ReverseKGroup.ListNode pA = headA, pB = headB;
        while (pA != pB) {
            // 指针 pA 遍历完 A 后转向 B
            pA = (pA == null) ? headB : pA.next;
            // 指针 pB 遍历完 B 后转向 A
            pB = (pB == null) ? headA : pB.next;
        }
        return pA; // 相交节点或 null（不相交时）
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
