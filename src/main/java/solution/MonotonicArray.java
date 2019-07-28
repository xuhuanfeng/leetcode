package solution;

import org.junit.Test;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

/**
 * @author huanfeng.xu
 * @date 2019-07-28 20:58
 * @see <a href="https://leetcode.com/problems/monotonic-array/">896. Monotonic Array</a>
 */
public class MonotonicArray {
    public boolean isMonotonic(int[] A) {
        if (A.length < 2) {
            return true;
        }

        int index = 1;
        int upperCnt = 0;
        int downCnt = 0;
        while (index < A.length) {
            if (A[index] > A[index - 1]) {
                upperCnt++;
            }
            if (A[index] < A[index - 1]) {
                downCnt++;
            }
            index++;
        }
        return upperCnt == 0 || downCnt == 0;
    }

    @Test
    public void test01() {
        assertTrue(isMonotonic(new int[]{1, 2, 3, 4, 5}));
        assertTrue(isMonotonic(new int[]{5, 4, 3, 2, 1}));
        assertFalse(isMonotonic(new int[]{1, 2, 4, 3}));
        assertTrue(isMonotonic(new int[]{6, 5, 4, 4}));
        assertTrue(isMonotonic(new int[]{1, 1, 0}));
    }
}
