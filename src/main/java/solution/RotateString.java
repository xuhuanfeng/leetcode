package solution;

import org.junit.Test;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

/**
 * @author huanfeng.xu
 * @date 2019-08-05 21:36
 * @see <a href="https://leetcode.com/problems/rotate-string/">796. Rotate String</a>
 */
public class RotateString {
    public boolean rotateString(String A, String B) {
        if (A.length() != B.length()) {
            return false;
        }
        if (A.equals(B)) {
            return true;
        }

        char[] a = A.toCharArray();
        char[] b = B.toCharArray();
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < b.length; j++) {
                if (a[i] == b[j]) {
                    int tmp = i;
                    int cnt = 0;
                    while (cnt < b.length) {
                        if (a[tmp % a.length] != b[cnt]) {
                            break;
                        }
                        tmp++;
                        cnt++;
                    }
                    if (cnt == b.length) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    @Test
    public void test01() {
        assertTrue(rotateString("abcd", "bcda"));
        assertFalse(rotateString("abcde", "abcdf"));
    }
}
