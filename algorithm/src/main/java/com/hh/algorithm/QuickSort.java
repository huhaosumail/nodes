package com.hh.algorithm;

/**
 * 给你一个整数数组 nums，请你将该数组升序排列。
 *
 * 提示：
 *
 * 1 <= nums.length <= 5 * 104
 * -5 * 104 <= nums[i] <= 5 * 104
 * 双路快排
 */
public class QuickSort {

    public static void sort(int[] nums) {
        if (nums == null || nums.length <= 1) return;
        quickSort(nums, 0, nums.length - 1);
    }

    private static void quickSort(int[] nums, int left, int right) {
        if (left >= right) return;

        // 随机选择基准值，避免最坏情况
        int pivotIndex = left + (int) (Math.random() * (right - left + 1));
        swap(nums, left, pivotIndex); // 将基准值交换到数组头部
        int pivot = nums[left];

        int i = left + 1; // 左指针
        int j = right;    // 右指针

        while (i <= j) {
            // 左指针找到第一个 >= pivot 的元素
            while (i <= j && nums[i] < pivot) i++;
            // 右指针找到第一个 <= pivot 的元素
            while (i <= j && nums[j] > pivot) j--;
            // 交换元素
            if (i <= j) {
                swap(nums, i, j);
                i++;
                j--;
            }
        }

        // 基准值归位（交换到 j 位置，此时 nums[j] <= pivot，nums[j+1] > pivot）
        swap(nums, left, j);

        // 递归排序左右子数组
        quickSort(nums, left, j - 1);
        quickSort(nums, j + 1, right);
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }


}
