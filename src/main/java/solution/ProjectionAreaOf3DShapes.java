package solution;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author huanfeng.xu
 * @date 2019-07-14 21:56
 * @see <a href="https://leetcode.com/problems/projection-area-of-3d-shapes/">883. Projection Area of 3D Shapes</a>
 */
public class ProjectionAreaOf3DShapes {

    public int projectionArea(int[][] grid) {
        int row = grid.length;

        int result = 0;
        for (int i = 0; i < row; i++) {
            int tMax = grid[i][0];
            for (int j = 1; j < row; j++) {
                if (grid[i][j] > tMax) {
                    tMax = grid[i][j];
                }
            }
            result += tMax;
        }
        for (int i = 0; i < row; i++) {
            int tMax = grid[0][i];
            for (int j = 1; j < row; j++) {
                if (grid[j][i] > tMax) {
                    tMax = grid[j][i];
                }
            }
            result += tMax;
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < row; j++) {
                if (grid[i][j] != 0) {
                    result++;
                }
            }
        }

        return result;
    }

    @Test
    public void test01() {
        assertEquals(5, projectionArea(new int[][]{{2}}));
        assertEquals(17, projectionArea(new int[][]{{1, 2}, {3, 4}}));
        assertEquals(8, projectionArea(new int[][]{{1, 0}, {0, 2}}));
        assertEquals(14, projectionArea(new int[][]{{1,1,1}, {1,0,1}, {1,1,1}}));
    }
}
