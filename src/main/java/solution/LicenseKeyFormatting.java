package solution;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author huanfeng.xu
 * @date 2019-09-07 8:48
 * @see <a href="https://leetcode.com/problems/license-key-formatting/">482. License Key Formatting</a>
 */
public class LicenseKeyFormatting {
    public String licenseKeyFormatting(String S, int K) {
        StringBuilder ans = new StringBuilder();

        char[] chars = S.toCharArray();
        int cnt = 0;
        for (int i = chars.length - 1; i >= 0; i--) {
            if (chars[i] != '-') {
                ans.append(Character.toUpperCase(chars[i]));
                cnt++;
            }
            if (cnt == K) {
                cnt = 0;
                ans.append("-");
            }
        }
        String result = ans.reverse().toString();
        if (result.length() > 0 && result.charAt(0) == '-') {
            return result.substring(1);
        }
        return result;
    }

    @Test
    public void test01() {
        assertEquals("5F3Z-2E9W", licenseKeyFormatting("5F3Z-2e-9-w", 4));
        assertEquals("2-5G-3J", licenseKeyFormatting("2-5g-3-J", 2));
        assertEquals("AA-AA", licenseKeyFormatting("----aa-a-a----", 2));
    }
}
