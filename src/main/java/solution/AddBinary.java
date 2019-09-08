package solution;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author huanfeng.xu
 * @date 2019-09-08 8:15
 * @see <a href="https://leetcode.com/problems/add-binary/">https://leetcode.com/problems/add-binary/</a>
 */
public class AddBinary {
    public String addBinary(String a, String b) {
        char[] charsA = a.toCharArray();
        char[] charsB = b.toCharArray();

        int lenA = a.length() - 1;
        int lenB = b.length() - 1;


        StringBuilder builder = new StringBuilder();
        int leading = 0;
        while (lenA >= 0 || lenB >= 0) {
            int tmp = leading;
            if (lenA >= 0) {
                tmp += (charsA[lenA] - '0');
            }
            if (lenB >= 0) {
                tmp += (charsB[lenB] - '0');
            }

            builder.append(tmp % 2);
            leading = tmp / 2;

            lenA--;
            lenB--;
        }
        if (leading > 0) {
            builder.append(leading);
        }
        return builder.reverse().toString();
    }

    @Test
    public void test01() {
        assertEquals("100", addBinary("1", "11"));
        assertEquals("10101", addBinary("1010", "1011"));
    }
}
