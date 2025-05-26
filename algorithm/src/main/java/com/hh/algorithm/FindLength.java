package com.hh.algorithm;

/**
 * 给两个整数数组 nums1 和 nums2 ，返回 两个数组中 公共的 、长度最长的子数组的长度 。
 *
 * 提示：
 *
 * 1 <= nums1.length, nums2.length <= 1000
 * 0 <= nums1[i], nums2[i] <= 100
 */
public class FindLength {

    public int findLength(int[] nums1, int[] nums2) {
        int len1 = nums1.length, len2 = nums2.length;

        // 用二维的dp数组保存最长公共子数组
        // 其中dp[i][j]表示nums1[i:]与nums2[j:]的最长公共子数组
        int[][] dp = new int[len1 + 1][len2 + 1];
        int max = 0;
        for (int i = len1 - 1; i >= 0; i--) {
            for (int j = len2 - 1; j >= 0; j--) {
                // 当nums1[i] == nums2[j]时，dp[i][j] = dp[i + 1][j + 1] + 1
                // 否则dp[i][j] = 0
                dp[i][j] = nums1[i] == nums2[j] ? dp[i + 1][j + 1] + 1 : 0;

                // 更新最大长度
                max = Math.max(dp[i][j], max);
            }
        }

        return max;
    }

    public static void main(String[] args) {

    }
}
