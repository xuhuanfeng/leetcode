package solution;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author huanfeng.xu
 * @date 2019-09-16 19:32
 * @see <a href="https://leetcode.com/problems/sqrtx/">69. Sqrt(x)</a>
 */
public class Sqrtx {
    public int mySqrt(int x) {
        if (x <= 0) {
            return 0;
        }

        int i = 1;
        while (true) {
            int tmp = x / i;
            if (i >= tmp) {
                return tmp;
            }
            i++;
        }
    }

    @Test
    public void test01() {
        assertEquals(2, mySqrt(4));
        assertEquals(2, mySqrt(5));
        assertEquals(2, mySqrt(8));
    }
}
