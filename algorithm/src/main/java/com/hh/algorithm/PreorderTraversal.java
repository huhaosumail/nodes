package com.hh.algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你二叉树的根节点 root ，返回它节点值的 前序 遍历。
 * <p>
 * 提示：
 * <p>
 * 树中节点数目在范围 [0, 100] 内
 * -100 <= Node.val <= 100
 *
 *     1
 *    / \
 *   2   3
 *  / \   \
 * 4   5   6
 *
 * 先序结果[1, 2, 4, 5, 3, 6]
 */
public class PreorderTraversal {

    public static List<Integer> preorderTraversal(LevelOrder.TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<Integer> res = new ArrayList<>();
        preorderTraversal(root, res);
        return res;
    }

    private static void preorderTraversal(LevelOrder.TreeNode root, List<Integer> res) {

        if(root == null){
            return;
        }
        res.add(root.val);
        preorderTraversal(root.left,res);
        preorderTraversal(root.right,res);
    }

    public static void main(String[] args) {

    }
}
