package com.hh.algorithm;

/**
 * 给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target ，
 * 写一个函数搜索 nums 中的 target，如果目标值存在返回下标，否则返回 -1。
 * <p>
 * 提示：
 * <p>
 * 你可以假设 nums 中的所有元素是不重复的。
 * n 将在 [1, 10000]之间。
 * nums 的每个元素都将在 [-9999, 9999]之间。
 */
public class Search {
    public int search(int[] nums, int target) {
        int length = nums.length;
        int left = 0;
        int right = length - 1;
        while (left < right) {
            int mid = left + right >>> 1;
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }

        }
        // 最后退出while循环时，left会等于right
        // 此时如果nums[left] == target则返回left
        // 否则返回-1
        return nums[left] == target ? left : -1;
    }

}
