/**
 * Created by 79300 on 2019/6/26.
 * 3 3 5 0 0 3 1 4 （j)
 * 0   0 0 0 0 0 0 0 0
 * 1
 * 2
 * (i)
 * 横轴是prices, 纵轴是交易次数，次数从0开始
 * 第0行因为交易次数是0，所以没有收益，一整行都是0
 * 第 j 次交易， 比如j=2， 也就是prices[2]=5的时候，
 * 可以选择不交易，这时候的收益是保持j-1次的收益，也就是dp[i][j - 1]
 * <p>
 * 也可以选择交易，因为买入可以是从0到j-1的任何一个，而且买入的前提是上一次的要卖掉
 * 所以如果是在j=1的时候买入的，这次的收益就是prices[2] - prices[1]
 * 而且j=1时买入，就证明上次的交易在j=1的时候结束了，所以要加上上次交易截止到j=1时的收益
 * 即dp[i - 1][1]
 * <p>
 * 综上所述，在j=2时
 * 如果选择不交易：dp[i][j - 1]
 * <p>
 * 如果选择交易：买入点选在m点（m=0 to j-1）
 * 收益即为对于所有m从0到j-1: max（前一次截止到m的交易收益（前一次可以在m点卖掉然后本次在m点买入） + 选择在m点买入时本次的收益）：
 * for m:0~j-1: max( dp[i - 1][m] + prices[j] - prices[m])
 * 简化一个这个公式：
 * for m:0~j-1: max(dp[i - 1][m] - prices[m]) + prices[j]
 * <p>
 * 注意到在j移动的过程中，max(dp[i - 1][m] - prices[m]) 是实时更新的，所以只需要定义一个max_diff，j每走一步max_diff都更新一次，那么上面的公式就变成
 * 第j次交易时：max_diff + prices[j]
 * <p>
 * 而需要在交易和不交易两种情况中取较大的值，所以最后变成
 * dp[i][j] = max(dp[i][j - 1], max_diff + prices[j])
 * <p>
 * 因为交易有2次
 * 最后返回dp[2][prices.size() - 1]
 * <p>
 * 原文：https://blog.csdn.net/level_code/article/details/92231822
 * 版权声明：本文为博主原创文章，转载请附上博文链接！
 */
public class BestTimeToBuyAndSellIII {
    public int maxProfit(int[] prices) {
        if (prices.length == 0) return 0;
        int k = 2;
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
}
