package solution;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author huanfeng.xu
 * @date 2019-09-13 7:56
 * @see <a href="https://leetcode.com/problems/longest-common-prefix/">14. Longest Common Prefix</a>
 */
public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        int minLen = strs[0].length();

        for (String str : strs) {
            if (str.length() < minLen) {
                minLen = str.length();
            }
        }

        int idx = 0;
        for (idx = 0; idx < minLen; idx++) {
            int i;
            for (i = 0; i < strs.length; i++) {
                if (i > 0 && strs[i].charAt(idx) != strs[i - 1].charAt(idx)) {
                    break;
                }
            }
            if (i < strs.length) {
                break;
            }
        }

        if (idx > 0) {
            return strs[0].substring(0, idx);
        }
        return "";
    }

    @Test
    public void test01() {
        assertEquals("fl", longestCommonPrefix(new String[]{"flower", "flow", "flight"}));
        assertEquals("", longestCommonPrefix(new String[]{"dog", "racecar", "car"}));
    }
}
