package solution;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author huanfeng.xu
 * @date 2020-03-03 20:22
 * @see <a href="https://leetcode.com/problems/max-increase-to-keep-city-skyline/"></a>
 */
public class MaxIncreaseToKeepCitySkyline {
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int[] row = new int[grid.length];
        int[] col = new int[grid[0].length];

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                row[i] = Math.max(row[i], grid[i][j]);
                col[j] = Math.max(col[j], grid[i][j]);
            }
        }

        int ans = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                int min = Math.min(row[i], col[j]);
                ans += min - grid[i][j];

            }
        }

        return ans;
    }

    @Test
    public void test() {
        int[][] data = {{3, 0, 8, 4},
                {2, 4, 5, 7},
                {9, 2, 6, 3},
                {0, 3, 1, 0}};

        Assert.assertEquals(35, maxIncreaseKeepingSkyline(data));
    }
}
