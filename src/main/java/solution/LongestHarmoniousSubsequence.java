package solution;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import static org.junit.Assert.assertEquals;

/**
 * @author huanfeng.xu
 * @date 2019-08-26 21:00
 * @see <a href="https://leetcode.com/problems/longest-harmonious-subsequence/">594. Longest Harmonious Subsequence</a>
 */
public class LongestHarmoniousSubsequence {

    public int findLHS(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int maxn = 0;
        for (Integer integer : map.keySet()) {
            Integer pre = map.getOrDefault(integer - 1, -1);
            Integer current = map.get(integer);
            if (pre != -1 && pre + current > maxn) {
                maxn = pre + current;
            }
        }
        return maxn;
    }

    @Test
    public void test01() {
        assertEquals(5, findLHS(new int[]{1, 3, 2, 2, 5, 2, 3, 7}));
        assertEquals(0, findLHS(new int[]{}));
        assertEquals(0, findLHS(new int[]{1, 1, 1, 1}));
//        findLHS(new int[]{1, 3, 2, 2, 5, 2, 3, 7});
    }
}
