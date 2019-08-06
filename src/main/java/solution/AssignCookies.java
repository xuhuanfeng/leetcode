package solution;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

/**
 * @author huanfeng.xu
 * @date 2019-08-06 21:09
 * @see <a href="https://leetcode.com/problems/assign-cookies/">455. Assign Cookies</a>
 */
public class AssignCookies {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);

        int cnt = 0;
        for (int i = 0, j = 0; i < g.length && j < s.length; j++) {
            if (s[j] >= g[i]) {
                cnt++;
                i++;
            }
        }
        return cnt;
    }

    @Test
    public void test01() {
        assertEquals(1, findContentChildren(new int[]{1, 2, 3}, new int[]{1, 1}));
        assertEquals(2, findContentChildren(new int[]{1, 2}, new int[]{1, 2, 3}));
    }
}
