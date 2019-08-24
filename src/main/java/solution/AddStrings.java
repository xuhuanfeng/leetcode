package solution;

import org.junit.Test;

/**
 * @author huanfeng.xu
 * @date 2019-08-24 15:26
 * @see <a href="https://leetcode.com/problems/add-strings/">415. Add Strings</a>
 */
public class AddStrings {
    public String addStrings(String num1, String num2) {
        char[] chars1 = num1.toCharArray();
        char[] chars2 = num2.toCharArray();

        StringBuilder builder = new StringBuilder();
        int i = chars1.length - 1, j = chars2.length - 1;
        int leading = 0;
        while (i >= 0 && j >= 0) {
            int tmp = chars1[i] - '0';
            int tmp2 = chars2[j] - '0';

            int tResult = tmp + tmp2 + leading;
            if (tResult >= 10) {
                builder.append(tResult - 10);
                leading = 1;
            } else {
                builder.append(tResult);
                leading = 0;
            }
            i--;
            j--;
        }

        while (i >= 0) {
            int tResult = chars1[i] - '0';
            if (tResult + leading >= 10) {
                builder.append(tResult + leading - 10);
                leading = 1;
            } else {
                builder.append(tResult + leading);
                leading = 0;
            }
            i--;
        }

        while (j >= 0) {
            int tResult = chars2[j] - '0';
            if (tResult + leading >= 10) {
                builder.append(tResult + leading - 10);
                leading = 1;
            } else {
                builder.append(tResult + leading);
                leading = 0;
            }
            j--;
        }
        if (leading != 0) {
            builder.append(leading);
        }
        return builder.reverse().toString();
    }

    @Test
    public void test01() {
        System.out.println(addStrings("100", "200"));
        System.out.println(addStrings("101", "2202"));
        System.out.println(addStrings("999", "999"));
        System.out.println(addStrings("99", "9"));
    }
}
