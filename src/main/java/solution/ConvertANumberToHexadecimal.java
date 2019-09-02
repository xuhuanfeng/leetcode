package solution;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author huanfeng.xu
 * @date 2019-09-02 20:01
 * @see <a href="https://leetcode.com/problems/convert-a-number-to-hexadecimal/">405. Convert a Number to Hexadecimal</a>
 */
public class ConvertANumberToHexadecimal {
    public String toHex(int num) {
        if (num == 0) {
            return "0";
        }
        StringBuilder builder = new StringBuilder();
        while (num != 0) {
            int rail = num & 0xf;
            char tmp;
            switch (rail) {
                case 10:
                    tmp = 'a';
                    break;
                case 11:
                    tmp = 'b';
                    break;
                case 12:
                    tmp = 'c';
                    break;
                case 13:
                    tmp = 'd';
                    break;
                case 14:
                    tmp = 'e';
                    break;
                case 15:
                    tmp = 'f';
                    break;
                default:
                    tmp = (char) (rail + '0');
            }
            builder.append(tmp);
            num = num >>> 4;
        }
        return builder.reverse().toString();
    }

    @Test
    public void test01() {
        assertEquals("1a", toHex(26));
        assertEquals("ffffffff", toHex(-1));
    }
}
