package solution;

import org.junit.Test;

import java.util.Arrays;
import java.util.Queue;

import static org.junit.Assert.assertEquals;

/**
 * @author huanfeng.xu
 * @date 2019-08-11 8:23
 * @see <a href="https://leetcode.com/problems/rotting-oranges/">994. Rotting Oranges</a>
 */
public class RottingOranges {
    private int[][] path = new int[][]{{1, 0}, {-1, 0}, {0, -1}, {0, 1}};
    private int[][] map;

    private void doFind(int[][] grid, int x, int y, int cnt) {
        if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y] == 0) {
            return;
        }
        if (map[x][y] > cnt) {
            map[x][y] = cnt;

            for (int[] ints : path) {
                int tx = x + ints[0];
                int ty = y + ints[1];
                doFind(grid, tx, ty, cnt + 1);
            }
        }
    }

    public int orangesRotting(int[][] grid) {
        map = new int[grid.length][grid[0].length];

        for (int i = 0; i < grid.length; i++) {
            Arrays.fill(map[i], Integer.MAX_VALUE);
        }

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 2) {

                    doFind(grid, i, j, 0);
                }
            }
        }

//        System.out.println(Arrays.deepToString(map));

        int max = 0;
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if (grid[i][j] == 1 && map[i][j] == Integer.MAX_VALUE) {
                    return -1;
                } else if (grid[i][j] == 1) {
                    if (map[i][j] > max) {
                        max = map[i][j];
                    }
                }
            }
        }
        return max;
    }

    @Test
    public void test01() {
        assertEquals(4, orangesRotting(new int[][]{{2, 1, 1}, {1, 1, 0}, {0, 1, 1}}));
        assertEquals(-1, orangesRotting(new int[][]{{2, 1, 1}, {0, 1, 1}, {1, 0, 1}}));
        assertEquals(0, orangesRotting(new int[][]{{0, 2}}));
        assertEquals(2, orangesRotting(new int[][]{{0, 0, 1, 2}, {2, 0, 1, 1}}));
        assertEquals(2, orangesRotting(new int[][]{{0, 1, 1, 2}, {0, 1, 1, 0}, {1, 1, 2, 0}}));
    }
}
