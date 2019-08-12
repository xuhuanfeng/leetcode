package solution;

import org.junit.Test;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

/**
 * @author huanfeng.xu
 * @date 2019-08-10 10:12
 * @see <a href="https://leetcode.com/problems/is-subsequence/">392. Is Subsequence</a>
 */
public class IsSubsequence {
    public boolean isSubsequence(String s, String t) {
        int lenS = s.length();
        int lenT = t.length();

        int i = 0, j = 0;
        while (j < lenS && i < lenT) {
            if (t.charAt(i) == s.charAt(j)) {
                i++;
                j++;
            } else {
                i++;
            }
        }
        return j == lenS;
    }

    @Test
    public void test01() {
        assertTrue(isSubsequence("abc", "ahbgdc"));
        assertFalse(isSubsequence("axc", "ahbgdc"));
        assertFalse(isSubsequence("aec", "abcde"));
        assertTrue(isSubsequence("ace", "abcde"));
    }
}
