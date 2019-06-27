/**
 * Created by 79300 on 2019/6/26.
 * 这个就是简单的计算所有能赚的钱了..把每一步只要能赚的钱都加起来
 * 比如3,4,5 其实是3买5卖，但跟(4-3)+(5-4)其实是一个道理
 */
public class BestTimeToBuyAndSellII {
    public int maxProfit(int[] prices) {
        if (prices.length <= 1) return 0;
        int maxProfit = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            if (prices[i] < prices[i + 1])
                maxProfit = maxProfit + prices[i + 1] - prices[i];
        }
        return maxProfit;
    }
}
