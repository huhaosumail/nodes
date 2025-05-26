package com.hh.algorithm;

import java.util.HashSet;
import java.util.Set;

/**
 * 给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
 *
 * 请你设计并实现时间复杂度为 O(n) 的算法解决此问题。
 *
 * 提示：
 *
 * 0 <= nums.length <= 105
 * -109 <= nums[i] <= 109
 */
public class LongestConsecutive {

    public static int longestConsecutive(int[] nums) {
        int max = 0, length;
        if ((length = nums.length) == 0) {
            return max;
        }

        // 用HasSet保存数组nums出现的元素
        Set<Integer> memory = new HashSet<>(length);
        for (int i = 0; i < length; i++) {
            memory.add(nums[i]);
        }

        // 遍历数组，统计连续序列
        for (int i = 0; i < length; i++) {
            int num = nums[i];
            // 如果num - 1不在memory中，说明num是序列的第一位
            if (!memory.contains(num - 1)) {
                int sum = 1;
                // 对num逐次递增1，看看是否在memory中
                while (memory.contains(++num)) {
                    // 如果在sum就加1
                    sum++;
                }

                // 最后更新结果max
                max = Math.max(max, sum);
            }
        }

        return max;
    }

    public static void main(String[] args) {

    }
}
