package solution;

import org.junit.Test;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

/**
 * @author huanfeng.xu
 * @date 2019-09-03 20:22
 * @see <a href="https://leetcode.com/problems/power-of-three/">326. Power of Three</a>
 */
public class PowerOfThree {
    public boolean isPowerOfThree(int n) {
        if (n <= 0) {
            return false;
        }
        while (n != 1) {
            if ((n % 3) != 0) {
                return false;
            }
            n /= 3;
//            System.out.println(n);
        }
        return true;
    }

    @Test
    public void test01() {
        assertTrue(isPowerOfThree(27));
        assertTrue(isPowerOfThree(9));
        assertFalse(isPowerOfThree(4));
    }
}
