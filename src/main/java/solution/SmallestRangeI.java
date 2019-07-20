package solution;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author huanfeng.xu
 * @date 2019-07-15 21:38
 * @see <a href="https://leetcode.com/problems/smallest-range-i/">908. Smallest Range I</a>
 */
public class SmallestRangeI {
    public int smallestRangeI(int[] A, int K) {
        int min = A[0];
        int max = A[0];
        for (int i : A) {
            if (i > max) {
                max = i;
            }
            if (i < min) {
                min = i;
            }
        }
        int tmp = max - min - 2 * K;
        return tmp >= 0 ? tmp : 0;
    }

    @Test
    public void test01() {
        assertEquals(0, smallestRangeI(new int[]{1}, 0));
        assertEquals(6, smallestRangeI(new int[]{0, 10}, 2));
        assertEquals(0, smallestRangeI(new int[]{1, 3, 6}, 3));
    }
}
