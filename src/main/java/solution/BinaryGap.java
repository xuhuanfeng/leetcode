package solution;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author huanfeng.xu
 * @date 2019-07-22 21:12
 * @see <a href="https://leetcode.com/problems/binary-gap/">868. Binary Gap</a>
 */
public class BinaryGap {
    public int binaryGap(int N) {
        int max = 0;
        int pre = 0;
        while ((N & 1) == 0 && pre < 32) {
            pre++;
            N >>>= 1;
        }
        int cnt = pre;
        while (cnt < 32) {
            if ((N & 1) == 1 && pre != cnt) {
                int distance = cnt - pre;
                if (distance > max) {
                    max = distance;
                }
                pre = cnt;
            }
            cnt++;
            N >>>= 1;
        }
        return max;
    }

    public int another(int N) {
        int max = 0;
        for (int distance = -32; N > 0; N /= 2, distance++) {
            if (N % 2 == 1) {
                max = Math.max(distance, max);
                distance = 0;
            }
        }
        return max;
    }

    @Test
    public void test01() {
        assertEquals(0, binaryGap(8));
        assertEquals(1, binaryGap(6));
        assertEquals(2, binaryGap(5));
        assertEquals(2, binaryGap(22));
    }

    @Test
    public void test02() {
        assertEquals(0, another(8));
        assertEquals(1, another(6));
        assertEquals(2, another(5));
        assertEquals(2, another(22));
    }
}
