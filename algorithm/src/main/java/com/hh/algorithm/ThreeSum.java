package com.hh.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
 * <p>
 * 注意：答案中不可以包含重复的三元组。
 * <p>
 * 提示：
 * <p>
 * 0 <= nums.length <= 3000
 * -105 <= nums[i] <= 105
 */

/**
 * 排序+左右指针
 */
public class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> res = new ArrayList<>();

        int length = nums.length;
        if (length == 0) {
            return res;
        }
        Arrays.sort(nums);

        for (int i = 0; i < length - 2; i++) {
            // 跳过重复的元素
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int left = i + 1;
            int right = length - 1;
            while (left < right) {

                int num = nums[i] + nums[left] + nums[right];
                if (num == 0) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[left]);
                    list.add(nums[right]);
                    res.add(list);
                    //继续往中间找
                    left++;
                    right--;
                    // 从左边跳过重复的元素  下面这些索引主要是因为上面执行过left++ right--
                    //++ left也会变化的 除非写成 int x = left++;这个时候x是用的left没加之前的值
                    while (left < right && nums[left - 1] == nums[left]) {
                        left++;
                    }
                    // 从右边跳过重复的元素
                    while (left < right && nums[right] == nums[right + 1]) {
                        right--;
                    }
                } else if (num < 0) {
                    left++;
                } else {
                    right--;
                }

            }
        }

        return res;
    }
}
