package com.hh.algorithm;


import java.util.HashSet;
import java.util.Set;

/**
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 * <p>
 * 提示：
 * <p>
 * 0 <= s.length <= 5 * 104
 * s 由英文字母、数字、符号和空格组成
 */

/**
 * 要解决这个问题，可以使用滑动窗口算法。滑动窗口通过维护一个不包含重复字符的子串，并动态调整窗口大小来找到最长无重复子串。
 * 方法思路
 * 滑动窗口：使用两个指针 left 和 right 表示窗口的左右边界。
 * 哈希集合：使用一个哈希集合（Python 中的set）来记录当前窗口中已经出现的字符。
 * 遍历字符串：右指针 right 不断向右移动，将字符加入集合中。如果遇到重复字符，则移动左指针 left 并从集合中移除字符，直到重复字符被移除。
 * 记录最大长度：在移动过程中记录窗口的最大长度。
 */
public class LengthOfLongestSubstring {

    public static void main(String[] args) {

        String s = "abcbbcbb";

        System.out.println(lengthOfLongestSubstring(s));
    }

    /**
     * 滑动窗口
     *
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring(String s) {

        Set<Character> set = new HashSet<>();
        int left = 0;
        int max = 0;
        int length = s.length();
        for (int right = 0; right < length; right++) {
            char a = s.charAt(right);
            while (set.contains(a)) {
//                set.remove(a); 这里千万不要remove错 不是移除当前这个元素
//                而是左边这个元素 直到set里面没有重复的a元素 这个时候整个窗口才是正常的
                set.remove(s.charAt(left));
                left++;
            }
            set.add(a);
            max = Math.max(max, right - left + 1);
        }
        return max;
    }
}
