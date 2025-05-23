package com.hh.algorithm;

/**
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 *
 * 提示：
 *
 * n == height.length
 * 1 <= n <= 2 * 104
 * 0 <= height[i] <= 105
 */
public class Trap {


    public int trap(int[] height) {
        int length;
        if ((length = height.length) == 0) {
            return 0;
        }

        // 每个柱子能接多少雨水等于当前柱子两边最大高度的较小值减去当前高度的值
        int sum = 0, left, right;
        for (int i = 1; i < length; i++) {
            left = right = height[i];

            // 找到左边最大最大高度的柱子
            for (int j = i - 1; j >= 0; j--) {
                left = Math.max(left, height[j]);
            }

            // 找到右边最大最大高度的柱子
            for (int j = i + 1; j < length; j++) {
                right = Math.max(right, height[j]);
            }

            // 当前柱子两边最大高度的较小值减去当前高度的值
            // 就是当前柱子能接的雨水
            sum += Math.min(left, right) - height[i];
        }

        return sum;
    }

}
