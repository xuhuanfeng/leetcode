package solution;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author huanfeng.xu
 * @date 2019-07-27 7:17
 * @see <a href="https://leetcode.com/problems/longest-uncommon-subsequence-i/">521. Longest Uncommon Subsequence I</a>
 */
public class LongestUncommonSubsequenceI {
    public int findLUSlength(String a, String b) {
        if (a.equals(b)) {
            return -1;
        }
        return Math.max(a.length(), b.length());
    }

    @Test
    public void test01() {
        assertEquals(3, findLUSlength("abc", "cdc"));
        assertEquals(5, findLUSlength("abcde", "ghj"));
        assertEquals(9, findLUSlength("abcdefghi", "abcd"));
    }
}
