package com.hh.algorithm;

/**
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 *
 * 提示：
 *
 * 1 <= s.length <= 1000
 * s 仅由数字和英文字母组成
 */
public class LongestPalindrome {

    public String longestPalindrome(String s) {
        int length = s.length(), st = 0, end = 0;

        // 遍历字符串找出最长的回文子串
        for (int i = 0; i < length; i++) {
            // 先以位置i为中心向两边统计回文子串的长度
            int s1 = helper(s, i, i);
            // 再以位置i和下一个位置i + 1为中心向两边统计回文子串的长度
            int s2 = helper(s, i, i + 1);

            // 取两者中的最大值
            int max = Math.max(s1, s2);
            // 如果最大值大于现有的回文子串长度
            if (max > end - st + 1) {
                // 则更新st和end
                // 如果max为奇数，则i为中心位置
                // 如果max为偶数，则i为中心位置中左边的位置
                // 所以计算st时要减去(max - 1) / 2
                st = i - (max - 1) / 2;
                // 计算end时直接加上max的一半即max / 2
                end = i + max / 2;
            }
        }

        return s.substring(st, end + 1);
    }

    /**
     * 统计字符串在left和right位置两边回文子串的长度
     */
    private int helper(String s, int left, int right) {
        int length = s.length();
        while (left >= 0 && right < length && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }

        return right - left - 1;
    }

    public static void main(String[] args) {

    }
}
