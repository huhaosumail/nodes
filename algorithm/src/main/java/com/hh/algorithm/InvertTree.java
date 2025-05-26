package com.hh.algorithm;

/**
 * 给你一棵二叉树的根节点 root ，翻转这棵二叉树，并返回其根节点。
 *
 * 提示：
 *
 * 树中节点数目范围在 [0, 100] 内
 * -100 <= Node.val <= 100
 */
public class InvertTree {

    public static LevelOrder.TreeNode invertTree(LevelOrder.TreeNode root) {
        if (root == null) {
            return root;
        }

        // 先暂存left节点
        LevelOrder.TreeNode left = root.left;
        // 然后left == right，这里传right也会返回right
        root.left = invertTree(root.right);
        // right == left，这里传left也会返回left
        root.right = invertTree(left);

        // 返回当前节点即可
        return root;
    }

    public static void main(String[] args) {

    }
}
