package com.hh.algorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 给定一个二叉树的根节点 root ，返回 它的 中序 遍历 。
 *
 * 提示：
 *
 * 树中节点数目在范围 [0, 100] 内
 * -100 <= Node.val <= 100
 *
 * 对于二叉树：
 * plaintext
 *     1
 *    / \
 *   2   3
 *  / \
 * 4   5
 *
 * 中序遍历结果为：[4, 2, 5, 1, 3]。
 */
public class InorderTraversal {

    public List<Integer> inorderTraversal(LevelOrder.TreeNode root) {

        if(root == null){
            return new ArrayList<>();
        }
        List<Integer> list = new ArrayList<>();
        inorderTraversal(root,list);
        return list;
    }

    /**
     * 中序遍历
     */
    private void inorderTraversal(LevelOrder.TreeNode root, List<Integer> list) {
        //这里一定要判断 不然无法跳出，或者抛异常
        if(root == null){
            return;
        }
        inorderTraversal(root.left,list);
        list.add(root.val);
        inorderTraversal(root.right,list);

    }

    /**
     * 示例演示
     * 对于二叉树：
     * plaintext
     *     1
     *    / \
     *   2   3
     *  / \
     * 4   5
     * 遍历过程：
     * 初始状态：
     * curr = 1, stack = []
     * 第一次循环：
     * 将 1 → 2 → 4 依次压入栈：stack = [1, 2, 4]
     * curr 变为 null（4 的左子节点）
     * 弹出栈顶 4 并访问 → 结果：[4]
     * curr 转向 4 的右子节点（null）
     * 第二次循环：
     * curr = null，跳过内层循环
     * 弹出栈顶 2 并访问 → 结果：[4, 2]
     * curr 转向 2 的右子节点（5）
     * 第三次循环：
     * 将 5 压入栈：stack = [1, 5]
     * curr 变为 null（5 的左子节点）
     * 弹出栈顶 5 并访问 → 结果：[4, 2, 5]
     * curr 转向 5 的右子节点（null）
     * 第四次循环：
     * curr = null，跳过内层循环
     * 弹出栈顶 1 并访问 → 结果：[4, 2, 5, 1]
     * curr 转向 1 的右子节点（3）
     * 第五次循环：
     * 将 3 压入栈：stack = [3]
     * curr 变为 null（3 的左子节点）
     * 弹出栈顶 3 并访问 → 结果：[4, 2, 5, 1, 3]
     * curr 转向 3 的右子节点（null）
     * 结束条件：
     * curr = null 且 stack = []，循环结束。
     * @param root
     * @return
     */
    public List<Integer> inorderStackTraversal(LevelOrder.TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<LevelOrder.TreeNode> stack = new Stack<>();
        LevelOrder.TreeNode curr = root;

        while (curr != null || !stack.isEmpty()) {
            // 1. 遍历到最左节点，将路径上的所有节点入栈
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            // 2. 弹出栈顶节点并访问
            curr = stack.pop();
            result.add(curr.val);
            // 3. 转向右子树
            curr = curr.right;
        }

        return result;
    }

    public static void main(String[] args) {

    }
}
