package solution;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author huanfeng.xu
 * @date 2019-07-24 21:31
 * @see <a href="https://leetcode.com/problems/goat-latin/">824. Goat Latin</a>
 */
public class GoatLatin {
    public String toGoatLatin(String S) {
        StringBuilder builder = new StringBuilder();
        String[] s = S.split(" ");
        for (int i = 0; i < s.length; i++) {
            int firstChar = s[i].charAt(0);
            if (firstChar >= 'A' && firstChar <= 'Z') {
                firstChar = firstChar + ('a' - 'A');
            }
            // System.out.println((char) firstChar);
            if (firstChar == 'a' ||
                    firstChar == 'e' ||
                    firstChar == 'i' ||
                    firstChar == 'o' ||
                    firstChar == 'u') {
                builder.append(s[i]).append("ma");
            } else {
                builder.append(s[i].substring(1)).append(s[i].charAt(0)).append("ma");
            }
            for (int j = 1; j <= i + 1; j++) {
                builder.append('a');
            }
            if (i < s.length - 1) {
                builder.append(" ");
            }
        }
        return builder.toString();
    }

    @Test
    public void test01() {
        assertEquals("Imaa peaksmaaa oatGmaaaa atinLmaaaaa", toGoatLatin("I speak Goat Latin"));
    }
}
