package solution;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author huanfeng.xu
 * @date 2019-08-03 10:08
 * @see <a href="https://leetcode.com/problems/excel-sheet-column-number/">171. Excel Sheet Column Number</a>
 */
public class ExcelSheetColumnNumber {
    public int titleToNumber(String s) {
        int sum = 0;
        for (char c : s.toCharArray()) {
            sum = sum * 26 + ((c - 'A') + 1);
        }
        return sum;
    }

    @Test
    public void test01() {
        assertEquals(28, titleToNumber("AB"));
        assertEquals(701, titleToNumber("ZY"));
        assertEquals(1, titleToNumber("A"));
    }
}
