package solution;

import org.junit.Test;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

/**
 * @author huanfeng.xu
 * @date 2019-08-04 14:52
 * @see <a href="https://leetcode.com/problems/ransom-note/">https://leetcode.com/problems/ransom-note/</a>
 */
public class RansomNote {
    public boolean canConstruct(String ransomNote, String magazine) {
        char[] magazines = new char[26];
        for (char c : magazine.toCharArray()) {
            magazines[c - 'a']++;
        }

        for (char c : ransomNote.toCharArray()) {
            if (magazines[c - 'a'] > 0) {
                magazines[c - 'a']--;
            } else {
                return false;
            }
        }
        return true;
    }

    @Test
    public void test01() {
        assertFalse(canConstruct("a", "b"));
        assertFalse(canConstruct("aa", "ab"));
        assertTrue(canConstruct("aa", "aab"));
    }
}
