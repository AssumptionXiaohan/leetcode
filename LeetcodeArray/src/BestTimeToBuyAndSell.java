/**
 * Created by 79300 on 2019/6/26.
 * 用一个minValue存住左边最小的一个值即可
 * 每遍历到一个元素只需要计算它和它左边最小的值的差
 */
public class BestTimeToBuyAndSell {
    public int maxProfit(int[] prices) {
        int minValue = Integer.MAX_VALUE, maxProfit = 0;
        for (int i = 0; i < prices.length; i++) {
            minValue = Math.min(minValue,prices[i]);
            maxProfit = Math.max(maxProfit,prices[i]-minValue);
        }
        return maxProfit;
    }
}
