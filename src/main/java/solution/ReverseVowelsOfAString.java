package solution;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static org.junit.Assert.assertEquals;

/**
 * @author huanfeng.xu
 * @date 2019-09-03 20:08
 * @see <a href="https://leetcode.com/problems/reverse-vowels-of-a-string/">345. Reverse Vowels of a String</a>
 */
public class ReverseVowelsOfAString {
    public String reverseVowels(String s) {
        int start = 0;
        int end = s.length() - 1;
        Set<Character> set = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));
        char[] chars = s.toCharArray();
        while (start < end) {
            if (!set.contains(chars[start])) {
                start++;
            } else if (!set.contains(chars[end])) {
                end--;
            } else {
                char tmp = chars[start];
                chars[start] = chars[end];
                chars[end] = tmp;
                start++;
                end--;
            }
        }
        return new String(chars);
    }

    @Test
    public void test01() {
        assertEquals("holle", reverseVowels("hello"));
        assertEquals("leotcede", reverseVowels("leetcode"));
    }
}

