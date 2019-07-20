package solution;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author huanfeng.xu
 * @date 2019-07-20 22:23
 * @see <a href="https://leetcode.com/problems/number-of-lines-to-write-string/">806. Number of Lines To Write String</a>
 */
public class NumberOfLinesToWriteString {
    public int[] numberOfLines(int[] widths, String S) {
        int line = 0;
        int width = 100;
        for (char c : S.toCharArray()) {
            int cc = widths[c - 'a'];
            if (width - cc >= 0) {
                width -= cc;
                if (width == 0) {
                    width = 100;
                    line++;
                }
            } else {
                width = 100 - cc;
                line++;
            }
        }
        return new int[]{line + 1, 100 - width};
    }

    @Test
    public void test01() {
        int[] a = new int[]{10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10};
        System.out.println(Arrays.toString(numberOfLines(a, "abcdefghijklmnopqrstuvwxyz")));
        a = new int[]{4, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10};
        System.out.println(Arrays.toString(numberOfLines(a, "bbbcccdddaaa")));
    }
}
