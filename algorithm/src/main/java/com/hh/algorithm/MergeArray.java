package com.hh.algorithm;

/**
 * 给你两个按 非递减顺序 排列的整数数组 nums1 和 nums2，另有两个整数 m 和 n ，分别表示 nums1 和 nums2 中的元素数目。
 * <p>
 * 请你 合并 nums2 到 nums1 中，使合并后的数组同样按 非递减顺序 排列。
 * <p>
 * 注意：最终，合并后数组不应由函数返回，而是存储在数组 nums1 中。为了应对这种情况，nums1 的初始长度为 m + n，
 * 其中前 m 个元素表示应合并的元素，后 n 个元素为 0 ，应忽略。nums2 的长度为 n 。
 * <p>
 * 提示：
 * <p>
 * nums1.length == m + n nums2.length == n 0 <= m, n <= 200 1 <= m + n <= 200 -109 <= nums1[i], nums2[j] <= 109
 */
public class MergeArray {

    public void merge(int[] nums1, int m, int[] nums2, int n) {

        int[] temp = new int[m + n];
        int i = 0, j = 0, k = 0;
        while (i < m && j < n) {
            if (nums1[i] < nums2[j]) {
                temp[k++] = nums1[i++];
            } else {
                temp[k++] = nums2[j++];
            }
        }

        while (i < m) {
            temp[k++] = nums1[i++];
        }

        while (j < n) {
            temp[k++] = nums2[j++];
        }
        // 复制回 nums1
        System.arraycopy(temp, 0, nums1, 0, m + n);
    }

    /**
     * 下面这种方式 也可以
     */
    public void merge2(int[] nums1, int m, int[] nums2, int n) {
        // 先用临时数组temp将nums1数组中的元素保存起来
        int[] temp = new int[m];
        for (int i = 0; i < m; i++) {
            temp[i] = nums1[i];
        }

        int i = 0, j = 0, k = 0;
        // 合并数组temp和nums2
        while (i < m || j < n) {
            if (i == m) {
                // 如果temp遍历完了，那么直接将nums2[j]合入nums1
                nums1[k] = nums2[j++];
            } else if (j == n) {
                // 如果nums2遍历完了，那么直接将temp[i]合入nums1
                nums1[k] = temp[i++];
            } else if (temp[i] < nums2[j]) {
                // 如果temp[i]更小就将temp[i]合入nums1
                nums1[k] = temp[i++];
            } else {
                // 否则nums2[j]更小就将nums2[j]合入nums1
                nums1[k] = nums2[j++];
            }

            k++;
        }
    }
    public static void main(String[] args) {

    }
}
