package solution;

import org.junit.Test;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

/**
 * @author huanfeng.xu
 * @date 2019-09-02 20:15
 * @see <a href="https://leetcode.com/problems/power-of-two/">231. Power of Two</a>
 */
public class PowerOfTwo {
    // 忘记看条件，wa了三次，囧。。。
    public boolean isPowerOfTwo(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }

    @Test
    public void test() {
        assertTrue(isPowerOfTwo(1));
        assertFalse(isPowerOfTwo(0));
    }
}
