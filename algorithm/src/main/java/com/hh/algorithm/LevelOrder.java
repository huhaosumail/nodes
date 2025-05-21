package com.hh.algorithm;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 给你二叉树的根节点 root ，返回其节点值的 层序遍历 。 （即逐层地，从左到右访问所有节点）。
 *
 * 提示：
 *
 * 树中节点数目在范围 [0, 2000] 内
 * -1000 <= Node.val <= 1000
 */
public class LevelOrder {

    public static class TreeNode{
        public TreeNode left;
        public TreeNode right;
        public int val;
        public TreeNode(){

        }
        public TreeNode(int val){
            this.val = val;
        }
        public TreeNode(TreeNode left,TreeNode right, int val){
            this.left = left;
            this.right = right;
            this.val = val;
        }
    }

    public static List<List<Integer>>  levelOrder(TreeNode  root){
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        // 利用队列实现层序遍历
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.addFirst(root);

        while (!queue.isEmpty()) {
            // 因为每一层都需要放在一个集合中
            // 所以这里先把同一层的节点放到list中
            List<TreeNode> list = new ArrayList<>();
            // 遍历队列
            while (!queue.isEmpty()) {
                // 将队列中的元素放入list中
                // 这里就是将同一层到节点放入到list中
                list.add(queue.removeLast());
            }

            List<Integer> nums = new ArrayList<>();
            // 然后再遍历这一层的节点
            for (TreeNode node : list) {
                // 当前节点值放入nums集合中
                nums.add(node.val);

                // 如果当前节点左节点不为空
                if (node.left != null) {
                    // 就将左节点放入队列中
                    queue.addFirst(node.left);
                }

                // 如果当前节点右节点不为空
                if (node.right != null) {
                    // 就将右节点放入队列中
                    queue.addFirst(node.right);
                }
            }

            // 将当前层的结果放入res中
            res.add(nums);
        }

        // 返回结果
        return res;
    }

    public static void main(String[] args) {
        // 手动构建二叉树
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        // 层序遍历输出
        System.out.print("层序遍历结果: ");
        List<List<Integer>>  list = levelOrder(root);
        list.forEach(System.out::println);
    }


}
