package com.hh.algorithm;

/**
 * 给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
 * <p>
 * 子序列 是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。
 * 例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序列。
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 2500
 * -104 <= nums[i] <= 104
 */
public class LengthOfLIS {

    public static int lengthOfLIS(int[] nums) {

        int length = nums.length;
        if (length == 1) {
            return 1;
        }
        int[] dp = new int[length + 1];
        int max = 1;
        for (int i = 0; i < length; i++) {
            //初始长度为1
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }


    public static void main(String[] args) {
        int[] nums = {0, 3, 1, 6, 2, 2, 7};
        int result = lengthOfLIS(nums);
        System.out.println(result);
    }
}
