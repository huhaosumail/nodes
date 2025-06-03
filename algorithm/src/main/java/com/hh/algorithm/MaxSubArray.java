package com.hh.algorithm;

/**
 * 给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * <p>
 * 子数组 是数组中的一个连续部分。
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 105
 * -104 <= nums[i] <= 104
 */
public class MaxSubArray {

    public static int maxSubArray(int[] nums) {

        /**
         * 1.初始化错误：max 初始化为 0，但数组可能全为负数，此时正确结果应为最大的负数（如 [-2, -1] 的结果应为 -1）。
         * 2.逻辑错误：条件 if (nums[i] > 0) 限制了只有当当前元素为正数时才更新 max，但连续子数组可能包含负数（如 [-2, 3, -1] 的最大和为 3 + (-1) = 2）。
         * 3.状态丢失：代码只考虑了 nums[i-1] + nums[i]，但真正的最大子数组可能更长（如 [1, 2, 3] 的最大和为 6，而非相邻两数之和）。
         */
//        int max = 0;
//        for (int i = 1; i < nums.length; i++) {
//
//            if (nums[i] > 0) {
//                max = Math.max(nums[i - 1] + nums[i], max);
//            }
//
//        }
//        return max;
        int max = nums[0];
        int pre = 0;
        for (int i = 0; i < nums.length; i++) {
            //如果pre为负的 则从当前数组开始重新组装子数组
            pre = Math.max(nums[i] + pre, nums[i]);
            //整体的最大值
            max = Math.max(pre, max);

        }
        return max;

    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, -1};

        System.out.println(maxSubArray(nums));
    }
}
