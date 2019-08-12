package solution;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author huanfeng.xu
 * @date 2019-08-10 9:53
 * @see <a href="https://leetcode.com/problems/best-time-to-buy-and-sell-stock/">121. Best Time to Buy and Sell Stock</a>
 */
public class BestTimeToBuyAndSellStock {
    public int maxProfit(int[] prices) {
        int tMax = 0;
        int sum = 0;

        for (int i = 1; i < prices.length; i++) {
            sum += prices[i] - prices[i - 1];
            if (sum > tMax) {
                tMax = sum;
            } else if (sum < 0) {
                sum = 0;
            }
        }
        return tMax;
    }

    @Test
    public void test01() {
        assertEquals(5, maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
        assertEquals(0, maxProfit(new int[]{7, 6, 4, 3, 1}));
    }
}
