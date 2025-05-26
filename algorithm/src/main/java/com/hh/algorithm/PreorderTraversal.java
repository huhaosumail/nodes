package com.hh.algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 *给你二叉树的根节点 root ，返回它节点值的 前序 遍历。
 *
 * 提示：
 *
 * 树中节点数目在范围 [0, 100] 内
 * -100 <= Node.val <= 100
 */
public class PreorderTraversal {

    public static List<Integer> preorderTraversal(LevelOrder.TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        // 前序遍历
        preorderTraversal(root, res);

        return res;
    }

    /**
     * 前序遍历
     */
    private static void preorderTraversal(LevelOrder.TreeNode root, List<Integer> res) {
        if (root == null) {
            return ;
        }

        // 前遍历当前节点
        res.add(root.val);

        // 再遍历左右子节点
        preorderTraversal(root.left, res);
        preorderTraversal(root.right, res);
    }
    public static void main(String[] args) {

    }
}
