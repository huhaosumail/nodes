package com.hh.algorithm;

/**
 * 反转琏表
 */
public class ReverseList {

    static class ListNode{
        private int val;
        private ListNode next;
        public ListNode(int val,ListNode next){
            this.val = val;
            this.next = next;
        }
    }

    /**
     * 迭代
     * @param listNode
     * @return
     */
    static ListNode reverseList(ListNode listNode){
        // 前驱节点初始为null
        ListNode prev = null;
        // 当前节点用cur表示
        ListNode cur = listNode;
        // 用temp暂存下一个节点
        ListNode temp;
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

        ListNode listNode5 = new ListNode(5,null);
        ListNode listNode4 = new ListNode(4,listNode5);
        ListNode listNode3 = new ListNode(3,listNode4);
        ListNode listNode2 = new ListNode(2,listNode3);
        ListNode listNode1 = new ListNode(1,listNode2);

        ListNode result = reverseList(listNode1);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }


    }




}

