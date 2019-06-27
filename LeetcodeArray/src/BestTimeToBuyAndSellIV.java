/**
 * Created by 79300 on 2019/6/26.
 * 这题参见III的实现即可
 */
public class BestTimeToBuyAndSellIV {
    public int maxProfit(int k, int[] prices) {
        if (prices.length == 0) return 0;
        if (k >= prices.length / 2) return quickSolve(prices);
        int[][] dp = new int[k + 1][prices.length];
        for (int i = 1; i <= k; i++) {
            //max_diff的初始值应该是dp[0][0]-prices[0]也就是-prices[0]
            int max_diff = -prices[0];
            for (int j = 1; j < prices.length; j++) {
                //如果选择不交易,profit是dp[i][j-1]
                //如果选择交易，现在要从0到j-1之间找一个最高收益的买入点m,取max(dp[i-1][m]+prices[j]-prices[m])时的m
                //这个公式中，dp[i-1][m]代表上一次transaction中到这次交易的买入点m的收益(之前所有收益)，再加上本次的收益：prices[j]-prices[m].也就是目前为止的总收益。
                //使总收益最大化就完事了
                dp[i][j] = Math.max(dp[i][j - 1], max_diff + prices[j]);
                //更新max_diff
                max_diff = Math.max(max_diff, dp[i - 1][j] - prices[j]);
            }
        }
        return dp[k][prices.length - 1];
    }

    //当k很大很大的时候，只要出现了差价就买和卖，和这道题的II是类似的
    //把每一步能赚的钱都加起来
    private int quickSolve(int[] prices) {
        int max_profit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                max_profit = max_profit + prices[i] - prices[i - 1];
            }
        }
        return max_profit;
    }
}
