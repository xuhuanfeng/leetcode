package solution;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author huanfeng.xu
 * @date 2019-07-14 10:57
 * @see <a href="https://leetcode.com/problems/di-string-match/ ">942. DI String Match</a>
 */
public class DIStringMatch {

    public int[] diStringMatch(String S) {
        int len = S.length();
        int[] result = new int[len + 1];

        int min = 0, max = len;
        int index = 0;
        for (char c : S.toCharArray()) {
            if (c == 'I') {
                result[index++] = min++;
            } else {
                result[index++] = max--;
            }
        }
        result[index] = max;
        return result;
    }

    @Test
    public void test01() {
        System.out.println(Arrays.toString(diStringMatch("IDID")));
        System.out.println(Arrays.toString(diStringMatch("III")));
    }
}
