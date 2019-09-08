package solution;

import org.junit.Test;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

/**
 * @author huanfeng.xu
 * @date 2019-09-08 8:36
 * @see <a href="https://leetcode.com/problems/valid-perfect-square/">367. Valid Perfect Square</a>
 */
public class ValidPerfectSquare {
    public boolean isPerfectSquare(int num) {
        if (num <= 1) {
            return true;
        }
        int tmp = num / 2;
        while (tmp >= 0) {
            if (tmp * tmp == num) {
                return true;
            }
            tmp--;
        }
        return false;
    }

    @Test
    public void test01() {
        assertTrue(isPerfectSquare(16));
        assertFalse(isPerfectSquare(14));
        assertTrue(isPerfectSquare(1));
    }
}
