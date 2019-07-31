package solution;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author huanfeng.xu
 * @date 2019-07-31 22:51
 * @see <a href="https://leetcode.com/problems/find-the-difference/">389. Find the Difference</a>
 */
public class FindTheDifference {
    public char findTheDifference(String s, String t) {
        int len = s.length();
        int target = 0;
        for (int i = 0; i < len; i++) {
            target = target ^ s.charAt(i) ^ t.charAt(i);
        }
        target ^= t.charAt(len);
        return (char) target;
    }

    @Test
    public void test01() {
        assertEquals('e', findTheDifference("abcd", "abcde"));
    }
}
