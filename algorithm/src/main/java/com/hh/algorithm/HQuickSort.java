package com.hh.algorithm;

/**
 * 给你一个整数数组 nums，请你将该数组升序排列。
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 5 * 104
 * -5 * 104 <= nums[i] <= 5 * 104
 */
public class HQuickSort {

    public int[]  sortArray(int[] arr) {
        if (arr == null || arr.length <= 1) return arr;
        quickSort(arr, 0, arr.length - 1);
        return arr;
    }

    /**
     * 双路快排
     * 选择基准值（Pivot）：通常选择数组首个元素或随机元素。
     * 双指针扫描：
     * 左指针 i 从第二个元素开始向右扫描，找到第一个 ≥ pivot 的元素。
     * 右指针 j 从最后一个元素开始向左扫描，找到第一个 ≤ pivot 的元素。
     * 交换元素：将 i 和 j 指向的元素交换，继续扫描直到 i > j。
     * 分割数组：最终将基准值与 j 位置的元素交换，此时基准值左侧元素均 ≤ 它，右侧元素均 ≥ 它。
     * 递归排序：对左右两部分分别递归执行上述过程。
     *
     * @param nums
     * @return
     */
    public void quickSort(int[] nums, int left, int right) {

        if (left >= right) {
            return;
        }

        // 随机选择基准值（优化：避免最坏情况）
        //在数组的 [left, right] 闭区间内随机选择一个索引位置
        /**
         * 1. Math.random()
         * 返回一个 [0.0, 1.0) 范围内的随机 double 值（包含 0.0，但不包含 1.0）。
         * 例如：可能返回 0.324、0.999 等。
         * 2. (right - left + 1)
         * 计算区间 [left, right] 的元素个数。
         * 例如：若 left=3，right=5，则元素个数为 5-3+1=3（即索引 3、4、5）。
         * 3. Math.random() * (right - left + 1)
         * 将随机小数放大到 [0.0, 元素个数) 范围。
         * 例如：若元素个数为 3，则结果范围是 [0.0, 3.0)（如 0.0、2.999）。
         * 4. (int) (...)
         * 强制类型转换为整数，丢弃小数部分，得到 [0, 元素个数-1] 范围内的随机整数。
         * 例如：
         * (int) 0.0 → 0
         * (int) 2.999 → 2
         * 5. + left
         * 将随机整数偏移到目标区间 [left, right]。
         * 例如：若 left=3，随机数为 0，则最终结果为 3+0=3；若随机数为 2，则结果为 3+2=5。
         */
        swap(nums, left, (int) (Math.random() * (right - left + 1)) + left);

        //基准
        int pivot = nums[left];
        // 双指针扫描
        int i = left + 1, j = right;
        while (true) {
            //左指针 i 从第二个元素开始向右扫描，找到第一个 ≥ pivot 的元素。
            while (i <= right && nums[i] < pivot) {
                i++;
            }
            //右指针 j 从最后一个元素开始向左扫描，一直到left+1的位置，找到第一个 < pivot 的元素。
            while (j >= left + 1 && nums[j] >= pivot) {
                j--;
            }
            if (i > j) break;  // 扫描结束
            swap(nums, i, j);
            i++;
            j--;
        }
        //将基准值放到正确位置
        swap(nums, left, j);

        // 递归排序左右两部分
        quickSort(nums, left, j - 1);
        quickSort(nums, j + 1, right);
    }

    public static void swap(int[] arr, int a, int b) {
        int s = arr[a];
        arr[a] = arr[b];
        arr[b] = s;
    }


}
