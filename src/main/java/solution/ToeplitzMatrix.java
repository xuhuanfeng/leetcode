package solution;

import org.junit.Test;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

/**
 * @author huanfeng.xu
 * @date 2019-07-21 8:14
 * @see <a href="https://leetcode.com/problems/toeplitz-matrix/">766. Toeplitz Matrix</a>
 */
public class ToeplitzMatrix {
    public boolean isToeplitzMatrix(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;

        for (int i = 1; i < row; i++) {
            if (!judge(i, 1, row, col, matrix)) {
                return false;
            }
        }

        for (int i = 1; i < col; i++) {
            if (!judge(1, i, row, col, matrix)) {
                return false;
            }
        }
        return true;
    }

    private boolean judge(int tI, int j, int row, int col, int[][] matrix) {
        while (tI < row && j < col) {
            if (matrix[tI - 1][j - 1] != matrix[tI][j]) {
                return false;
            }
            tI++;
            j++;
        }
        return true;
    }

    public boolean another(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        for (int i = 0; i < row - 1; i++) {
            for (int j = 0; j < col - 1; j++) {
                if (matrix[i][j] != matrix[i + 1][j + 1]) {
                    return false;
                }
            }
        }
        return true;
    }

    @Test
    public void test01() {
        assertTrue(isToeplitzMatrix(new int[][]
                {{1, 2, 3, 4},
                        {5, 1, 2, 3},
                        {9, 5, 1, 2}}));

        assertFalse(isToeplitzMatrix(new int[][]{{1, 2}, {2, 2}}));
    }

    @Test
    public void test02() {
        assertTrue(another(new int[][]
                {{1, 2, 3, 4},
                        {5, 1, 2, 3},
                        {9, 5, 1, 2}}));

        assertFalse(another(new int[][]{{1, 2}, {2, 2}}));
    }
}
