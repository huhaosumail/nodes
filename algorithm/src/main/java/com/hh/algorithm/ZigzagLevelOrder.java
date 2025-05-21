package com.hh.algorithm;

import java.util.List;

/**
 * 给你二叉树的根节点 root ，返回其节点值的 锯齿形层序遍历 。
 * （即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 *
 * 提示：
 *
 * 树中节点数目在范围 [0, 2000] 内
 * -100 <= Node.val <= 100
 */
public class ZigzagLevelOrder {

    public static List<List<Integer>> zigzagLevelOrder(LevelOrder.TreeNode root) {



    }
    public static void main(String[] args) {

        // 手动构建二叉树
        LevelOrder.TreeNode root = new LevelOrder.TreeNode(3);
        root.left = new LevelOrder.TreeNode(9);
        root.right = new LevelOrder.TreeNode(20);
        root.right.left = new LevelOrder.TreeNode(15);
        root.right.right = new LevelOrder.TreeNode(7);

        // 层序遍历输出
        System.out.print("层序遍历结果: ");
        List<List<Integer>>  list = zigzagLevelOrder(root);
        list.forEach(System.out::println);
    }
}
