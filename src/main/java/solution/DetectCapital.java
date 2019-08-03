package solution;

import org.junit.Test;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

/**
 * @author huanfeng.xu
 * @date 2019-08-03 9:16
 * @see <a href="https://leetcode.com/problems/detect-capital/">520. Detect Capital</a>
 */
public class DetectCapital {
    public boolean detectCapitalUse(String word) {
        int upper = 0, lower = 0;
        for (char c : word.toCharArray()) {
            if (c >= 'A' && c <= 'Z') {
                upper++;
            } else {
                lower++;
            }
        }
        if (upper == 0 || lower == 0) {
            return true;
        }
        char first = word.charAt(0);
        return upper == 1 && Character.isUpperCase(first);
    }

    @Test
    public void test01() {
        assertTrue(detectCapitalUse("USA"));
        assertFalse(detectCapitalUse("FlaG"));
    }
}
