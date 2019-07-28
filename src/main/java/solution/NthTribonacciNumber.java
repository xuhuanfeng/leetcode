package solution;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author huanfeng.xu
 * @date 2019-07-28 10:30
 * @see <a href="https://leetcode.com/contest/weekly-contest-147/problems/n-th-tribonacci-number/">1137. N-th Tribonacci Number</a>
 */
public class NthTribonacciNumber {
    public int tribonacci(int n) {
        int a = 0, b = 1, c = 1;
        if (n == 0) {
            return a;
        }
        if (n == 1) {
            return b;
        }
        if (n == 2) {
            return c;
        }

        while (n > 2) {
            int tmp = a + b + c;
            a = b;
            b = c;
            c = tmp;
            n--;
        }
        return c;
    }

    @Test
    public void test01() {
        assertEquals(4, tribonacci(4));
        assertEquals(1389537, tribonacci(25));
    }
}
