package com.hh.algorithm;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 给你二叉树的根节点 root ，返回其节点值的 层序遍历 。 （即逐层地，从左到右访问所有节点）。
 * <p>
 * 提示：
 * <p>
 * 树中节点数目在范围 [0, 2000] 内
 * -1000 <= Node.val <= 1000
 */

/**
 * 考虑以下二叉树：
 * plaintext
 * 1
 * / \
 * 2   3
 * / \   \
 * 4   5   6
 * /
 * 7
 * <p>
 * 层序遍历结果：
 * plaintext
 * [
 * [1],       # 第一层
 * [2, 3],    # 第二层
 * [4, 5, 6], # 第三层
 * [7]        # 第四层
 * ]
 */
public class LevelOrder {

    public static class TreeNode {
        public TreeNode left;
        public TreeNode right;
        public int val;

        public TreeNode() {

        }

        public TreeNode(int val) {
            this.val = val;
        }

        public TreeNode(TreeNode left, TreeNode right, int val) {
            this.left = left;
            this.right = right;
            this.val = val;
        }
    }

    /**
     * Queue 是队列，先进先出（FIFO），而 Stack 是栈，后进先出（LIFO）。这是最核心的区别。接下来，用户可能需要了解它们的操作方法、使用场景以及实现方式的不同。
     * 首先，操作方面，队列的主要操作是入队（enqueue）和出队（dequeue），通常对应 offer 和 poll 方法。而栈的主要操作是压栈（push）和弹栈（pop），
     * 还有 peek 查看栈顶元素。需要区分它们的方法名称和行为，比如队列的头部是最先插入的元素，而栈的顶部是最后插入的元素。
     * 然后，数据结构的实现方面，队列可以用链表或数组实现，比如 LinkedList 和 ArrayDeque 都可以作为队列。
     * 栈通常用数组（如 Java 的 Stack 类，不过现在更推荐用 Deque 的实现类如 ArrayDeque）或者链表实现。
     * 需要提到 Java 中推荐使用 Deque 接口来实现栈和队列，因为 Stack 类是遗留类，可能有性能问题。
     *
     * 这里层序遍历是左边开始。先进先出。
     * @param root
     * @return
     */
    public static List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        queue.offer(root);
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Integer> curr = new ArrayList<>();

            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.remove();
                curr.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            result.add(curr);
        }

        return result;
    }

    public static void main(String[] args) {
        // 手动构建二叉树
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        // 层序遍历输出
        System.out.print("层序遍历结果: ");
        List<List<Integer>> list = levelOrder(root);
        list.forEach(System.out::println);
    }


}
