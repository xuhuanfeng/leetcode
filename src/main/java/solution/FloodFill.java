package solution;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author huanfeng.xu
 * @date 2019-08-03 22:09
 * @see <a href="https://leetcode.com/problems/flood-fill/">733. Flood Fill</a>
 */
public class FloodFill {

    public int[][] path = {{1, 0}, {-1, 0}, {0, -1}, {0, 1}};
    public boolean[][] visit;

    public void diFill(int x, int y, int[][] image, int oldColor, int newColor) {
        if (x < 0 || x >= image.length || y < 0 || y >= image[0].length) {
            return;
        }
        for (int[] ints : path) {
            int tx = ints[0] + x;
            int ty = ints[1] + y;
            if (tx >= 0 && tx < image.length && ty >= 0 && ty < image[0].length && !visit[tx][ty]) {
                if (image[tx][ty] == oldColor) {
                    image[tx][ty] = newColor;
                    visit[tx][ty] = true;
                    diFill(tx, ty, image, oldColor, newColor);
                }
            }
        }
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int color = image[sr][sc];
        visit = new boolean[image.length][image[0].length];
        for (boolean[] booleans : visit) {
            Arrays.fill(booleans, false);
        }
        image[sr][sc] = newColor;
        visit[sr][sc] = true;
        diFill(sr, sc, image, color, newColor);
        return image;
    }

    @Test
    public void test01() {
        int[][] data = new int[][]{{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};
        System.out.println(Arrays.deepToString(floodFill(data, 1, 1, 2)));

        data = new int[][]{{0, 0, 0}, {0, 1, 1}};
        System.out.println(Arrays.deepToString(floodFill(data, 1, 1, 1)));
    }
}
