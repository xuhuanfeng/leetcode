package solution;

import org.junit.Test;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.assertEquals;

/**
 * @author huanfeng.xu
 * @date 2019-07-30 20:07
 * @see <a href="https://leetcode.com/problems/greatest-common-divisor-of-strings/">1071. Greatest Common Divisor of Strings</a>
 */
public class GreatestCommonDivisorOfStrings {
    public String gcdOfStrings(String str1, String str2) {
        if (str1.equals(str2)) {
            return str1;
        }
        int len1 = str1.length();
        int len2 = str2.length();
        if (len1 < len2) {
            String tmp = str1;
            str1 = str2;
            str2 = tmp;
        }

        List<Integer> list = new LinkedList<>();

        int len = str2.length();
        char[] chars = str2.toCharArray();
        for (int i = len / 2; i > 0; i--) {
            boolean find = true;
            if (len % i == 0) {
                for (int k = 0; k < len; k++) {
                    if (chars[k] != chars[(k + i) % len]) {
                        find = false;
                        break;
                    }
                }
                if (find) {
                    list.add(i);
                }
            }
        }
        if (list.size() == 0) {
            list.add(len);
        }
        len = str1.length();
        char[] chars1 = str1.toCharArray();
        for (Integer integer : list) {
            int i;
            int j = 0;
            if (len % integer == 0) {
                for (i = 0; i < len; i++) {
                    if (chars1[i] != chars[j % integer]) {
                        break;
                    }
                    j++;
                }
                if (i == len) {
                    return str2.substring(0, integer);
                }
            }
        }
        return "";
    }
    // better one
    public String another(String str1, String str2) {
        if (str1.length() < str2.length()) {
            return another(str2, str1);
        } else if (!str1.startsWith(str2)) {
            return "";
        } else if (str2.isEmpty()) {
            return str1;
        } else {
            return another(str1.substring(str2.length()), str2);
        }
    }

    @Test
    public void test01() {
        assertEquals("ABC", gcdOfStrings("ABCABC", "ABC"));
        assertEquals("AB", gcdOfStrings("ABABAB", "ABAB"));
        assertEquals("", gcdOfStrings("LEET", "CODE"));
        assertEquals("TAUXX", gcdOfStrings("TAUXXTAUXXTAUXXTAUXXTAUXX",
                "TAUXXTAUXXTAUXXTAUXXTAUXXTAUXXTAUXXTAUXXTAUXX"));
        assertEquals("NLZGM", gcdOfStrings("NLZGMNLZGMNLZGMNLZGMNLZGMNLZGMNLZGMNLZGM",
                "NLZGMNLZGMNLZGMNLZGMNLZGMNLZGMNLZGMNLZGMNLZGM"));
    }

    @Test
    public void test02() {
        assertEquals("ABC", another("ABCABC", "ABC"));
        assertEquals("AB", another("ABABAB", "ABAB"));
        assertEquals("", another("LEET", "CODE"));
        assertEquals("TAUXX", another("TAUXXTAUXXTAUXXTAUXXTAUXX",
                "TAUXXTAUXXTAUXXTAUXXTAUXXTAUXXTAUXXTAUXXTAUXX"));
        assertEquals("NLZGM", another("NLZGMNLZGMNLZGMNLZGMNLZGMNLZGMNLZGMNLZGM",
                "NLZGMNLZGMNLZGMNLZGMNLZGMNLZGMNLZGMNLZGMNLZGM"));
    }
}
