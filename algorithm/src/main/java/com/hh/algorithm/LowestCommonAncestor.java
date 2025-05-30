package com.hh.algorithm;

/**
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 * <p>
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个节点 p、q，最近公共祖先表示为一个节点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 * <p>
 * 提示：
 * <p>
 * 树中节点数目在范围 [2, 105] 内。 -109 <= Node.val <= 109 所有 Node.val 互不相同 。 p != q p 和 q 均存在于给定的二叉树中
 */
public class LowestCommonAncestor {

    public LevelOrder.TreeNode lowestCommonAncestor(LevelOrder.TreeNode root, LevelOrder.TreeNode p, LevelOrder.TreeNode q) {

        if (root == null || root == p || root == q) {
            return root;
        }
        LevelOrder.TreeNode left = lowestCommonAncestor(root.left, p, q);
        LevelOrder.TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null) {
            return root;
        }
        return left != null ? left : right;
    }

    public static void main(String[] args) {

    }
}
