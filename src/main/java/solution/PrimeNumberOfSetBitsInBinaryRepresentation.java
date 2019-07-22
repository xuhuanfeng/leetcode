package solution;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static org.junit.Assert.assertEquals;

/**
 * @author huanfeng.xu
 * @date 2019-07-22 21:00
 * @see <a href="https://leetcode.com/problems/prime-number-of-set-bits-in-binary-representation/">762. Prime Number of Set Bits in Binary Representation</a>
 */
public class PrimeNumberOfSetBitsInBinaryRepresentation {
    public int countPrimeSetBits(int L, int R) {
        Set<Integer> set = new HashSet<>(Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31));
        int cnt = 0;
        for (int i = L; i <= R; i++) {
            int bitCount = Integer.bitCount(i);
            if (set.contains(bitCount)) {
                cnt++;
            }
        }
        return cnt;
    }

    @Test
    public void test01() {
        assertEquals(4, countPrimeSetBits(6, 10));
        assertEquals(5, countPrimeSetBits(10, 15));
    }
}
