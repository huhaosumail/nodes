package com.hh.algorithm;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 给你二叉树的根节点 root ，返回其节点值的 锯齿形层序遍历 。
 * （即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 *
 * 提示：
 *
 * 树中节点数目在范围 [0, 2000] 内
 * -100 <= Node.val <= 100
 */
public class ZigzagLevelOrder {

    public static List<List<Integer>> zigzagLevelOrder(LevelOrder.TreeNode root) {

        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        // 利用栈实现层序遍历
        LinkedList<LevelOrder.TreeNode> stack = new LinkedList<>();
        stack.addFirst(root);

        // true：表示从左往右
        // false：表示从右往左
        boolean flag = true;
        while (!stack.isEmpty()) {
            // 因为每一层都需要放在一个集合中
            // 所以这里先把同一层的节点放到list中
            List<LevelOrder.TreeNode> list = new ArrayList<>();
            // 遍历队列
            while (!stack.isEmpty()) {
                // 将栈中的元素放入list中
                // 这里就是将同一层到节点放入到list中
                list.add(stack.removeFirst());
            }

            List<Integer> nums = new ArrayList<>();
            // 然后再遍历这一层的节点
            for (LevelOrder.TreeNode node : list) {
                // 当前节点值放入nums集合中
                nums.add(node.val);

                if (flag) { // 如果当前是从左往右
                    // 则先将left入栈
                    if (node.left != null) {
                        stack.addFirst(node.left);
                    }
                    // 再将right入栈
                    if (node.right != null) {
                        stack.addFirst(node.right);
                    }
                } else { // 如果当前是从右往左
                    // 则先将right入栈
                    if (node.right != null) {
                        stack.addFirst(node.right);
                    }
                    // 再将left入栈
                    if (node.left != null) {
                        stack.addFirst(node.left);
                    }
                }
            }

            // 变换方向
            flag = !flag;
            // 将当前层的结果放入res中
            res.add(nums);
        }

        return res;


    }
    public static void main(String[] args) {

        // 手动构建二叉树
        LevelOrder.TreeNode root = new LevelOrder.TreeNode(3);
        root.left = new LevelOrder.TreeNode(9);
        root.right = new LevelOrder.TreeNode(20);
        root.right.left = new LevelOrder.TreeNode(15);
        root.right.right = new LevelOrder.TreeNode(7);

        // 层序遍历输出
        System.out.print("层序遍历结果: ");
        List<List<Integer>>  list = zigzagLevelOrder(root);
        list.forEach(System.out::println);
    }
}
