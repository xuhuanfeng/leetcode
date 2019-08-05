package solution;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author huanfeng.xu
 * @date 2019-08-05 21:24
 * @see <a href="https://leetcode.com/problems/image-smoother/">661. Image Smoother</a>
 */
public class ImageSmoother {
    private int[][] path = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};

    public int[][] imageSmoother(int[][] M) {
        int[][] result = new int[M.length][M[0].length];
        for (int i = 0; i < M.length; i++) {
            for (int j = 0; j < M[0].length; j++) {
                int sum = M[i][j];
                int cnt = 1;
                for (int[] ints : path) {
                    int tx = i + ints[0];
                    int ty = j + ints[1];
                    if (tx >= 0 && tx < M.length && ty >= 0 && ty < M[0].length) {
                        cnt++;
                        sum += M[tx][ty];
                    }
                }
                result[i][j] = sum / cnt;
            }
        }
        return result;
    }

    @Test
    public void test01() {
        System.out.println(Arrays.deepToString(imageSmoother(new int[][]{{1, 1, 1}, {1, 0, 1}, {1, 1, 1}})));
    }
}
