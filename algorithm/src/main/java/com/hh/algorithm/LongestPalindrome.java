package com.hh.algorithm;

/**
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 1000
 * s 仅由数字和英文字母组成
 */
public class LongestPalindrome {

    public String longestPalindrome(String s) {

        int n = s.length();
        if (n == 1) {
            return s;
        }

//        if (n == 2) {
//            if (s.charAt(0) == s.charAt(1)) {
//                return s;
//            } else {
//                return null;
//            }
//        }
        boolean[][] dp = new boolean[n][n];
        int start = 0;  // 最长回文子串的起始位置
        int maxLen = 1; // 最长回文子串的长度

        /**
         * 为什么需要这一步？
         * 在动态规划中，我们需要从最小的子问题开始解决，然后逐步推导出更大的子问题。对于最长回文子串：
         * 最小子问题：长度为 1 的子串（单个字符）
         * 递推关系：长度≥2 的子串是否为回文，依赖于其首尾字符是否相同以及中间子串的状态
         * 例如，判断子串 "abba" 是否为回文时，需要先知道中间子串 "bb" 是否为回文。而中间子串的判断最终会追溯到长度为 1 的子串。
         */
        //处理长度为1的子串
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }
        // 处理所有长度为2的子串
        for (int i = 0; i < n - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                dp[i][i + 1] = true;  // 标记相邻字符为回文
                start = i;            // 记录起始位置
                maxLen = 2;           // 记录当前最长长度为2
            }
        }
        //len表示长度的遍历
        for (int len = 3; len <= n; len++) {
            for (int i = 0; i <= n - len; i++) {
                int j = i + len - 1;
                if (dp[i + 1][j - 1] && s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = true;
                    start = i;
                    maxLen = len;
                }
            }
        }
        return s.substring(start, start + maxLen);

    }


    public static void main(String[] args) {

    }
}
