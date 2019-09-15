package solution;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author huanfeng.xu
 * @date 2019-09-15 9:27
 * @see <a href="https://leetcode.com/problems/implement-strstr/">28. Implement strStr()</a>
 */
public class ImplementstrStr {
    public int strStr(String haystack, String needle) {
        if (needle == null || needle.length() == 0) {
            return 0;
        }

        int[] k = new int[needle.length() + 1];
        k[0] = -1;
        int i = -1, j = 0;
        while (j < needle.length()) {
            if (i == -1 || needle.charAt(i) == needle.charAt(j)) {
                j++;
                i++;
                k[j] = i;
            } else {
                i = k[i];
            }
        }
//        System.out.println(Arrays.toString(k));

        i = 0;
        j = 0;

        while (j < haystack.length()) {
            if (i == -1 || haystack.charAt(j) == needle.charAt(i)) {
                i++;
                j++;
//                System.out.println("i " + i + " j " + j);
                if (i == needle.length()) {
                    return j - i;
                }
            } else {
                i = k[i];
            }
        }
        return -1;
    }

    @Test
    public void test01() {
        System.out.println(strStr("hello", "ll"));
        System.out.println(strStr("aaaaa", "bba"));
        System.out.println(strStr("abc", "bc"));
        System.out.println(strStr("mississippi", "issip"));
    }
}
