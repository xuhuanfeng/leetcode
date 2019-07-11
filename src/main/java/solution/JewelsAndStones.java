package solution;

import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author huanfeng.xu
 * @date 2019-07-11 21:58
 * @see <a href="https://leetcode.com/problems/jewels-and-stones/">771. Jewels and Stones</a>
 */
public class JewelsAndStones {

    public int numJewelsInStones(String J, String S) {
        int[] counter = new int[160];
        for (char c : S.toCharArray()) {
            counter[c] ++;
        }

        int cnt = 0;
        for (char c : J.toCharArray()) {
            cnt += counter[c];
        }
        return cnt;
    }

    @Test
    public void test01() {
        assertEquals(3, numJewelsInStones("aA", "aAAbbbb"));
    }

    @Test
    public void test02() {
        assertEquals(0, numJewelsInStones("z", "ZZ"));
    }
}
