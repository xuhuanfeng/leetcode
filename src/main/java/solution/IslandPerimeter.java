package solution;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author huanfeng.xu
 * @date 2019-07-21 8:50
 * @see <a href="https://leetcode.com/problems/island-perimeter/">463. Island Perimeter</a>
 */
public class IslandPerimeter {
    private int[][] path = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};

    public int islandPerimeter(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        boolean[][] visited = new boolean[row][col];
        int sum = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 1) {
//                    System.out.println(i + " = " + j);
                    sum += dfs(grid, visited, i, j, row, col);
                }
            }
        }
        return sum;
    }

    private int dfs(int[][] grid, boolean[][] visited, int r, int c, int row, int col) {
        if (r < 0 || r >= row || c < 0 || c >= col) {
            return 1;
        }
        if (visited[r][c]) {
            return 0;
        }
        if (grid[r][c] == 0) {
            return 1;
        }
        visited[r][c] = true;
        int sum = 0;
        for (int[] ints : path) {
            sum += dfs(grid, visited, r + ints[0], c + ints[1], row, col);
        }
        return sum;
    }

    public int another(int[][] grid) {
        int result = 0;
        int row = grid.length;
        int col = grid[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 1) {
                    result += 4;
                    if (i > 0 && grid[i - 1][j] == 1) {
                        result -= 2;
                    }
                    if (j > 0 && grid[i][j - 1] == 1) {
                        result -= 2;
                    }
                }
            }
        }
        return result;
    }

    @Test
    public void test01() {
        assertEquals(16, islandPerimeter(
                new int[][]{{0, 1, 0, 0}, {1, 1, 1, 0}, {0, 1, 0, 0}, {1, 1, 0, 0}}));
    }

    @Test
    public void test02() {
        assertEquals(16, another(
                new int[][]{{0, 1, 0, 0}, {1, 1, 1, 0}, {0, 1, 0, 0}, {1, 1, 0, 0}}));
    }
}
