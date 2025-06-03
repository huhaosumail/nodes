package com.hh.algorithm;

/**
 * 反转琏表
 */
public class ReverseAList {


    /**
     * 迭代
     * 三指针迭代法
     * @return
     */
    public static ReverseKGroup.ListNode reverseList(ReverseKGroup.ListNode head) {

        ReverseKGroup.ListNode prev = null; //前指针节点
        ReverseKGroup.ListNode curr = head; //当前指针节点
        ReverseKGroup.ListNode next;
        //每次循环，都将当前节点指向它前面的节点
        //然后当前节点和前节点后移
        while (curr != null) {
            //临时节点，暂存当前节点的下一节点，用于后移
            //因为接下来curr.next进行赋值后将会断链 这里最主要的是断琏 并保存
            next = curr.next;
            //将当前节点指向它前面的节点
            curr.next = prev;
            //前指针后移
            prev = curr;
            //当前指针后移
            curr = next;
        }
        //循环结束后，prev 指向反转后的链表头节点，返回prev 为啥不用curr 其实也是行的 得用curr.pre就可以
        //因为循环里面当前指针后移这里面没办法处理了
        //curr = next;
        return prev;

    }

    /**
     * 头插法
     * @param head
     * @return
     */
    public ReverseKGroup.ListNode reverseAnotherList(ReverseKGroup.ListNode head) {
        // 创建newHead作为新链表的头节点
        ReverseKGroup.ListNode newHead = new ReverseKGroup.ListNode();

        // 临时节点
        ReverseKGroup.ListNode node = head;
        // 开始迭代
        while (node != null) {
            // 当前节点
            ReverseKGroup.ListNode cur = node;
            // 临时节点指向下一个节点
            node = node.next;

            // 让当前节点指向newHead的next节点
            cur.next = newHead.next;
            // newHead的next节点指向当前节点
            // 这样就把当前节点拼到了前继节点的前面
            newHead.next = cur;
        }

        // 返回新链表
        return newHead.next;
    }

    public static void main(String[] args) {

        ReverseKGroup.ListNode listNode5 = new ReverseKGroup.ListNode(5, null);
        ReverseKGroup.ListNode listNode4 = new ReverseKGroup.ListNode(4, listNode5);
        ReverseKGroup.ListNode listNode3 = new ReverseKGroup.ListNode(3, listNode4);
        ReverseKGroup.ListNode listNode2 = new ReverseKGroup.ListNode(2, listNode3);
        ReverseKGroup.ListNode listNode1 = new ReverseKGroup.ListNode(1, listNode2);

        ReverseKGroup.ListNode result = reverseList(listNode1);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }


    }


}

