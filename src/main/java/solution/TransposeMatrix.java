package solution;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author huanfeng.xu
 * @date 2019-07-16 22:12
 * @see <a href="https://leetcode.com/problems/transpose-matrix/">867. Transpose Matrix</a>
 */
public class TransposeMatrix {
    public int[][] transpose(int[][] A) {
        int r = A.length;
        int c = A[0].length;
        int[][] result = new int[c][r];
        for (int i = 0; i < c; i++) {
            for (int j = 0; j < r; j++) {
                result[i][j] = A[j][i];
            }
        }
        return result;
    }

    @Test
    public void test01() {
        System.out.println(Arrays.deepToString(transpose(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}})));
        System.out.println(Arrays.deepToString(transpose(new int[][]{{1, 2, 3}, {4, 5, 6}})));
    }
}
