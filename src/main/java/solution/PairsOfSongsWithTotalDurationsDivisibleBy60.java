package solution;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

/**
 * @author huanfeng.xu
 * @date 2019-08-12 21:51
 * @see <a href="https://leetcode.com/problems/pairs-of-songs-with-total-durations-divisible-by-60/">1010. Pairs of Songs With Total Durations Divisible by 60</a>
 */
public class PairsOfSongsWithTotalDurationsDivisibleBy60 {
    /**
     * 参考网友答案才理解，一开始暴力做，直接超时了....
     * 由于 (a+b)%60==0，所以此时 b = (60 - a % 60) % 60
     * 再一次感受到智商不够用....膜拜大佬们
     * @param time
     * @return
     */
    public int numPairsDivisibleBy60(int[] time) {
        int cnt = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : time) {
            int d = (60 - i % 60) % 60;
            cnt += map.getOrDefault(d, 0);
            map.put(i % 60, map.getOrDefault(i % 60, 0) + 1);
        }
        return cnt;
    }

    @Test
    public void test01() {
        assertEquals(3, numPairsDivisibleBy60(new int[]{30, 20, 150, 100, 40}));
        assertEquals(3, numPairsDivisibleBy60(new int[]{60, 60, 60}));
    }
}
