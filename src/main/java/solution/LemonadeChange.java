package solution;

import org.junit.Test;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

/**
 * @author huanfeng.xu
 * @date 2019-08-04 14:24
 * @see <a href="https://leetcode.com/problems/lemonade-change/">860. Lemonade Change</a>
 */
public class LemonadeChange {
    public boolean lemonadeChange(int[] bills) {
        int fiveDollar = 0;
        int tenDollar = 0;
        for (int bill : bills) {
            if (bill == 5) {
                fiveDollar++;
            } else if (bill == 10) {
                if (fiveDollar > 0) {
                    fiveDollar--;
                    tenDollar++;
                } else {
                    return false;
                }
            } else {
                if (tenDollar > 0 && fiveDollar > 0) {
                    tenDollar--;
                    fiveDollar--;
                } else if (fiveDollar >= 3) {
                    fiveDollar -= 3;
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    @Test
    public void test01() {
        assertTrue(lemonadeChange(new int[]{5, 5, 10}));
        assertFalse(lemonadeChange(new int[]{10, 10}));
        assertTrue(lemonadeChange(new int[]{5, 5, 5, 10, 20}));
        assertFalse(lemonadeChange(new int[]{5, 5, 10, 10, 20}));
    }
}
