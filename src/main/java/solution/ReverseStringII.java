package solution;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author huanfeng.xu
 * @date 2019-08-12 21:08
 * @see <a href="https://leetcode.com/problems/reverse-string-ii/">541. Reverse String II</a>
 */
public class ReverseStringII {
    public String reverseStr(String s, int k) {
        char[] chars = s.toCharArray();
        int cnt = 0;
        StringBuilder builder = new StringBuilder();
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < chars.length; i++) {
            if (cnt < k) {
                builder.append(chars[i]);
                cnt++;
            } else if (cnt < 2 * k) {
                if (builder.length() > 0) {
                    result.append(builder.reverse());
                    builder = new StringBuilder();
                }
                result.append(chars[i]);
                cnt++;
            } else {
                cnt = 0;
                i--;
            }
        }
        if (builder.length() > 0) {
            result.append(builder.reverse());
        }
        return result.toString();
    }

    public String another(String s, int k) {
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i += 2 * k) {
            int idx = i;
            // good job
            int end = Math.min(i + k - 1, chars.length - 1);
            while (idx < end) {
                char tmp = chars[idx];
                chars[idx] = chars[end];
                chars[end] = tmp;
                idx++;
                end--;
            }
        }
        return new String(chars);
    }

    @Test
    public void test01() {
        assertEquals("bacdfeg", reverseStr("abcdefg", 2));
        assertEquals("cbadefhg", reverseStr("abcdefgh", 3));
        assertEquals("dcbaefg", reverseStr("abcdefg", 4));
    }

    @Test
    public void test02() {
        assertEquals("bacdfeg", another("abcdefg", 2));
        assertEquals("cbadefhg", another("abcdefgh", 3));
        assertEquals("dcbaefg", another("abcdefg", 4));
    }
}
