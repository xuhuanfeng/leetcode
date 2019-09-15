package solution;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author huanfeng.xu
 * @date 2019-09-15 16:55
 * @see <a href="https://leetcode.com/problems/length-of-last-word/">58. Length of Last Word</a>
 */
public class LengthOfLastWord {
    public int lengthOfLastWord(String s) {
        s = s.trim();
        if (s.isEmpty()) {
            return 0;
        }
        String[] s1 = s.split(" ");
        return s1[s1.length - 1].length();
    }

    @Test
    public void test01() {
        assertEquals(5, lengthOfLastWord("hello world"));
        assertEquals(5, lengthOfLastWord("hello "));
    }
}
