package com.hh.algorithm;

/**
 * 给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 *
 * 子数组 是数组中的一个连续部分。
 *
 * 提示：
 *
 * 1 <= nums.length <= 105
 * -104 <= nums[i] <= 104
 */
public class MaxSubArray {

    public static int maxSubArray(int[] nums) {
        // max记录最大值
        // pre记录连续子数组的和
        int max = nums[0], pre = 0;
        for (int num : nums) {
            // 更新连续子数组的和
            pre = Math.max(pre + num, num);
            // 再更新max
            max = Math.max(pre, max);
        }

        return max;
    }
    public static void main(String[] args) {
        int[] nums = {1,2,3,-1};

        System.out.println(maxSubArray(nums));
    }
}
