package com.hh.algorithm;

import java.util.Arrays;

/**
 * 给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。
 * <p>
 * 计算并返回可以凑成总金额所需的 最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回 -1 。
 * <p>
 * 你可以认为每种硬币的数量是无限的。
 * <p>
 * 提示：
 * <p>
 * 1 <= coins.length <= 12
 * 1 <= coins[i] <= 231 - 1
 * 0 <= amount <= 104
 */
public class CoinChange {


    public static int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        // 初始化 dp 数组，默认值为 amount+1（代表无穷大）也就是不存在这样的情况 所有硬币都是1都不行
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;

        for (int i = 1; i < amount+1 ; i++) {
            for (int coin : coins) {
                if (i >= coin) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }

            }
        }
        // 如果 dp[amount] 仍为 amount+1，说明无法凑出该金额
        return dp[amount] > amount ? -1 : dp[amount];


    }

    public static void main(String[] args) {

        int[] coins = {1, 2, 5};
        System.out.println(coinChange(coins, 11));

    }
}
