package com.hh.algorithm;

/**
 * 给你二叉树的根节点 root 和一个表示目标和的整数 targetSum 。判断该树中是否存在 根节点到叶子节点 的路径，这条路径上所有节点值相加等于目标和 targetSum 。如果存在，返回 true ；否则，返回 false 。
 *
 * 叶子节点 是指没有子节点的节点。
 *
 * 提示：
 *
 * 树中节点的数目在范围 [0, 5000] 内
 * -1000 <= Node.val <= 1000
 * -1000 <= targetSum <= 1000
 */
public class HasPathSum {

    public static boolean hasPathSum(LevelOrder.TreeNode root, int targetSum) {
        if (root == null) {
            // 递归到空节点直接返回
            return false;
        }

        // targetSum当前节点值
        targetSum -= root.val;
        if (targetSum == 0 && root.left == null && root.right == null) {
            // 如果targetSum等于0
            // 且当前为叶子节点
            // 则返回true
            return true;
        }

        // 继续递归左右子节点
        return hasPathSum(root.left, targetSum) || hasPathSum(root.right, targetSum);
    }

    public static void main(String[] args) {

    }
}
