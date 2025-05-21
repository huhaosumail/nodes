package com.hh.algorithm;

/**
 * 反转琏表
 */
public class ReverseList {


    /**
     * 迭代
     * @param listNode
     * @return
     */
    static ReverseKGroup.ListNode reverseList(ReverseKGroup.ListNode listNode){
        // 前驱节点初始为null
        ReverseKGroup.ListNode prev = null;
        // 当前节点用cur表示
        ReverseKGroup.ListNode cur = listNode;
        // 用temp暂存下一个节点
        ReverseKGroup.ListNode temp;
        while (cur != null) {
            // 获取下一个节点
            temp = cur.next;
            // 把当前节点的 next 指针指向其前驱节点
            cur.next = prev;
            // 把前驱节点指针指向当前节点
            prev = cur;
            // 把当前节点指针指向其下一个节点
            cur = temp;
        }
        // 注意最后返回的是prev
        return prev;
    }
    public static void main(String[] args) {

        ReverseKGroup.ListNode listNode5 = new ReverseKGroup.ListNode(5,null);
        ReverseKGroup.ListNode listNode4 = new ReverseKGroup.ListNode(4,listNode5);
        ReverseKGroup.ListNode listNode3 = new ReverseKGroup.ListNode(3,listNode4);
        ReverseKGroup.ListNode listNode2 = new ReverseKGroup.ListNode(2,listNode3);
        ReverseKGroup.ListNode listNode1 = new ReverseKGroup.ListNode(1,listNode2);

        ReverseKGroup.ListNode result = reverseList(listNode1);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }


    }




}

