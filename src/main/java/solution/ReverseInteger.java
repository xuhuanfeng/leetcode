package solution;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * @author huanfeng.xu
 * @date 2019-09-18 20:52
 * @see <a href="https://leetcode.com/problems/reverse-integer/">7. Reverse Integer</a>
 */
public class ReverseInteger {
    public int reverse(int x) {
        if (x == 0 || x == Integer.MIN_VALUE || x == Integer.MAX_VALUE) {
            return 0;
        }
        boolean isNegative = false;
        if (x < 0) {
            isNegative = true;
            x = -x;
        }

        long ans = 0;

        while (x != 0) {
            ans = ans * 10 + x % 10;
//            System.out.println(ans);
            if (!isNegative && ans > Integer.MAX_VALUE) {
                return 0;
            }
            if (isNegative && -ans < Integer.MIN_VALUE) {
                return 0;
            }
            x /= 10;
        }
        int result = (int) ans;
        if (isNegative) {
            result = -result;
        }
        return result;
    }

    @Test
    public void test01() {
        assertEquals(321, reverse(123));
        assertEquals(-123, reverse(-321));
        assertEquals(21, reverse(120));
        assertEquals(0, reverse(1534236469));
        assertEquals(0, reverse(-1563847412));
        assertEquals(0, reverse(-2147483648));
    }
}
