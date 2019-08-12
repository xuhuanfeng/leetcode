package solution;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static junit.framework.TestCase.assertTrue;

/**
 * @author huanfeng.xu
 * @date 2019-08-12 21:02
 * @see <a href="https://leetcode.com/problems/happy-number/">202. Happy Number</a>
 */
public class HappyNumber {
    public boolean isHappy(int n) {
        if (n <= 0) {
            return false;
        }

        Set<Integer> set = new HashSet<>();
        set.add(n);
        while (true) {

            int sum = 0;
            while (n != 0) {
                sum += (n % 10) * (n % 10);
                n = n / 10;
            }
            if (sum == 1) {
                return true;
            } else {
                n = sum;
                if (set.contains(n)) {
                    return false;
                }
                set.add(n);
            }
        }
    }

    @Test
    public void test01() {
        assertTrue(isHappy(19));
    }
}
