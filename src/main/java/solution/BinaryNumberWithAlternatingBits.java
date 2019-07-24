package solution;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author huanfeng.xu
 * @date 2019-07-24 21:10
 * @see <a href="https://leetcode.com/problems/binary-number-with-alternating-bits/">693. Binary Number with Alternating Bits</a>
 */
public class BinaryNumberWithAlternatingBits {
    public boolean hasAlternatingBits(int n) {
        int helper = n << 1;
        int val = Integer.highestOneBit(helper);
        return val - 1 == (n ^ helper) >>> 1;
    }

    public boolean another(int n) {
        n = n ^ (n >> 1);
        return (n & n + 1) == 0;
    }

    @Test
    public void test01() {
        assertTrue(hasAlternatingBits(5));
        assertFalse(hasAlternatingBits(7));
        assertTrue(hasAlternatingBits(1431655765));
    }

    @Test
    public void test02() {
        assertTrue(another(5));
        assertFalse(another(7));
        assertTrue(another(1431655765));
    }
}
