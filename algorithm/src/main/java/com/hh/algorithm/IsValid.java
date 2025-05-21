package com.hh.algorithm;

import java.util.LinkedList;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 * <p>
 * 有效字符串需满足：
 * <p>
 * 左括号必须用相同类型的右括号闭合。 左括号必须以正确的顺序闭合。
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 104
 * s 仅由括号 '()[]{}' 组成
 */
public class IsValid {


    public static boolean isValid(String s) {
        int length = s.length();
        if (length % 2 == 1) {
            return false;
        }

        // 利用栈来完成括号匹配
        LinkedList<Character> stack = new LinkedList<>();
        // 遍历字符串的每一个字符
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '{' || c == '[') {
                // 如果当前字符是左括号
                // 则则直接入栈
                stack.push(c);

                continue;
            }

            // 如果遇到右括号，但是栈是空
            // 说明当前字符前面没有与之匹配的左括号
            if (stack.isEmpty()) {
                // 直接返回false
                return false;
            }

            // 否则弹出栈顶元素
            char l = stack.pop();
            if (l == '(' && c != ')' || l == '{' && c != '}' || l == '[' && c != ']') {
                // 如果栈顶元素不能和当前字符匹配成功
                // 则直接返回false
                return false;
            }
        }

        // 栈不为空表示还有括号没有匹配成功
        if (!stack.isEmpty()) {
            // 这里直接返回false
            return false;
        }

        // 到了这里表示所有括号都匹配成功，返回true
        return true;
    }

    public static void main(String[] args) {

        System.out.println(isValid("()"));
    }
}
