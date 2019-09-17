package solution;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author huanfeng.xu
 * @date 2019-09-17 20:39
 * @see <a href="https://leetcode.com/problems/excel-sheet-column-title/">168. Excel Sheet Column Title</a>
 */
public class ExcelSheetColumnTitle {
    public String convertToTitle(int n) {
        StringBuilder builder = new StringBuilder();
        while (n != 0) {
            n--;
            int mod = n % 26;
            builder.append((char) (mod + 'A'));
            n /= 26;
        }
        return builder.reverse().toString();
    }

    @Test
    public void test01() {
        assertEquals("A", convertToTitle(1));
        assertEquals("AB", convertToTitle(28));
        assertEquals("ZY", convertToTitle(701));
    }
}
