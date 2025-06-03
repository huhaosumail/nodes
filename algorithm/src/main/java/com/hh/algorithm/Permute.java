package com.hh.algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个不含重复数字的数组 nums ，
 * 返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
 * 全排列 注意就是不包含子串的
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 6
 * -10 <= nums[i] <= 10
 * nums 中的所有整数 互不相同
 */

/**
 * 回溯的标准表达式
 * def backtrack(路径, 选择列表):
 *     if 满足终止条件:
 *         记录结果
 *         return
 *     for 选择 in 选择列表:
 *         做选择（修改路径和状态）
 *         backtrack(路径, 新的选择列表)
 *         撤销选择（恢复路径和状态）
 */
public class Permute {

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        helper(nums, 0, res, list);

        return res;
    }

    /**
     * [[1, 2, 3, 4], [1, 2, 4, 3], [1, 3, 2, 4], [1, 3, 4, 2], [1, 4, 2, 3], [1, 4, 3, 2], [2, 1, 3, 4], [2, 1, 4, 3], [2, 3, 1, 4], [2, 3, 4, 1], [2, 4, 1, 3], [2, 4, 3, 1], [3, 1, 2, 4], [3, 1, 4, 2], [3, 2, 1, 4], [3, 2, 4, 1], [3, 4, 1, 2], [3, 4, 2, 1], [4, 1, 2, 3], [4, 1, 3, 2], [4, 2, 1, 3], [4, 2, 3, 1], [4, 3, 1, 2], [4, 3, 2, 1]]
     注意看结果集
     场景：走迷宫
     假设你在一个迷宫中，需要从起点走到终点。每到一个岔路口，你选择一条路走下去：
     做选择：选择一条分支路径，标记为 “已走”。
     递归深入：沿着这条路径继续走，直到遇到死胡同或终点。
     回溯（回退）：如果遇到死胡同，撤销当前选择（清除 “已走” 标记），回到上一个岔路口，尝试其他分支。
     关键点：
     每一步选择都会产生新的状态（位置变化）。
     当发现当前路径无法到达终点时，必须回退到之前的状态，尝试其他可能性。
     最终可能找到一条有效路径，或者遍历所有路径后确认无解。
     场景：排列组合（全排列问题）
     想象你有三个不同的球（1、2、3），需要把它们排成一列：
     第一层选择：先选第一个球（可以是 1、2、3）。
     第二层选择：在剩下的球中选第二个球（例如，若第一层选了 1，第二层只能选 2 或 3）。
     第三层选择：选最后一个球（只剩一个选项）。
     回溯：当第三层完成一个排列（如 1→2→3），需要回退到第二层，尝试其他选择（如 1→3→2），再回退到第一层，尝试其他初始选择（如 2→1→3，2→3→1，3→1→2，3→2→1）。
     * @param nums
     * @param pos
     * @param res
     * @param list
     */
    private static void helper(int[] nums, int pos, List<List<Integer>> res, List<Integer> list) {

        int length = nums.length;
        // 如果已经递归到了最后一个元素 这里不是最后一个元素。其实已经结束了。
        if (length == pos) {
            // 那就将结果放入res
            res.add(new ArrayList<>(list));

            return;
        }

        for (int i = 0; i < length; i++) {

            if (list.contains(nums[i])) {
                continue;
            }
            list.add(nums[i]);

            helper(nums, pos + 1, res, list);
            //递归之后回溯的重要逻辑 将当前元素移出list
            list.remove(list.size() - 1);
        }


    }


    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        List<List<Integer>> list = permute(nums);

        System.out.println(list);
    }
}
