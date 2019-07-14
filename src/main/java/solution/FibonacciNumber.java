package solution;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author huanfeng.xu
 * @date 2019-07-14 16:33
 * @see <a href="https://leetcode.com/problems/fibonacci-number/">509. Fibonacci Number</a>
 */
public class FibonacciNumber {

    public int fib(int N) {
        int a = 0, b = 1;
        if (N < 2) {
            return N;
        }

        while (N-- >= 2) {
            int tmp = b;
            b = a + b;
            a = tmp;
        }
        return b;
    }

    @Test
    public void test01() {
        assertEquals(1, fib(2));
        assertEquals(2, fib(3));

    }
}
