package solution;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

/**
 * @author huanfeng.xu
 * @date 2019-09-18 20:39
 * @see <a href="https://leetcode.com/problems/buddy-strings/">859. Buddy Strings</a>
 */
public class BuddyStrings {
    public boolean buddyStrings(String A, String B) {

        if (A.length() != B.length()) {
            return false;
        }

        char[] helper = new char[26];

        List<Integer> diffIndex = new ArrayList<>();
        for (int i = 0; i < A.length(); i++) {
            if (A.charAt(i) != B.charAt(i)) {
                diffIndex.add(i);
            }
            helper[A.charAt(i) - 'a']++;
        }

        boolean sign = false;
        for (int i = 0; i < 26; i++) {
            if (helper[i] >= 2) {
                sign = true;
                break;
            }
        }

        if (diffIndex.size() == 0 && sign) {
            return true;
        }
        if (diffIndex.size() != 2) {
            return false;
        }

        int firstIndex = diffIndex.get(0);
        int secondIndex = diffIndex.get(1);

        return A.charAt(firstIndex) == B.charAt(secondIndex) && A.charAt(secondIndex) == B.charAt(firstIndex);
    }

    @Test
    public void test01() {
        assertTrue(buddyStrings("ab", "ba"));
        assertFalse(buddyStrings("ab", "ab"));
        assertTrue(buddyStrings("aa", "aa"));
        assertFalse(buddyStrings("", "ab"));
    }
}
