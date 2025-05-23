package com.hh.algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个二叉树的根节点 root ，返回 它的 中序 遍历 。
 *
 * 提示：
 *
 * 树中节点数目在范围 [0, 100] 内
 * -100 <= Node.val <= 100
 */
public class InorderTraversal {

    public List<Integer> inorderTraversal(LevelOrder.TreeNode root) {
        List<Integer> list = new ArrayList<>();

        // 中序遍历
        inorderTraversal(root, list);

        return list;
    }

    /**
     * 中序遍历
     */
    private void inorderTraversal(LevelOrder.TreeNode root, List<Integer> list) {
        if (root == null) {
            return ;
        }

        // 先遍历左节点
        inorderTraversal(root.left, list);

        // 再遍历当前节点
        list.add(root.val);

        // 最后遍历右节点
        inorderTraversal(root.right, list);
    }

    public static void main(String[] args) {

    }
}
