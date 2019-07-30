package solution;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

import static org.junit.Assert.assertEquals;

/**
 * @author huanfeng.xu
 * @date 2019-07-30 21:01
 * @see <a href="https://leetcode.com/problems/two-city-scheduling/">1029. Two City Scheduling</a>
 */
public class TwoCityScheduling {

    public int twoCitySchedCost(int[][] costs) {
        Arrays.sort(costs, Comparator.comparingInt(o -> (o[0] - o[1])));
        int result = 0;
        int len = costs.length;
        for (int i = 0; i < len / 2; i++) {
            result += costs[i][0];
            result += costs[i + len / 2][1];
        }
        return result;
    }

    @Test
    public void test01() {
        assertEquals(110, twoCitySchedCost(new int[][]{{10, 20}, {30, 200}, {400, 50}, {30, 20}}));
        assertEquals(4723, twoCitySchedCost(new int[][]{{70, 311}, {74, 927}, {732, 711}, {126, 583}, {857, 118}, {97, 928}, {975, 843}, {175, 221},
                {284, 929}, {816, 602}, {689, 863}, {721, 888}}));
    }
}
