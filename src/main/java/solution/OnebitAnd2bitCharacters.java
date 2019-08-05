package solution;

import org.junit.Test;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

/**
 * @author huanfeng.xu
 * @date 2019-08-05 21:15
 * @see <a href="https://leetcode.com/problems/1-bit-and-2-bit-characters/">717. 1-bit and 2-bit Characters</a>
 */
public class OnebitAnd2bitCharacters {
    public boolean isOneBitCharacter(int[] bits) {
        for (int i = 0; i < bits.length; i++) {
            if (i == bits.length - 1 && bits[i] == 0) {
                return true;
            }
            if (bits[i] == 1) {
                i++;
            }
        }
        return false;
    }

    @Test
    public void test01() {
        assertTrue(isOneBitCharacter(new int[]{1, 0, 0}));
        assertFalse(isOneBitCharacter(new int[]{1, 1, 1, 0}));
    }
}
