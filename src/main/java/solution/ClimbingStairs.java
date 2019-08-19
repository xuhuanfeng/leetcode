package solution;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author huanfeng.xu
 * @date 2019-08-19 21:22
 * @see <a href="https://leetcode.com/problems/climbing-stairs/">70. Climbing Stairs</a>
 */
public class ClimbingStairs {
    public int climbStairs(int n) {
        if (n < 3) {
            return n;
        }
        int a = 1;
        int b = 2;
        n -= 2;
        while (n > 0) {
            int tmp = a + b;
            a = b;
            b = tmp;
            n--;
        }
        return b;
    }

    @Test
    public void test01() {
        assertEquals(2, climbStairs(2));
        assertEquals(3, climbStairs(3));
    }
}
