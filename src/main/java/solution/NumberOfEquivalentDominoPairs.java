package solution;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

/**
 * @author huanfeng.xu
 * @date 2019-08-24 13:56
 * @see <a href="https://leetcode.com/problems/number-of-equivalent-domino-pairs/">1128. Number of Equivalent Domino Pairs</a>
 */
public class NumberOfEquivalentDominoPairs {
    public int numEquivDominoPairs(int[][] dominoes) {
        Map<String, Integer> map = new HashMap<>();
        int cnt = 0;
        for (int[] dominoe : dominoes) {
            String key1 = dominoe[1] + "-" + dominoe[0];
            String key2 = dominoe[0] + "-" + dominoe[1];
            Integer val1 = map.getOrDefault(key1, 0);
            Integer val2 = map.getOrDefault(key2, 0);
            if (!key1.equals(key2)) {
                cnt += val1;
                cnt += val2;
            } else {
                cnt += val1;
            }
            map.put(key2, val2 + 1);
        }
        return cnt;
    }

    public int betterOne(int[][] dominoes) {
        Map<Integer, Integer> map = new HashMap<>();
        int cnt = 0;
        for (int[] dominoe : dominoes) {
            int min = Math.min(dominoe[0], dominoe[1]);
            int max = Math.max(dominoe[0], dominoe[1]);
            int key = max * 10 + min;
            Integer val = map.getOrDefault(key, 0);
            cnt += val;
            map.put(key, val + 1);
        }
        return cnt;
    }


    @Test
    public void test01() {
        assertEquals(1, numEquivDominoPairs(new int[][]{{1, 2}, {2, 1}, {3, 4}, {5, 6}}));
        assertEquals(4, numEquivDominoPairs(new int[][]{{1, 1}, {2, 2}, {1, 1}, {1, 2}, {2, 1}, {1, 1}}));
    }

    @Test
    public void test02() {
        assertEquals(1, betterOne(new int[][]{{1, 2}, {2, 1}, {3, 4}, {5, 6}}));
        assertEquals(4, betterOne(new int[][]{{1, 1}, {2, 2}, {1, 1}, {1, 2}, {2, 1}, {1, 1}}));
    }
}
