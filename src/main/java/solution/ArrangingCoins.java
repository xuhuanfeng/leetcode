package solution;

import org.junit.Test;

import java.math.BigInteger;

import static org.junit.Assert.assertEquals;

/**
 * @author huanfeng.xu
 * @date 2019-09-09 19:58
 * @see <a href="https://leetcode.com/problems/arranging-coins/">441. Arranging Coins</a>
 */
public class ArrangingCoins {
    public int arrangeCoins(int n) {
        int i = 1;
        int cnt = 0;
        while (i <= n) {
            cnt++;
            n -= i;
            i++;
        }
        return cnt;
    }

    // n先转为long，防止溢出
    // n * 8 = n * 2^3，最大也为：2^34，long不会溢出
    public int another(int n) {
        return (int) ((Math.sqrt(8 * (long) n + 1) - 1) / 2);
    }

    @Test
    public void test01() {
        assertEquals(2, arrangeCoins(5));
        assertEquals(3, arrangeCoins(8));
        assertEquals(60070, arrangeCoins(1804289383));
    }

    @Test
    public void test02() {
        assertEquals(2, another(5));
        assertEquals(3, another(8));
        assertEquals(60070, another(1804289383));
    }
}
