package solution;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author huanfeng.xu
 * @date 2019-08-04 14:49
 * @see <a href="https://leetcode.com/problems/first-unique-character-in-a-string/">387. First Unique Character in a String</a>
 */
public class FirstUniqueCharacterInAString {
    public int firstUniqChar(String s) {
        char[] cnt = new char[26];
        char[] chars = s.toCharArray();
        for (char c : chars) {
            cnt[c - 'a']++;
        }
        for (int i = 0; i < chars.length; i++) {
            if (cnt[chars[i] - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }

    @Test
    public void test01() {
        assertEquals(0, firstUniqChar("leetcode"));
        assertEquals(2, firstUniqChar("loveleetcode"));
    }
}
