package solution;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static junit.framework.TestCase.*;

/**
 * @author huanfeng.xu
 * @date 2019-09-09 20:54
 * @see <a href="https://leetcode.com/problems/isomorphic-strings/">205. Isomorphic Strings</a>
 */
public class IsomorphicStrings {
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> mapTo = new HashMap<>();
        Map<Character, Character> toMap = new HashMap<>();

        int length = s.length();

        for (int i = 0; i < length; i++) {
            char cS = s.charAt(i);
            char cT = t.charAt(i);

            Character cTo = mapTo.get(cS);
            if (cTo != null && cTo != cT) {
                return false;
            }

            Character toT = toMap.get(cT);
            if (cTo == null && toT != null) {
                return false;
            }
            mapTo.put(cS, cT);
            toMap.put(cT, cS);
        }
        return true;
    }

    @Test
    public void test01() {
        assertTrue(isIsomorphic("egg", "add"));
        assertFalse(isIsomorphic("foo", "bar"));
        assertTrue(isIsomorphic("paper", "title"));
        assertFalse(isIsomorphic("ab", "aa"));
    }
}
