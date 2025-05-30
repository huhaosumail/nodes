package com.hh.algorithm;

import java.util.LinkedList;
import java.util.Stack;

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
        if (length % 2 != 0) {
            return false;
        }
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < length; i++) {
            char character = s.charAt(i);
            //char的话用单引号来表示
            if (character == '(' || character == '{' || character == '[') {
                stack.push(character);
                continue;
            }
            //必须先是左边部分
            if (stack.isEmpty()) {
                return false;
            }
            //必须弹出 一比一消耗
            char leftCharacter = stack.pop();
            if (leftCharacter == '(' && character != ')' || leftCharacter == '{' && character != '}' || leftCharacter == '[' && character != ']') {
                //下面这种表达都不行。必须要一一对应 否则（}这种也能通过 但是不对
//            if (character == ')' || character == '}' || character == ']') {
                return false;
            }

        }

        // 栈不为空表示还有括号没有匹配成功
        if (!stack.isEmpty()) {
            // 这里直接返回false
            return false;
        }
        return true;
    }

    public static void main(String[] args) {

        System.out.println(isValid("()"));
    }
}
