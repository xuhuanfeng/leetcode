package solution;

import org.junit.Test;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

/**
 * @author huanfeng.xu
 * @date 2019-08-24 14:17
 * @see <a href="https://leetcode.com/problems/palindrome-number/">9. Palindrome Number</a>
 */
public class PalindromeNumber {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        int result = 0;
        int tmp = x;
        while (tmp != 0) {
            result = result * 10 + (tmp % 10);
            tmp /= 10;
        }
        return result == x;
    }

    @Test
    public void test01() {
        assertTrue(isPalindrome(121));
        assertFalse(isPalindrome(-121));
        assertFalse(isPalindrome(10));
    }
}
