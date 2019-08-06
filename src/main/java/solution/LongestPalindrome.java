package solution;

import org.junit.Test;

import java.util.Map;

import static org.junit.Assert.assertEquals;

/**
 * @author huanfeng.xu
 * @date 2019-08-06 21:37
 * @see <a href="https://leetcode.com/problems/longest-palindrome/">409. Longest Palindrome</a>
 */
public class LongestPalindrome {
    public int longestPalindrome(String s) {
        int[] data = new int[128];
        for (char c : s.toCharArray()) {
            data[c]++;
        }
        int even = 0;
        int maxOdd = 0;
        for (int datum : data) {
            if (datum % 2 == 1 && datum > maxOdd) {
                maxOdd = datum;
            }
        }
        even += maxOdd;
        for (int datum : data) {
            if (datum % 2 == 0) {
                even += datum;
            } else {
                if (datum > 1 && datum != maxOdd) {
                    even += datum - 1;
                } else if (maxOdd == datum) {
                    maxOdd = -1;
                }
            }
        }
        return even;
    }

    // official solution
    public int another(String s) {
        int[] count = new int[128];
        for (char c: s.toCharArray()) {
            count[c]++;
        }

        int ans = 0;
        for (int v: count) {
            // 这里特别优雅,  v/2 * 2 可以得到偶数部分
            ans += v / 2 * 2;
            // 如果此时ans是偶数，并且v是奇数，则+1，此后ans一直是奇数，不会再加1了
            if (ans % 2 == 0 && v % 2 == 1) {
                ans++;
            }
        }
        return ans;
    }

    @Test
    public void test01() {
        assertEquals(7, longestPalindrome("abccccdd"));
        assertEquals(3, longestPalindrome("ccc"));
        assertEquals(5, longestPalindrome("aaccc"));
        System.out.println(longestPalindrome("aaabbb"));
    }
}
