package solution;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author huanfeng.xu
 * @date 2019-07-30 21:40
 * @see <a href="https://leetcode.com/problems/count-binary-substrings/">696. Count Binary Substrings</a>
 */
public class CountBinarySubstrings {
    public int countBinarySubstrings(String s) {
        char[] chars = s.toCharArray();
        int zeroCount = 0;
        int oneCount = 0;
        int ans = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '0') {
                zeroCount++;
            } else {
                oneCount++;
            }
            if (i + 1 < chars.length) {
                if (chars[i] != chars[i + 1]) {
                    ans += Math.min(zeroCount, oneCount);
                    if (chars[i + 1] == '0') {
                        zeroCount = 0;
                    } else {
                        oneCount = 0;
                    }
                }
            } else {
                ans += Math.min(zeroCount, oneCount);
            }
        }
        return ans;
    }

    @Test
    public void test01() {
        assertEquals(6, countBinarySubstrings("00110011"));
        assertEquals(2, countBinarySubstrings("101"));
        assertEquals(4, countBinarySubstrings("10101"));
    }
}
