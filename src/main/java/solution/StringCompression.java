package solution;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author huanfeng.xu
 * @date 2019-09-09 20:30
 * @see <a href='https://leetcode.com/problems/string-compression/'>443. String Compression</a>
 */
public class StringCompression {
    public int compress(char[] chars) {
        int cnt = 1;
        int index = 0;
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] == chars[i - 1]) {
                cnt++;
            } else {
                chars[index++] = chars[i - 1];
                if (cnt > 1) {
                    String s = Integer.toString(cnt, 10);
                    for (char c : s.toCharArray()) {
                        chars[index++] = c;
                    }
                }
                cnt = 1;
            }
        }
        chars[index++] = chars[chars.length - 1];
        if (cnt > 1) {
            String s = Integer.toString(cnt, 10);
            for (char c : s.toCharArray()) {
                chars[index++] = c;
            }
        }
        return index != 0 ? index : 1;
    }

    @Test
    public void test01() {
        assertEquals(6, compress(new char[]{'a', 'a', 'b', 'b', 'c', 'c', 'c'}));
        assertEquals(4, compress(new char[]{'a', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b'}));
        assertEquals(1, compress(new char[]{'a'}));
        assertEquals(3, compress(new char[]{'a', 'b', 'c'}));
    }
}
