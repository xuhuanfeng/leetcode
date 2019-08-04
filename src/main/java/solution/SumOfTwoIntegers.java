package solution;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author huanfeng.xu
 * @date 2019-08-04 10:05
 * @see <a href="https://leetcode.com/problems/sum-of-two-integers/">371. Sum of Two Integers</a>
 */
public class SumOfTwoIntegers {
    public int getSum(int a, int b) {
        int cnt = 0;
        int ans = 0;
        int index = 0;
        while (cnt < 32) {
            int tA = a & 1;
            int tB = b & 1;
            if ((tA & tB) == 1 && (tA | tB) == 1) {
                ans |= (index << cnt);
                index = 1;
            } else {
                int tmp = (tA | tB);
                if (tmp == 1 && index == 1) {
                    index = 1;
                } else {
                    ans |= ((tA | tB | index) << cnt);
                    index = 0;
                }
            }
            cnt++;
            a >>= 1;
            b >>= 1;
        }
        return ans;
    }

    @Test
    public void test01() {
        assertEquals(3, getSum(1, 2));
        assertEquals(1, getSum(-2, 3));
        assertEquals(4, getSum(-6, 10));
    }
}
