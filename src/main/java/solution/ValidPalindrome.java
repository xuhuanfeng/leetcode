package solution;

import org.junit.Test;

import static org.junit.Assert.assertFalse;

/**
 * @author huanfeng.xu
 * @date 2019-09-15 16:44
 * @see <a href="https://leetcode.com/problems/valid-palindrome/">125. Valid Palindrome</a>
 */
public class ValidPalindrome {
    public boolean isPalindrome(String s) {
        char[] chars = s.toCharArray();
        int rightIndex = chars.length - 1;
        int leftIndex = 0;
        while (leftIndex < rightIndex) {
            while (leftIndex < rightIndex && !Character.isLetterOrDigit(chars[leftIndex])) {
                leftIndex++;
            }

            while (leftIndex < rightIndex && !Character.isLetterOrDigit(chars[rightIndex])) {
                rightIndex--;
            }
            if (leftIndex < rightIndex) {
                if (Character.toUpperCase(chars[leftIndex]) != Character.toUpperCase(chars[rightIndex])) {
                    return false;
                }
            }
            leftIndex++;
            rightIndex--;
        }
        return true;
    }

    @Test
    public void test01() {
        assertFalse(isPalindrome("0P"));
    }
}
