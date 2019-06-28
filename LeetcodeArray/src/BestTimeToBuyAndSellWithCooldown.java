/**
 * Created by 79300 on 2019/6/28.
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/discuss/75927/Share-my-thinking-process
 * buy[i]     max(buy[i-1],rest[i-1]-prices[i])
 * sell[i]    max(sell[i-1],buy[i-1]+prices[i])
 * rest[i]    sell[i-1]
 * Then we have:
 * buy[i]    max(buy[i-1],sell[i-2]-prices[i]);
 * sell[i]   max(sell[i-1],buy[i-1]+prices[i]);
 */
public class BestTimeToBuyAndSellWithCooldown {
    public int maxProfit(int[] prices) {
        int pre_buy, buy = Integer.MIN_VALUE, sell = 0, pre_sell = 0;
        for (int i = 0; i < prices.length; i++) {
            pre_buy = buy;
            buy = Math.max(pre_buy, pre_sell - prices[i]); //这里的pri_sell是sell[i-2]
            pre_sell = sell; //这里sell是sell[i-1],然后把pri_sell更新成sell[i-1]，保证下次循环还是sell[i-2]
            sell = Math.max(sell, pre_buy + prices[i]); //这里左边的sell是sell[i],右边的sell是sell[i-1]
        }
        return sell;
    }
}
