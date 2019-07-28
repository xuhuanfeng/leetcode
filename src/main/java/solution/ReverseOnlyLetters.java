package solution;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author huanfeng.xu
 * @date 2019-07-28 9:33
 * @see <a href="https://leetcode.com/problems/reverse-only-letters/">917. Reverse Only Letters</a>
 */
public class ReverseOnlyLetters {
    public String reverseOnlyLetters(String S) {
        char[] chars = S.toCharArray();
        int left = 0, right = chars.length - 1;
        while (left < right) {
            while (left < right && !Character.isAlphabetic(chars[left])) {
                left++;
            }
            while (left < right && !Character.isAlphabetic(chars[right])) {
                right--;
            }

            if (left < right) {
                char tmp = chars[left];
                chars[left] = chars[right];
                chars[right] = tmp;
                right--;
                left++;
            }
        }
        return new String(chars);
    }

    @Test
    public void test01() {
        assertEquals("j-Ih-gfE-dCba", reverseOnlyLetters("a-bC-dEf-ghIj"));
        assertEquals("Qedo1ct-eeLg=ntse-T!", reverseOnlyLetters("Test1ng-Leet=code-Q!"));
    }
}
