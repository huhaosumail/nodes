package com.hh.algorithm;

import java.util.HashMap;
import java.util.Map;

/**
 * 给你一个链表的头节点 head ，判断链表中是否有环。
 *
 * 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。 为了表示给定链表中的环，评测系统内部使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。注意：pos 不作为参数进行传递 。仅仅是为了标识链表的实际情况。
 *
 * 如果链表中存在环 ，则返回 true 。 否则，返回 false 。
 *
 * 提示：
 *
 * 链表中节点的数目范围是 [0, 104]
 * -105 <= Node.val <= 105
 * pos 为 -1 或者链表中的一个 有效索引 。
 */
public class HasCycle {

//    public static boolean hasHashCycle(ReverseKGroup.ListNode head){
//
//        Map<Integer, ReverseKGroup.ListNode> map = new HashMap<>();
//        while(head != null){
//            if(map.containsKey(head.val)){
//                return true;
//            }
//            map.put(head.val,head);
//            head = head.next;
//        }
//        return false;
//
//    }

    /**
     * 快慢指针
     * @param head
     * @return
     */
    public static boolean hasCycle(ReverseKGroup.ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }

        // 利用快慢指针来判断链表中是否有环
        ReverseKGroup.ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            // 慢指针跳一个节点
            slow = slow.next;
            // 快指针跳两个节点
            fast = fast.next.next;

            // 如果有环，快慢指针最终会相遇
            if (slow == fast) {
                // 直接返回true
                return true;
            }
        }

        // 否则返回false
        return false;
    }
    public static void main(String[] args) {

        ReverseKGroup.ListNode node5 = new ReverseKGroup.ListNode(5,null);
        ReverseKGroup.ListNode node4 = new ReverseKGroup.ListNode(4,node5);
        ReverseKGroup.ListNode node3 = new ReverseKGroup.ListNode(5,node4);
        ReverseKGroup.ListNode node2 = new ReverseKGroup.ListNode(2,node3);
        ReverseKGroup.ListNode node1 = new ReverseKGroup.ListNode(1,node2);
        System.out.println(hasCycle(node1));
    }
}
