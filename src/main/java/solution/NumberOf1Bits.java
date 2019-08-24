package solution;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author huanfeng.xu
 * @date 2019-08-24 14:56
 * @see <a href="https://leetcode.com/problems/number-of-1-bits/">191. Number of 1 Bits</a>
 */
public class NumberOf1Bits {
    public int hammingWeight(int n) {
        return Integer.bitCount(n);
    }

    @Test
    public void test01() {
        assertEquals(31, hammingWeight(-3));
    }
}
