package solution;

import org.junit.Test;

import static junit.framework.TestCase.assertTrue;

/**
 * @author huanfeng.xu
 * @date 2019-09-13 8:32
 * @see <a href="https://leetcode.com/problems/valid-palindrome-ii/">680. Valid Palindrome II</a>
 */
public class ValidPalindromeII {
    public boolean validPalindrome(String s) {
        char[] chars = s.toCharArray();

        int right = s.length() - 1;
        int left = 0;

        while (left < right) {
            if (chars[left] == chars[right]) {
                left++;
                right--;
            } else {
                return canFind(left + 1, right, chars) || canFind(left, right - 1, chars);
            }
        }
        return true;
    }

    public boolean canFind(int left, int right, char[] data) {
        while (left < right) {
            if (data[left] == data[right]) {
                left++;
                right--;
            } else {
                return false;
            }
        }
        return true;
    }

    @Test
    public void test01() {
        assertTrue(validPalindrome("aba"));
        assertTrue(validPalindrome("abca"));
    }
}
