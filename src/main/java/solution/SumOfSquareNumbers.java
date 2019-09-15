package solution;

import org.junit.Test;

import static junit.framework.TestCase.assertTrue;

/**
 * @author huanfeng.xu
 * @date 2019-09-15 16:28
 * @see <a href="https://leetcode.com/problems/sum-of-square-numbers/">633. Sum of Square Numbers</a>
 */
public class SumOfSquareNumbers {
    public boolean judgeSquareSum(int c) {
        int a = 0;
        // 避免 a*a溢出
        double sqrt = Math.sqrt(c);
        while (true) {
            int squareOfB = c - a * a;
            int b = (int) Math.sqrt(squareOfB);
            if (b * b == squareOfB) {
                return true;
            }
            a++;
            // 注意这里
            if (a > sqrt) {
                break;
            }
        }
        return false;
    }

    @Test
    public void test01() {
        assertTrue(judgeSquareSum(5));
    }
}
