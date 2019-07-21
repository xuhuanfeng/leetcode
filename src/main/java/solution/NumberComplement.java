package solution;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author huanfeng.xu
 * @date 2019-07-21 7:29
 * @see <a href="https://leetcode.com/problems/number-complement/">476. Number Complement</a>
 */
public class NumberComplement {
    public int findComplement(int num) {
        int tmp = num;
        int cnt = 0;
        while (tmp != 0) {
            cnt++;
            tmp >>>= 1;
        }
        cnt = 1 << cnt;
        return (~num) & (cnt - 1);
    }

    public int another(int num) {
        int mask = Integer.highestOneBit(num) - 1;
        return (~num) & mask;
    }

    @Test
    public void test01() {
        assertEquals(2, findComplement(5));
        assertEquals(0, findComplement(1));
    }

    @Test
    public void test02() {
        assertEquals(2, another(5));
        assertEquals(0, another(1));
    }
}
