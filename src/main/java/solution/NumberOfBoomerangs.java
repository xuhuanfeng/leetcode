package solution;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import static org.junit.Assert.assertEquals;

/**
 * @author huanfeng.xu
 * @date 2019-08-04 14:57
 * @see <a href="https://leetcode.com/problems/number-of-boomerangs/">447. Number of Boomerangs</a>
 */
public class NumberOfBoomerangs {
    public int numberOfBoomerangs(int[][] points) {
        int cnt = 0;
        Map<Integer, Integer> maps = new HashMap<>();
        for (int i = 0; i < points.length; i++) {
            for (int j = 0; j < points.length; j++) {
                int d = distance(points[i], points[j]);
                maps.put(d, maps.getOrDefault(d, 0) + 1);
            }

            for (Integer value : maps.values()) {
                cnt += value * (value - 1);
            }
            maps.clear();
        }
        return cnt;
    }

    private int distance(int[] points1, int[] points2) {
        return (points1[0] - points2[0]) * (points1[0] - points2[0]) +
                (points1[1] - points2[1]) * (points1[1] - points2[1]);
    }

    @Test
    public void test01() {
        assertEquals(2, numberOfBoomerangs(new int[][]{{0, 0}, {1, 0}, {2, 0}}));
    }
}
