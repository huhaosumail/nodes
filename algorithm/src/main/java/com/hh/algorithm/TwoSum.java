package com.hh.algorithm;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target 的那 两个 整数，并返回它们的数组下标。
 * <p>
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
 * <p>
 * 你可以按任意顺序返回答案。
 * <p>
 * 提示：
 * <p>
 * 2 <= nums.length <= 104 -109 <= nums[i] <= 109 -109 <= target <= 109 只会存在一个有效答案
 */
public class TwoSum {


    public static int[] twoSum(int[] nums, int target) {

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int x = target - nums[i];
            if (map.containsKey(x)) {
                return new int[]{i, map.get(x)};
            }
            map.put(nums[i], i);
        }
        return null;
    }

    public static void main(String[] args) {

        int[] nums = {1, 2, -1, -4, 9};
        int[] result = twoSum(nums, 10);
        for (int num : result) {
            System.out.println(num);
        }
    }
}
