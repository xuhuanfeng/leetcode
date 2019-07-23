package solution;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author huanfeng.xu
 * @date 2019-07-23 22:30
 * @see <a href="https://leetcode.com/problems/reshape-the-matrix/">566. Reshape the Matrix</a>
 */
public class ReshapeTheMatrix {
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        int rr = nums.length;
        int cc = nums[0].length;

        if (rr * cc != r * c) {
            return nums;
        }

        int[][] data = new int[r][c];
        int indexR = 0, indexC = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                data[i][j] = nums[indexR][indexC++];
                if (indexC == cc) {
                    indexR++;
                    indexC = 0;
                }
            }
        }
        return data;
    }

    @Test
    public void test01() {
        int[][] matrix = new int[][]{{1, 2}, {3, 4}};
        System.out.println(Arrays.deepToString(matrixReshape(matrix, 1, 4)));
        System.out.println(Arrays.deepToString(matrixReshape(matrix, 2, 4)));
    }
}
