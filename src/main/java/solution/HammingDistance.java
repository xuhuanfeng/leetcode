package solution;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author huanfeng.xu
 * @date 2019-07-14 10:35
 * @see <a href="https://leetcode.com/problems/hamming-distance/">461. Hamming Distance</a>
 */
public class HammingDistance {
    public int hammingDistance(int x, int y) {
        int result = 0;
        int cnt = 32;
        x = x ^ y;
        while (cnt >= 0) {
            result += x & 1;
            x >>>= 1;
            cnt--;
        }
        return result;
    }

    public int another(int x, int y) {
        return Integer.bitCount(x ^ y);
    }

    @Test
    public void test01() {
        assertEquals(2, hammingDistance(1, 4));
    }
}
