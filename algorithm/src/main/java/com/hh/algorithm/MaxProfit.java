package com.hh.algorithm;

/**
 * 给定一个数组 prices ，它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格。
 * <p>
 * 你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。
 * <p>
 * 返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。
 * <p>
 * 提示：
 * <p>
 * 1 <= prices.length <= 105
 * 0 <= prices[i] <= 104
 */
public class MaxProfit {


    /**
     * 贪心算法
     * 比前一个最小值对应的后续的最大值
     * 每一个最大值都会被保留
     * @param prices
     * @return
     */
    public static int maxProfit(int[] prices) {

        int length = prices.length;
        int min = prices[0];
        int maxProfit = 0;
        for (int i = 0; i < length; i++) {

            min = Math.min(min, prices[i]);
            maxProfit = Math.max(maxProfit, prices[i] - min);
        }

        return maxProfit;
    }


    public static void main(String[] args) {
        int[] prices = {2, 5, 1, 2, 3};
        System.out.println(maxProfit(prices));
    }
}
