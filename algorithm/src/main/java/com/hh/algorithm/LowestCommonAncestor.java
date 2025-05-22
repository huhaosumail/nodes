package com.hh.algorithm;

/**
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 *
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个节点 p、q，最近公共祖先表示为一个节点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 *
 * 提示：
 *
 * 树中节点数目在范围 [2, 105] 内。 -109 <= Node.val <= 109 所有 Node.val 互不相同 。 p != q p 和 q 均存在于给定的二叉树中
 */
public class LowestCommonAncestor {

    public LevelOrder.TreeNode lowestCommonAncestor(LevelOrder.TreeNode root, LevelOrder.TreeNode p, LevelOrder.TreeNode q) {
        // 先序遍历
        if (root == null) {
            return null;
        }

        // 只要遇到了p或者q
        if (root == p || root == q) {
            // 则直接返回一个不为空的节点
            // 这里返回root节点
            return root;
        }

        // 然后先遍历左节点
        LevelOrder.TreeNode left = lowestCommonAncestor(root.left, p, q);
        // 再遍历右节点
        LevelOrder.TreeNode right = lowestCommonAncestor(root.right, p, q);

        // 如果遍历左右节点返回的结果都不为空
        // 则表示当前root节点就是p和q的最近公共祖先
        if (left != null && right != null) {
            // 直接返回root
            return root;
        }

        // 否则返回遍历左右节点不为空的结果
        return left != null ? left : right;
    }

    public static void main(String[] args) {

    }
}
