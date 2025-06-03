package com.hh.algorithm;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * 给你二叉树的根节点 root ，返回其节点值的 锯齿形层序遍历 。
 * （即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 * <p>
 * 提示：
 * <p>
 * 树中节点数目在范围 [0, 2000] 内
 * -100 <= Node.val <= 100
 */
public class ZigzagLevelOrder {

    public static List<List<Integer>> zigzagLevelOrder(LevelOrder.TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        LinkedList<LevelOrder.TreeNode> stack = new LinkedList<>();

        stack.push(root);
        // true：表示从左往右
        // false：表示从右往左
        boolean flag = true;
        while (!stack.isEmpty()) {
            // 因为每一层都需要放在一个集合中
            // 所以这里先把同一层的节点放到list中
            List<LevelOrder.TreeNode> list = new ArrayList<>();
            while (!stack.isEmpty()) {
                // 将栈中的元素放入list中
                // 这里就是将同一层到节点放入到list中
                list.add(stack.pop());
            }
            List<Integer> nums = new ArrayList<>();
            // 然后再遍历这一层的节点
            for (LevelOrder.TreeNode node : list) {
                nums.add(node.val);
                if (flag) {
                    if (node.left != null) {
                        stack.push(node.left);
                    }

                    if (node.right != null) {
                        stack.push(node.right);
                    }
                } else {
                    if (node.right != null) {
                        stack.push(node.right);
                    }
                    if (node.left != null) {
                        stack.push(node.left);
                    }
                }
            }
            flag = !flag;
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
        List<List<Integer>> list = zigzagLevelOrder(root);
        list.forEach(System.out::println);
    }
}
