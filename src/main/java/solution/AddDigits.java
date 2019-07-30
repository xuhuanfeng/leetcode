package solution;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author huanfeng.xu
 * @date 2019-07-30 19:56
 * @see <a href="https://leetcode.com/problems/add-digits/">258. Add Digits</a>
 */
public class AddDigits {
    public int addDigits(int num) {
        while (num >= 10) {
            int tmp = 0;
            while (num > 0) {
                tmp += num % 10;
                num /= 10;
            }
            num = tmp;
        }
        return num;
    }

    @Test
    public void test01() {
        assertEquals(2, addDigits(38));
    }
}
