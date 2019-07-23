package solution;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author huanfeng.xu
 * @date 2019-07-23 22:39
 * @see <a href="https://leetcode.com/problems/complement-of-base-10-integer/">1009. Complement of Base 10 Integer</a>
 */
public class ComplementOfBase10Integer {
    public int bitwiseComplement(int N) {
        if (N == 0) {
            return 1;
        }
        return N ^ ((Integer.highestOneBit(N) << 1) - 1);
    }

    public int another(int N) {
        int x = 1;
        while (N > x) {
            x = x << 1 + 1;
        }
        return x - N;
    }

    @Test
    public void test01() {
        assertEquals(2, bitwiseComplement(5));
        assertEquals(5, bitwiseComplement(10));
        assertEquals(1, bitwiseComplement(0));
        assertEquals(0, bitwiseComplement(-1));
    }
}
