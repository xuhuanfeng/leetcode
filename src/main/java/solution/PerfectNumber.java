package solution;

import org.junit.Test;

import static junit.framework.TestCase.assertTrue;

/**
 * @author huanfeng.xu
 * @date 2019-09-12 20:49
 * @see <a href="https://leetcode.com/problems/perfect-number/">507. Perfect Number</a>
 */
public class PerfectNumber {
    public boolean checkPerfectNumber(int num) {
        if (num == 1) {
            return false;
        }
        int sqrt = (int) Math.sqrt(num);
        int sum = 1;
        for (int i = 2; i <= sqrt; i++) {
            if (num % i == 0) {
//                System.out.printf("%d ", i);
                if (i * i == num) {
                    sum += i;
                } else {
                    sum += i;
                    sum += num / i;
                }
            }
        }
//        System.out.println(sum);
        return sum == num;
    }

    @Test
    public void test01() {
        assertTrue(checkPerfectNumber(28));
    }
}
