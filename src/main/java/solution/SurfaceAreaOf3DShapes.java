package solution;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author huanfeng.xu
 * @date 2019-07-28 9:02
 * @see <a href="https://leetcode.com/problems/surface-area-of-3d-shapes/">892. Surface Area of 3D Shapes</a>
 */
public class SurfaceAreaOf3DShapes {
    public int surfaceArea(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int ans = 0;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (j > 0) {
                    ans += Math.abs(grid[i][j] - grid[i][j - 1]);
                } else {
                    ans += grid[i][j];
                }
                // System.out.println(i + "  " + ans);
            }
            ans += grid[i][col - 1];
        }

        for (int i = 0; i < col; i++) {
            for (int j = 0; j < row; j++) {
                if (j > 0) {
                    ans += Math.abs(grid[j][i] - grid[j - 1][i]);
                } else {
                    ans += Math.abs(grid[j][i]);
                }
            }
            ans += grid[row - 1][i];
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] != 0) {
                    ans += 2;
                }
            }
        }

        return ans;
    }

    /**
     * 采用抵消的做法，先算某一列的总面积，再减去本列重叠的，与x-1重叠的，与y-1重叠的
     *
     * @param grid 地图
     * @return 表面积
     */
    public int another(int[][] grid) {
        int res = 0;

        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return res;
        }

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                res += grid[i][j] * 6;

                if (grid[i][j] > 1) {
                    res -= (grid[i][j] - 1) * 2;
                }
                if (i - 1 >= 0) {
                    res -= Math.min(grid[i][j], grid[i - 1][j]) * 2;
                }

                if (j - 1 >= 0) {
                    res -= Math.min(grid[i][j], grid[i][j - 1]) * 2;
                }
            }
        }
        return res;
    }

    @Test
    public void test01() {
        assertEquals(10, surfaceArea(new int[][]{{2}}));
        assertEquals(34, surfaceArea(new int[][]{{1, 2}, {3, 4}}));
        assertEquals(16, surfaceArea(new int[][]{{1, 0}, {0, 2}}));
        assertEquals(32, surfaceArea(new int[][]{{1, 1, 1}, {1, 0, 1}, {1, 1, 1}}));
        assertEquals(46, surfaceArea(new int[][]{{2, 2, 2}, {2, 1, 2}, {2, 2, 2}}));
    }

    @Test
    public void test02() {
        assertEquals(10, another(new int[][]{{2}}));
        assertEquals(34, another(new int[][]{{1, 2}, {3, 4}}));
        assertEquals(16, another(new int[][]{{1, 0}, {0, 2}}));
        assertEquals(32, another(new int[][]{{1, 1, 1}, {1, 0, 1}, {1, 1, 1}}));
        assertEquals(46, another(new int[][]{{2, 2, 2}, {2, 1, 2}, {2, 2, 2}}));
    }
}
