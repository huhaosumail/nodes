package com.hh.algorithm;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 给定整数数组 nums 和整数 k，请返回数组中第 **k** 个最大的元素。
 * <p>
 * 请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 * <p>
 * 提示：
 * <p>
 * 1 <= k <= nums.length <= 104
 * -104 <= nums[i] <= 104
 */
public class FindKthLargest {

    public static int findKthLargest(int[] nums, int k) {

        //升序排序：第 K 大元素的索引为 nums.length - k
        Arrays.sort(nums);
        return nums[nums.length - k];
    }


    public static int findHeapKthLargest(int[] nums, int k) {

        //最小堆
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
        for (int i = 1; i <= nums.length; i++) {
            queue.offer(nums[i-1]);
            if (i > k) {
                queue.poll();
            }

        }
        return queue.peek();

    }

    public static void main(String[] args) {
        int[] nums = {5, 3, 4, 2, 1};
        System.out.println(findHeapKthLargest(nums, 3));
    }
}
