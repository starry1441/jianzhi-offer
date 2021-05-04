package work5_4;

/**
 * Created with IntelliJ IDEA.
 * Description:剑指 Offer 63. 股票的最大利润
 * https://leetcode-cn.com/problems/gu-piao-de-zui-da-li-run-lcof/
 * User: starry
 * Date: 2021 -05 -04
 * Time: 16:00
 */
public class Work2 {

    public int maxProfit3(int[] prices) {
        int buy = Integer.MAX_VALUE;
        int sell = 0;
        for (int i = 0; i < prices.length; i++) {
            buy = Math.min(prices[i],buy);
            sell = Math.max(sell,prices[i] - buy);
        }
        return sell;
    }

    public int maxProfit2(int[] prices) {
        if(prices.length == 0) return 0;
        int buy = prices[0];
        int[] dp = new int[prices.length];
        dp[0] = 0;
        for (int i = 1; i < prices.length; i++) {
            buy = Math.min(prices[i],buy);
            dp[i] = Math.max(dp[i-1],prices[i] - buy);
        }
        return dp[prices.length-1];
    }

    public int maxProfit(int[] prices) {
        int max = 0;
        for (int i = 0; i < prices.length; i++) {
            for (int j = i; j < prices.length; j++) {
                int tmp = prices[j] - prices[i];
                if(tmp > max) {
                    max = tmp;
                }
            }
        }
        return max;
    }

}
