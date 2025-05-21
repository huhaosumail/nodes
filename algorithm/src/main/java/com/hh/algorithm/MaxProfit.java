package com.hh.algorithm;

/**
 * 给定一个数组 prices ，它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格。
 *
 * 你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。
 *
 * 返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。
 *
 * 提示：
 *
 * 1 <= prices.length <= 105
 * 0 <= prices[i] <= 104
 */
public class MaxProfit {



    public static int maxProfit(int[] prices) {
        // 贪心算法，min为数组中最小的元素
        int length = prices.length, res = 0, min = prices[0];

        // 通过遍历数组找到最小的元素
        // 然后和后面的元素相减得出的差中取最大值
        for (int i = 1; i < length; i++) {
            // 更新最小值
            if (min > prices[i]) {
                min = prices[i];
            }

            // 和后面的元素相减并与res取最大值
            res = Math.max(res, prices[i] - min);
        }

        return res;
    }


    public static void main(String[] args) {
        int[] prices = {5,1,3,6,4};
        System.out.println(maxProfit(prices));
    }
}
