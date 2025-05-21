package com.hh.algorithm;

import java.util.HashMap;
import java.util.Map;

/**
 *给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target 的那 两个 整数，并返回它们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
 *
 * 你可以按任意顺序返回答案。
 *
 * 提示：
 *
 * 2 <= nums.length <= 104 -109 <= nums[i] <= 109 -109 <= target <= 109 只会存在一个有效答案
 */
public class TwoSum {


    public static int[] twoSum(int[] nums,int target){
        int length = nums.length;

        // 利用HashMap保存元素与下标的关系
        Map<Integer, Integer> memory = new HashMap<>();
        for (int i = 0; i < length; i++) {
            int num = nums[i];
            int x = target - num;
            if (memory.containsKey(x)) {
                // 如果x存在于memory中
                // 直接返回i和x对应的数组下标
                return new int[] {i, memory.get(x)};
            }
            // 保存元素和下标的关系
            memory.put(num, i);
        }

        return null;
    }
    public static void main(String[] args) {

        int[] nums  = {1,2,-1,-4,9};
        int[] result = twoSum(nums,10);
        for(int num:result){
            System.out.println(num);
        }
    }
}
