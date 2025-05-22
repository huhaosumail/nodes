package com.hh.algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个不含重复数字的数组 nums ，
 * 返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
 *
 * 提示：
 *
 * 1 <= nums.length <= 6
 * -10 <= nums[i] <= 10
 * nums 中的所有整数 互不相同
 */
public class Permute {

    public List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();


        helper(nums, 0, res, list);

        return res;
    }

    /**
     * 递归全排列
     */
    private void helper(int[] nums,
                        int pos,
                        List<List<Integer>> res,
                        List<Integer> list) {
        int length = nums.length;
        // 如果已经递归到了最后一个元素
        if (length == pos) {
            // 那就将结果放入res
            res.add(new ArrayList<>(list));

            return ;
        }

        // 遍历数组
        for (int i = 0; i < length; i++) {
            // 如果当前元素已经在list当中
            if (list.contains(nums[i])) {
                // 那就直接跳过
                continue ;
            }

            // 将当前元素加入到list中
            list.add(nums[i]);
            // 递归，pos加1
            helper(nums, pos + 1, res, list);
            // 将当前元素移出list
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {

    }
}
