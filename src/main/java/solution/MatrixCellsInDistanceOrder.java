package solution;

import org.junit.Test;

import java.util.*;

/**
 * @author huanfeng.xu
 * @date 2019-07-16 21:09
 * @see <a href="https://leetcode.com/problems/matrix-cells-in-distance-order/">1030. Matrix Cells in Distance Order</a>
 */
public class MatrixCellsInDistanceOrder {
    // 没有想出来，直接参考答案
    public int[][] allCellsDistOrder(int R, int C, int r0, int c0) {
        int[][] result = new int[R * C][2];
        boolean[][] visit = new boolean[R][C];
        int i = 0;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{r0, c0});
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int r = cell[0];
            int c = cell[1];
            if (r < 0 || r >= R || c < 0 || c >= C) {
                continue;
            }
            if (visit[r][c]) {
                continue;
            }
            result[i] = cell;
            i++;
            visit[r][c] = true;

            queue.offer(new int[]{r - 1, c});
            queue.offer(new int[]{r + 1, c});
            queue.offer(new int[]{r, c - 1});
            queue.offer(new int[]{r, c + 1});
        }
        return result;
    }

    @Test
    public void test01() {
        System.out.println(Arrays.deepToString(allCellsDistOrder(1, 2, 0, 0)));
        System.out.println(Arrays.deepToString(allCellsDistOrder(2, 2, 0, 1)));
        System.out.println(Arrays.deepToString(allCellsDistOrder(2, 3, 1, 2)));
    }
}
