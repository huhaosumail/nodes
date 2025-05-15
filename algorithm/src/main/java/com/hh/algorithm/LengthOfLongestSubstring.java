package com.hh.algorithm;


import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 * 提示：
 *
 * 0 <= s.length <= 5 * 104
 * s 由英文字母、数字、符号和空格组成
 */
public class LengthOfLongestSubstring {

    public static void main(String[] args) {

        String s = "abcbbcbb";

        System.out.println(lengthOfLongestSubstring(s));
    }

    public static int lengthOfLongestSubstring(String s) {
        int length;
        if (s == null || (length = s.length()) == 0) {
            return 0;
        }

        // left、right作为滑动窗口的左右指针
        int left = 0, right = 0, res = 0;
        // windows保存left和right之间滑动窗口每个字符出现的次数
        Map<Character, Integer> windows = new HashMap<>();
        while (right < length) {
            // 遍历字符串s
            // 每次遍历结束都保证滑动窗口的字符是不重复的
            char str = s.charAt(right++);
            // 记录字符c出现一次
            windows.put(str, windows.getOrDefault(str, 0) + 1);

            // 如果字符出现次数大于1
            // 说明字符str重复了
            //在这里面缩小窗口
            while (windows.get(str) > 1) {
                // 这个时候缩小滑动窗口的范围
                char tr = s.charAt(left++);
                // tr已经不在滑动窗口里面了
                // 所以要减去 重复的就会成功去掉1直到为1 不重复的就会变成0
                windows.put(tr, windows.get(tr) - 1);
            }

            // 再重新计算滑动窗口内的长度
            // 和res取最大值更新结果res
            res = Math.max(res, right - left);
        }

        return res;
    }
}
