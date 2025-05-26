package com.hh.algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你二叉树的根节点 root 和一个整数目标和 targetSum ，找出所有 从根节点到叶子节点 路径总和等于给定目标和的路径。
 *
 * 叶子节点 是指没有子节点的节点。
 *
 * 提示：
 *
 * 树中节点总数在范围 [0, 5000] 内
 * -1000 <= Node.val <= 1000
 * -1000 <= targetSum <= 1000
 */
public class PathSum {

    public static List<List<Integer>> pathSum(LevelOrder.TreeNode root, int targetSum) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        // 保存从根节点到叶子节点的路径
        List<Integer> list = new ArrayList<>();

        // 先序遍历
        pathSum(root, targetSum, 0, res, list);

        return res;
    }

    /**
     * 先序遍历
     * sum：当前路径总和
     * res：路径总和等于targetSum的路径
     * list：当前从根节点到叶子节点的路径
     */
    private static void pathSum(LevelOrder.TreeNode root, int targetSum, int sum, List<List<Integer>> res, List<Integer> list) {
        // 先将当前节点值加入路径总和
        sum += root.val;
        // 并将节点值加入路径
        list.add(root.val);

        if (root.left == null && root.right == null) {
            // 如果当前是叶子节点
            if (targetSum == sum) {
                // 且当前路径总和等于targetSum
                // 那么将结果加入res集合
                res.add(new ArrayList<>(list));
            }

            // 叶子节点终止递归
            return ;
        }

        // 递归左节点
        if (root.left != null) {
            pathSum(root.left, targetSum, sum, res, list);

            // 回溯时要删除加入到list路径中的左节点
            list.remove(list.size() - 1);
        }

        // 递归右节点
        if (root.right != null) {
            pathSum(root.right, targetSum, sum, res, list);

            // 回溯时要删除加入到list路径中的右节点
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {

    }
}
