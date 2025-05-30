package com.hh.algorithm;

import java.util.HashSet;
import java.util.Set;

/**
 * 给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
 * <p>
 * 请你设计并实现时间复杂度为 O(n) 的算法解决此问题。
 * <p>
 * 提示：
 * <p>
 * 0 <= nums.length <= 105
 * -109 <= nums[i] <= 109
 */

/**
 * 以数组 nums = [100, 4, 200, 1, 3, 2] 为例，集合为 {100, 4, 200, 1, 3, 2}。
 * 遍历过程：
 * 遍历 100：
 * 检查 100-1=99 是否存在？不存在 → 100 是起始点。
 * 扩展序列：100+1=101 不存在 → 序列长度为 1。
 * 遍历 4：
 * 检查 4-1=3 是否存在？存在（集合中有 3）→ 4 不是起始点，跳过。
 * 遍历 200：
 * 检查 200-1=199 是否存在？不存在 → 200 是起始点。
 * 扩展序列：200+1=201 不存在 → 序列长度为 1。
 * 遍历 1：
 * 检查 1-1=0 是否存在？不存在 → 1 是起始点。
 * 扩展序列：
 * 1+1=2 存在 → 长度 2；
 * 2+1=3 存在 → 长度 3；
 * 3+1=4 存在 → 长度 4；
 * 4+1=5 不存在 → 结束。
 * 最长序列长度更新为 4。
 * 遍历 3 和 2：
 * 遍历 3 时，检查 3-1=2 存在 → 跳过。
 * 遍历 2 时，检查 2-1=1 存在 → 跳过。
 * 最终结果：最长连续序列长度为 4（对应 1,2,3,4）。
 * <p>
 * 注意连续的意思 就是只能+1
 */
public class LongestConsecutive {


    public static int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        int max = 0;

        // 使用增强for循环遍历，避免修改原数组索引
        for (int num : set) {
            // 检查是否为序列起始点
            if (!set.contains(num - 1)) {
                int currentNum = num; // 使用临时变量扩展序列
                int currentStreak = 1;

                // 扩展当前连续序列
                while (set.contains(currentNum + 1)) {
                    currentNum++;
                    currentStreak++;
                }

                // 更新最长序列长度
                max = Math.max(max, currentStreak);
            }
        }

        return max;
    }


    public static void main(String[] args) {

    }
}
