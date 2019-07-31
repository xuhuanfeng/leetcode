package solution;

import org.junit.Test;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

/**
 * @author huanfeng.xu
 * @date 2019-07-31 22:56
 * @see <a href="https://leetcode.com/problems/valid-anagram/">242. Valid Anagram</a>
 */
public class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        int[] dataS = new int[26];
        int[] dataT = new int[26];
        for (char c : s.toCharArray()) {
            dataS[c - 'a']++;
        }

        for (char c : t.toCharArray()) {
            dataT[c - 'a']++;
        }
        for (int i = 0; i < dataS.length; i++) {
            if (dataS[i] != dataT[i]) {
                return false;
            }
        }
        return true;
    }

    @Test
    public void test01() {
        assertTrue(isAnagram("anagram", "nagaram"));
        assertFalse(isAnagram("rat", "car"));
    }
}
