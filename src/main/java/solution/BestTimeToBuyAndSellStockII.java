package solution;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

/**
 * @author huanfeng.xu
 * @date 2019-08-03 9:22
 * @see <a href="https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/">122. Best Time to Buy and Sell Stock II</a>
 */
public class BestTimeToBuyAndSellStockII {
    public int maxProfit(int[] prices) {
        int sum = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                sum += prices[i] - prices[i - 1];
            }
        }
        return sum;
    }

    @Test
    public void test01() {
        assertEquals(7, maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
        assertEquals(4, maxProfit(new int[]{1, 2, 3, 4, 5}));
        assertEquals(11, maxProfit(new int[]{1, 4, 2, 5, 10}));
    }
}
