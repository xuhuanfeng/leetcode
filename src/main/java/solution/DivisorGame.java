package solution;

import org.junit.Test;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

/**
 * @author huanfeng.xu
 * @date 2019-07-20 22:03
 * @see <a href="https://leetcode.com/problems/divisor-game/">1025. Divisor Game</a>
 */
public class DivisorGame {
    public boolean divisorGame(int N) {
        return (N & 1) == 0;
    }

    @Test
    public void test01() {
        assertTrue(divisorGame(2));
        assertFalse(divisorGame(3));
    }
}
