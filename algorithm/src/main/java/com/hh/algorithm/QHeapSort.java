package com.hh.algorithm;
/**
 * 给你一个整数数组 nums，请你将该数组升序排列。
 *
 * 提示：
 *
 * 1 <= nums.length <= 5 * 104
 * -5 * 104 <= nums[i] <= 5 * 104
 * 堆排序
 */
public class QHeapSort {

    public int[] sortArray(int[] nums) {
        int length = nums.length;
        // heapify：构建一个最大堆
        for (int i = (length - 1) / 2; i >= 0; i--) {
            shiftDown(nums, length, i);
        }

        // 原地堆排序
        // 将最大堆堆顶元素nums[0]与堆中最后一个叶子节点元素nums[i]交换位置
        // 然后通过shiftDown维护区间[0, i)范围内最大堆的性质
        // 直到只剩下根节点
        for (int i = length - 1; i > 0; i--) {
            // 交换堆顶与最后一个叶子的位置
            swap(nums, 0, i);
            // 维护区间[0, i)范围内最大堆的性质
            shiftDown(nums, i, 0);
        }

        return nums;
    }

    /**
     * 将以nums[k]为根节点
     * 且在区间[0, length)范围内的子树构建成最大堆
     */
    private void shiftDown(int[] nums, int length, int k) {
        // nums[2 * k + 1]表示根节点num[k]的左节点
        // nums[2 * k + 2]表示根节点num[k]的右节点
        while (2 * k + 1 < length) {
            int j = 2 * k + 1;
            // 取根节点nums[i]左右节点中较大的节点
            if (j + 1 < length && nums[j] < nums[j + 1]) {
                j = j + 1;
            }

            // 如果根节点比左右节点中较大的节点还大
            // 说明当前以nums[k]为根节点的树已经是最大堆
            if (nums[k] > nums[j]) {
                // 直接break退出循环
                break ;
            }

            // 交换nums[k]与nums[j]
            // 以维护最大堆的性质
            swap(nums, k, j);

            // 然后切换根节点为nums[j]
            // 继续维护nums[k]的子树为最大堆
            k = j;
        }
    }

    /**
     * 交换数组中i和j两个元素的位置
     */
    private void swap(int[] nums, int i, int j) {
        if (i == j) {
            return ;
        }

        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
