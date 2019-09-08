package solution;

import org.junit.Test;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

/**
 * @author huanfeng.xu
 * @date 2019-09-08 8:32
 * @see <a href="https://leetcode.com/problems/repeated-substring-pattern/">459. Repeated Substring Pattern</a>
 */
public class RepeatedSubstringPattern {
    public boolean repeatedSubstringPattern(String s) {
        char[] chars = s.toCharArray();
        for (int k = 1; k < chars.length; k++) {
            if (chars.length % k == 0) {
                int i;
                for (i = 0; i < chars.length; i++) {
                    if (chars[i] != chars[(i + k) % chars.length]) {
                        break;
                    }
                }
                if (i == chars.length) {
                    return true;
                }
            }
        }
        return false;
    }

    @Test
    public void test01() {
        assertTrue(repeatedSubstringPattern("abab"));
        assertFalse(repeatedSubstringPattern("aba"));
        assertTrue(repeatedSubstringPattern("abcabcabcabc"));
    }
}
