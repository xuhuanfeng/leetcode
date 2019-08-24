package solution;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author huanfeng.xu
 * @date 2019-08-24 14:40
 * @see <a href="https://leetcode.com/problems/long-pressed-name/">925. Long Pressed Name</a>
 */
public class LongPressedName {
    public boolean isLongPressedName(String name, String typed) {
        int nameLen = name.length();
        char[] names = name.toCharArray();
        int typeLen = typed.length();
        char[] types = typed.toCharArray();
        int i = 0, j = 0;
        while (i < nameLen && j < typeLen) {
            if (names[i] == types[j]) {
                i++;
                j++;
            } else if (j > 0 && types[j - 1] == types[j]) {
                j++;
            } else {
                return false;
            }
        }
        if (i < nameLen && j == typeLen) {
            return false;
        }
        if (i == nameLen && j == typeLen) {
            return true;
        }

        while (j + 1 < typeLen) {
            if (types[j] != types[j + 1]) {
                return false;
            }
            j++;
        }
        return true;
    }

    @Test
    public void test01() {
        assertTrue(isLongPressedName("alex", "aaleex"));
        assertFalse(isLongPressedName("saeed", "ssaaedd"));
        assertTrue(isLongPressedName("leelee", "lleeelee"));
        assertTrue(isLongPressedName("laiden", "laiden"));
        assertTrue(isLongPressedName("vtkgn", "vttkgnn"));
        assertFalse(isLongPressedName("pyplrz", "ppyypllr"));
    }
}
