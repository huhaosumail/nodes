package com.hh.algorithm;

/**
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * <p>
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 45
 */
public class ClimbStairs {

    public static int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i < n + 1; i++) {
            //要到达第 i 阶，只能从第 i-1 阶爬 1 步，或从第 i-2 阶爬 2 步。因此：
            //dp[i] = dp[i-1] + dp[i-2]
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    public static void main(String[] args) {

        System.out.println(climbStairs(5));

    }
}
