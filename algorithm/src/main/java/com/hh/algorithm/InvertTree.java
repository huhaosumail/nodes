package com.hh.algorithm;

/**
 * 给你一棵二叉树的根节点 root ，翻转这棵二叉树，并返回其根节点。
 * <p>
 * 提示：
 * <p>
 * 树中节点数目范围在 [0, 100] 内
 * -100 <= Node.val <= 100
 * <p>
 * 输入二叉树：
 * plaintext
 * 4
 * /   \
 * 2     7
 * / \   / \
 * 1   3 6   9
 * <p>
 * 翻转后：
 * plaintext
 * 4
 * /   \
 * 7     2
 * / \   / \
 * 9   6 3   1
 */
public class InvertTree {

    public static LevelOrder.TreeNode invertTree(LevelOrder.TreeNode root) {

        if (root == null) {
            return null;
        }
        LevelOrder.TreeNode left = root.left;
        root.left = invertTree(root.right);
        root.right = invertTree(left);
        return root;

    }

    public static void main(String[] args) {

    }
}
