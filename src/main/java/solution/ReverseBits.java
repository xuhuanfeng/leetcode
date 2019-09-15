package solution;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author huanfeng.xu
 * @date 2019-09-15 9:46
 * @see <a href="https://leetcode.com/problems/reverse-bits/">190. Reverse Bits</a>
 */
public class ReverseBits {
    public int reverseBits(int n) {

        int idx = 31;
        char[] chars = new char[idx + 1];

        while (idx >= 0) {
            int tail = n & 1;
            chars[idx--] = (char) (tail + '0');
            n >>>= 1;
        }

        for (int i = 0; i < chars.length / 2; i++) {
            char tmp = chars[i];
            chars[i] = chars[chars.length - 1 - i];
            chars[chars.length - 1 - i] = tmp;
        }

        int result = 0;
        for (int i = 0; i < chars.length - 1; i++) {
            result |= chars[i] - '0';
            result <<= 1;
        }

        result |= (chars[chars.length - 1] - '0');

        return result;
    }

    @Test
    public void test01() {
        assertEquals(964176192, reverseBits(43261596));
        assertEquals(-3, reverseBits(-1073741825));
    }
}
