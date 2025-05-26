package com.hh.algorithm;

import java.util.Arrays;

/**
 * 给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。
 *
 * 计算并返回可以凑成总金额所需的 最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回 -1 。
 *
 * 你可以认为每种硬币的数量是无限的。
 *
 * 提示：
 *
 * 1 <= coins.length <= 12
 * 1 <= coins[i] <= 231 - 1
 * 0 <= amount <= 104
 */
public class CoinChange {


    public static int coinChange(int[] coins,int amount){
        // 用dp数组保存凑成总金额为[1, amount]需要最少的硬币数
        int[] dp = new int[amount + 1];
        // 因为要凑齐总金额amount所需要的硬币数肯定不会超过amount + 1
        // 所以给dp赋上初始值amount + 1
        Arrays.fill(dp, amount + 1);
        // 要凑齐总金额为0所需要的硬币数为0
        dp[0] = 0;

        // 从计算凑齐总金额为1需要最少硬币数开始遍历
        for (int i = 1; i <= amount; i++) {
            // 每一个硬币都判断一下
            // 看看能不能以最少的硬币数凑成总金额i
            for (int coin : coins) {
                // 当前硬币面额大于i
                if (coin > i) {
                    // 则跳过
                    continue ;
                }

                // 而凑成总金额i所需要最少的硬币数为
                // dp[i] 和 dp[i - coin] + 1 中取最小值
                dp[i] = Math.min(dp[i], dp[i - coin] + 1);
            }
        }

        return dp[amount] == amount + 1 ? -1 : dp[amount];

    }
    public static void main(String[] args) {

        int[] coins = {1,2,5};
        System.out.println(coinChange(coins,13));

    }
}
