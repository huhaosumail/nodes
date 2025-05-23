package com.hh.algorithm;

/**
 *假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 *
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 *
 * 提示：
 *
 * 1 <= n <= 45
 */
public class ClimbStairs {

    public static int climbStairs(int n) {
        if (n <= 2) {
            return n;
        }
        // f[n] = f[n - 2] + f[n - 1]
        // first = f[n - 2]
        // second = f[n - 1]
        int first = 1, second = 2, res = 0;
        for (int i = 3; i <= n; i++) {
            // 更新res
            res = first + second;
            // 下一轮的fisrt等于现在的second
            first = second;
            // 下一轮的second等于现在的res
            second = res;
        }

        return res;
    }
    public static void main(String[] args) {



    }
}
