package solution;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author huanfeng.xu
 * @date 2019-08-19 21:17
 * @see <a href="https://leetcode.com/problems/base-7/">504. Base 7</a>
 */
public class Base7 {
    public String convertToBase7(int num) {
        if (num == 0) {
            return "0";
        }
        StringBuilder builder = new StringBuilder();
        boolean minus = num < 0;
        num = Math.abs(num);
        while (num != 0) {
            builder.append(num % 7);
            num /= 7;
        }
        String result = builder.reverse().toString();
        return minus ? "-" + result : result;
    }

    @Test
    public void test01() {
        assertEquals("202", convertToBase7(100));
        assertEquals("-10", convertToBase7(-7));
    }
}
