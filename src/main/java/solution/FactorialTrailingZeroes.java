package solution;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author huanfeng.xu
 * @date 2019-09-10 19:56
 * @see <a href="https://leetcode.com/problems/factorial-trailing-zeroes/">172. Factorial Trailing Zeroes</a>
 */
public class FactorialTrailingZeroes {

    // 数学题，没做出来
    public int trailingZeroes(int n) {
        int cnt = 0;
        while (n > 0) {
            cnt += n / 5;
            n /= 5;
        }
        return cnt;
    }

    @Test
    public void test01() {
        assertEquals(0, trailingZeroes(3));
        assertEquals(1, trailingZeroes(5));

    }
}
