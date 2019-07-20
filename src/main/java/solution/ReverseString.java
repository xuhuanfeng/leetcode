package solution;

import org.junit.Test;

/**
 * @author huanfeng.xu
 * @date 2019-07-20 22:10
 * @see <a href='https://leetcode.com/problems/reverse-string/'>344. Reverse String</a>
 */
public class ReverseString {
    public void reverseString(char[] s) {
        int cnt = s.length / 2;
        int len = s.length;
        for (int i = 0; i < cnt; i++) {
            char temp = s[i];
            s[i] = s[len - 1 - i];
            s[len - 1 - i] = temp;
        }
    }

    @Test
    public void test01() {
        char[] s = {'h','e','l','l','o'};
        reverseString(s);
        System.out.println(s);
    }
}
